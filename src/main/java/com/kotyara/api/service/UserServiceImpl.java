package com.kotyara.api.service;

import com.kotyara.api.abstractcrud.service.AbstractServiceImpl;
import com.kotyara.api.abstractcrud.service.convertor.AbstractConvert;
import com.kotyara.api.abstractcrud.service.convertor.UserConvertor;
import com.kotyara.api.dto.UserDTO;
import com.kotyara.api.entity.User;
import com.kotyara.repository.jpa.JpaRepositoryUserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractServiceImpl<User, UserDTO> {

  @Autowired
  private JpaRepositoryUserImpl repository;

  private UserConvertor convertor;

  public UserServiceImpl(JpaRepositoryUserImpl repository, AbstractConvert<User, UserDTO> converter) {
    super(repository, converter);
    this.repository = repository;
  }

  public User updatePassword(UserDTO userDTO){
    return repository.updatePassword(convertor.convertToEntity(userDTO));
  }
}
