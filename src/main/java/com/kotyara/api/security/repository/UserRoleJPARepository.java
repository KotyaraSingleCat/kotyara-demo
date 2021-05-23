package com.kotyara.api.security.repository;

import com.kotyara.api.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleJPARepository extends JpaRepository<UserRole, Integer> {
  UserRole findByRole(String role);
}
