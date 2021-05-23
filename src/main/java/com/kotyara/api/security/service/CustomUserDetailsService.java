package com.kotyara.api.security.service;

import com.kotyara.api.entity.User;
import com.kotyara.api.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
  @Autowired
  private AuthorizationService service;

  @Override
  public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User userEntity = service.findByLogin(username);
    return CustomUserDetails.fromUserEntityToCustomUserDetails(userEntity);
  }
}
