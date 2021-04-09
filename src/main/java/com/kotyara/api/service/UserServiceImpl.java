package com.kotyara.api.service;

import com.kotyara.api.dto.UserDTO;
import com.kotyara.api.entity.User;
import com.kotyara.api.entity.UserRole;
import com.kotyara.repository.AbstractRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements AbstractService<User, UserDTO> {

  @Autowired
  private final AbstractRepository<User> jpaRepository;

  @Override
  public void create(UserDTO user) {
    jpaRepository.create(convertToEntity(user));
  }

  @Override
  public List<User> getAll() {
    return jpaRepository.getAll();
  }

  @Override
  public User getById(int id) {
    return jpaRepository.getById(id);
  }

  @Override
  public void remove(int id) {

  }

  private User convertToEntity(UserDTO userDTO){
    UserRole role = new UserRole();
    role.setId(userDTO.getRole_id());
    User user = new User(null, userDTO.getFirstName(),
                          userDTO.getLastName(),
                          userDTO.getEmail(),
                          userDTO.getPassword(),
                          role);
    return user;
  }

  private UserDTO convertToDTO(User user){
    UserDTO userDTO = new UserDTO(user.getFirstName(),
                                  user.getLastName(),
                                  user.getEmail(),
                                  user.getPassword(),
                                  user.getRole().getId());
    return userDTO;
  }
}
