package com.kotyara.repository;

import com.kotyara.api.dto.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.util.List;

public interface AbstractRespository<T> {

  RowMapper<User> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> {
    return new User(resultSet.getInt("id"), resultSet.getString("firstName"), resultSet.getString("lastName"), resultSet.getString("email"));
  };

  List<T> getAll();

  void create();
}
