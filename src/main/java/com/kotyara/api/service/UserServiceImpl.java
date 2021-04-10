package com.kotyara.api.service;

import com.kotyara.api.abstractcrud.repository.AbstractRepository;
import com.kotyara.api.abstractcrud.service.AbstractServiceImpl;
import com.kotyara.api.abstractcrud.service.convertor.AbstractConvert;
import com.kotyara.api.dto.UserDTO;
import com.kotyara.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractServiceImpl<User, UserDTO> {

  @Autowired
  public UserServiceImpl(AbstractRepository<User> repository, AbstractConvert<User, UserDTO> converter) {
    super(repository, converter);
  }
}
