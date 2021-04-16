package com.kotyara.api.controller;

import com.kotyara.api.abstractcrud.controller.AbstractControllerImpl;
import com.kotyara.api.dto.UserDTO;
import com.kotyara.api.entity.User;
import com.kotyara.api.service.UserServiceImpl;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends AbstractControllerImpl<User, UserDTO> {

  private UserServiceImpl userService;

  public UserController(UserServiceImpl userService) {
    super(userService);
    this.userService = userService;
  }

  @Override
  public void create(@Validated({UserDTO.New.class})UserDTO userDTO) {
    super.create(userDTO);
  }

//  @PutMapping
//  public ResponseEntity<User> updatePassword(@RequestBody UserDTO userDTO) {
//    User user = userService.updatePassword(userDTO);
//    if (user == null) {
//      return ResponseEntity.notFound().build();
//    } else {
//      return ResponseEntity.ok(user);
//    }
//  }
}
