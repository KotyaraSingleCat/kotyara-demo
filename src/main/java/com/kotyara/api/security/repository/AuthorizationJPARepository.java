package com.kotyara.api.security.repository;

import com.kotyara.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorizationJPARepository extends JpaRepository<User, Integer> {
  User findByEmail(String email);
}
