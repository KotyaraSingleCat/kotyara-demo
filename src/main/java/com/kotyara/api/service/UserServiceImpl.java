package com.kotyara.api.service;

import com.kotyara.api.entity.User;
import com.kotyara.repository.AbstractRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class UserServiceImpl implements AbstractService<User> {

  private final AbstractRepository<User> jdbcRepository;

  @Override
  public void createUser(User user) {
    jdbcRepository.create(user);
  }

  @Override
  public List<User> getAll() {
    return jdbcRepository.getAll();
  }
}
