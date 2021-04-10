package com.kotyara.api.controller;

import com.kotyara.api.abstractcrud.controller.AbstractControllerImpl;
import com.kotyara.api.dto.UserDTO;
import com.kotyara.api.entity.User;
import com.kotyara.api.service.UserServiceImpl;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController extends AbstractControllerImpl<User, UserDTO> {

  public UserController(UserServiceImpl userService) {
    super(userService);
  }
}
