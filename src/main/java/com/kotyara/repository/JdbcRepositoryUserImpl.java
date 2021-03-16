package com.kotyara.repository;

import com.kotyara.api.entity.User;
import com.kotyara.api.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

@Component
public final class JdbcRepositoryUserImpl implements AbstractRepository<User> {

  private final RowMapper<User> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> new User(resultSet.getInt("id"), resultSet.getString("firstName"), resultSet.getString("lastName"), resultSet.getString("email"), resultSet.getString("password"), UserRole.valueOf(resultSet.getString("role")));

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public JdbcRepositoryUserImpl(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Override
  public List<User> getAll() {
    return jdbcTemplate.query("SELECT * FROM user", ROW_MAPPER);
  }

  @Override
  public void create(User user) {
    jdbcTemplate.update("INSERT INTO user(firstName, lastName, email, password, role) VALUES (?, ?, ?, ?, ?)",
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail(),
                        user.getPassword(),
                        user.getRole());
  }
}
