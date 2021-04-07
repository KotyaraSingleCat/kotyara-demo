package com.kotyara.configuration;

import com.kotyara.api.TimeEstimatedItemProcessor;
import com.kotyara.api.entity.Ticket;
import com.kotyara.api.service.TicketPreparedStatementSetter;
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
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

  /**
   * Read all tickets from database. Maybe should read only time?
   * Create in TicketService method.
   * @param dataSource - connection to database
   * @return
   */
  @Bean
  public ItemReader<Ticket> reader(DataSource dataSource) {
    return new JdbcCursorItemReaderBuilder<Ticket>()
        .name("cursorItemReader")
        .dataSource(dataSource)
        .sql("SELECT * FROM tickets")
        .rowMapper(new BeanPropertyRowMapper<>(Ticket.class))
        .build();
  }

  /**
   * Processor which will calculated time.
   * @return
   */
  @Bean
  public ItemProcessor<Ticket, Ticket> processor() {
    return new TimeEstimatedItemProcessor();
  }

  /**
   * Update ticket information in database.
   * @param dataSource
   * @return
   */
  @Bean
  public ItemWriter<Ticket> writer(DataSource dataSource) {
    ItemPreparedStatementSetter<Ticket> valueSetter = new TicketPreparedStatementSetter();
    return new JdbcBatchItemWriterBuilder<Ticket>()
        .dataSource(dataSource)
        .sql("UPDATE * SET status = ? WHERE id = ?")
        .itemPreparedStatementSetter(valueSetter)
        .build();
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
