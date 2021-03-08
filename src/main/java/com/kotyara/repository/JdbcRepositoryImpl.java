package com.kotyara.repository;

import com.kotyara.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Component
public final class JdbcRepositoryImpl implements AbstractRespository<User> {

  private JdbcTemplate jdbcTemplate;

  @Autowired
  public JdbcRepositoryImpl(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Override
  public List<User> getAll() {
    return jdbcTemplate.query("SELECT * FROM user", ROW_MAPPER);
  }

  @Override
  public void create(User user) {
    jdbcTemplate.update("INSERT INTO user(firstName, lastName, email) VALUES (?, ?, ?)",
                        user.getFirstName(),
                        user.getSecondName(),
                        user.getEmail());
  }
}
