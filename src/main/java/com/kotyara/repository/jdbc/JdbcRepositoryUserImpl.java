package com.kotyara.repository.jdbc;

import com.kotyara.api.entity.User;
import com.kotyara.api.entity.UserRole;
import com.kotyara.api.abstractcrud.repository.AbstractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

@Component("jdbcUserRepository")
public class JdbcRepositoryUserImpl implements AbstractRepository<User> {

  private final RowMapper<User> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> new User(resultSet.getInt("id"), resultSet.getString("firstName"), resultSet.getString("lastName"), resultSet.getString("email"), resultSet.getString("password"), new UserRole(resultSet.getInt("role_id"), null, null));

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
    jdbcTemplate.update("INSERT INTO user(firstName, lastName, email, password, role_id) VALUES (?, ?, ?, ?, ?)",
        user.getFirstName(),
        user.getLastName(),
        user.getEmail(),
        user.getPassword(),
        user.getRole().getId());
  }

  @Override
  public User getById(int id) {
    return null;
  }

  @Override
  public void remove(int id) {

  }
}
