package com.kotyara.api.security.service;

import com.kotyara.api.abstractcrud.service.convertor.AbstractConvert;
import com.kotyara.api.dto.UserDTO;
import com.kotyara.api.entity.User;
import com.kotyara.api.security.repository.AuthorizationJPARepository;
import com.kotyara.api.security.repository.UserRoleJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService  {
  @Autowired
  private AuthorizationJPARepository authorizationJPARepository;

  @Autowired
  private UserRoleJPARepository roleJPARepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private AbstractConvert<User, UserDTO> converter;

  public User createUser(UserDTO dto) {
    dto.setPassword(passwordEncoder.encode(dto.getPassword()));
    User userEntity = converter.convertToEntity(dto);
    return authorizationJPARepository.save(userEntity);
  }

  public User findByLogin(String email) {
    return authorizationJPARepository.findByEmail(email);
  }

  public User findByLoginAndPassword(String email, String password) {
    User user = findByLogin(email);
    if (user != null) {
      if (passwordEncoder.matches(password, user.getPassword())) {
        return user;
      }
    }
    return null;
  }

}
