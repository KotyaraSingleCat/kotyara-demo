package com.kotyara.api.service;

import com.kotyara.api.entity.User;
import com.kotyara.repository.JdbcTestConnectionPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestConnectionPoolService implements AbstractService<User>{

  @Autowired
  private JdbcTestConnectionPool jdbcTestConnectionPool;

  @Override
  public void create(User user) {
    jdbcTestConnectionPool.create(user);
  }

  @Override
  public List<User> getAll() {
    return jdbcTestConnectionPool.getAll();
  }
}
