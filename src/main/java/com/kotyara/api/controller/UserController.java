package com.kotyara.api.controller;

import com.kotyara.api.dto.UserDTO;
import com.kotyara.api.entity.User;
import com.kotyara.api.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private AbstractService<User, UserDTO> userService;

  @GetMapping("/{id}")
  public ResponseEntity<User> getById(@PathVariable int id){
    User user = userService.getById(id);
    if (user == null) {
      return ResponseEntity.notFound().build();
    } else {
      return ResponseEntity.ok(user);
    }
  }

  @GetMapping
  public List<User> getAll(){
    return userService.getAll();
  }

  @PostMapping
  public void create(@RequestBody UserDTO userDTO){
    userService.create(userDTO);
  }
}
