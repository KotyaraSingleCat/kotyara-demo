package com.kotyara.api.service;

import com.kotyara.api.dto.UserDTO;
import com.kotyara.api.entity.User;
import com.kotyara.repository.AbstractRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements AbstractService<User, UserDTO> {

  private final AbstractRepository<User, UserDTO> jdbcRepository;

  @Override
  public void create(UserDTO user) {
    jdbcRepository.create(user);
  }

  @Override
  public List<User> getAll() {
    return jdbcRepository.getAll();
  }
}
