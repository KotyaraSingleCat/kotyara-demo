package com.kotyara.api.controller;

import java.util.List;

import com.kotyara.api.dto.UserDTO;
import com.kotyara.api.entity.User;
import com.kotyara.api.entity.UserRole;
import com.kotyara.api.service.TestConnectionPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/connectionPool")
public class TestConnectionPoolController {

  @Autowired
  private TestConnectionPoolService service;

  @GetMapping
  public List<User> getAll(){
    List<User> users = service.getAll();
    return users;
  }

  @PostMapping
  public ResponseEntity create(@RequestBody UserDTO userDTO){
    service.create(new User(0, userDTO.getFirstName(), userDTO.getLastName(), userDTO.getEmail(),
        userDTO.getPassword(), UserRole.valueOf(userDTO.getRole())));
    return ResponseEntity.ok().build();
  }
}
