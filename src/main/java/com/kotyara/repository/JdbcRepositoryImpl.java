package com.kotyara.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcRepositoryImpl<T> implements AbstractRespository {

  private JdbcTemplate jdbcTemplate;

  @Autowired
  public JdbcRepositoryImpl(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Override
  public List<T> getAll() {
    return null;
  }

  @Override
  public void create() {

  }
}