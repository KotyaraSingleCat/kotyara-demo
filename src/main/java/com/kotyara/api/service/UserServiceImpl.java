package com.kotyara.api.service;

import com.kotyara.api.entity.User;
import com.kotyara.repository.AbstractRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements AbstractService<User> {

  private final AbstractRespository<User> jdbcRepository;

  @Autowired
  public UserServiceImpl(AbstractRespository<User> jdbcRepository) {
    this.jdbcRepository = jdbcRepository;
  }

  @Override
  public void createUser(User user) {
    jdbcRepository.create(user);
  }

  @Override
  public List<User> getAll() {
    return jdbcRepository.getAll();
  }
}
