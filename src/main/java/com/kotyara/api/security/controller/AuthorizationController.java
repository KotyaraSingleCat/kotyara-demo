package com.kotyara.api.security.controller;

import com.kotyara.api.dto.AuthorizationDTO;
import com.kotyara.api.dto.AuthorizationResponse;
import com.kotyara.api.dto.UserDTO;
import com.kotyara.api.entity.User;
import com.kotyara.api.security.jwt.JwtProvider;
import com.kotyara.api.security.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorizationController {
  @Autowired
  AuthorizationService authorizationService;
  @Autowired
  private JwtProvider jwtProvider;

  @PostMapping("/authorization")
  public AuthorizationResponse authorization(@RequestBody AuthorizationDTO request){
    User userEntity = authorizationService.findByLoginAndPassword(request.getEmail(), request.getPassword());
    String token = jwtProvider.generateToken(userEntity.getEmail());
    return new AuthorizationResponse(token);
  }

  @PostMapping("/register")
  public String registration(@RequestBody UserDTO userDTO){
    authorizationService.createUser(userDTO);
    return "OK";
  }
}
