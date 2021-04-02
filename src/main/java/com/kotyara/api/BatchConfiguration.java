package com.kotyara.api;

import com.kotyara.api.entity.Ticket;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

  @Bean
  public ItemReader<Ticket> reader(DataSource dataSource) {
    return new JdbcCursorItemReaderBuilder<Ticket>()
        .name("cursorItemReader")
        .dataSource(dataSource)
        .sql("SELECT * FROM tickets")
        .rowMapper(new BeanPropertyRowMapper<>(Ticket.class))
        .build();
  }

  @Bean
  public ItemProcessor<Ticket, Ticket> processor() {
    return new TimeEstimatedItemProcessor();
  }

  @Bean
  public ItemWriter<Ticket> writer(DataSource dataSource) {
    JdbcBatchItemWriter<Ticket> writer = new JdbcBatchItemWriter<>();
    writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Ticket>());
    writer.setSql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)");
    writer.setDataSource(dataSource);
    return writer;
  }

  @Bean
  public Job importUserJob(JobBuilderFactory jobs, Step s1) {
    return jobs.get("importUserJob")
        .incrementer(new RunIdIncrementer())
        .flow(s1)
        .end()
        .build();
  }

  @Bean
  public Step step1(StepBuilderFactory stepBuilderFactory, ItemReader<Ticket> reader,
      ItemWriter<Ticket> writer, ItemProcessor<Ticket, Ticket> processor) {
    return stepBuilderFactory.get("step1")
        .<Ticket, Ticket> chunk(10)
        .reader(reader)
        .processor(processor)
        .writer(writer)
        .build();
  }

  @Bean
  public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }

}
