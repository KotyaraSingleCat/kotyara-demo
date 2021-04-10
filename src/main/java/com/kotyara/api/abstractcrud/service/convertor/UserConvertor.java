package com.kotyara.api.abstractcrud.service.convertor;

import com.kotyara.api.dto.UserDTO;
import com.kotyara.api.entity.User;
import com.kotyara.api.entity.UserRole;
import org.springframework.stereotype.Component;

@Component
public class UserConvertor implements AbstractConvert<User, UserDTO> {

  @Override
  public User convertToEntity(UserDTO userDTO) {

    UserRole role = new UserRole();
    role.setId(userDTO.getRole_id());
    User user = new User(null, userDTO.getFirstName(),
        userDTO.getLastName(),
        userDTO.getEmail(),
        userDTO.getPassword(),
        role);
    return user;

  }

  @Override
  public UserDTO covertToDTO(User user) {

    UserDTO userDTO = new UserDTO(user.getFirstName(),
        user.getLastName(),
        user.getEmail(),
        user.getPassword(),
        user.getRole().getId());

    return userDTO;
  }
}
