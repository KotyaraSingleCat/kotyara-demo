package com.kotyara.repository;

import com.kotyara.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class JpaRepositoryUserImpl implements AbstractRepository<User> {

  @Autowired
  EntityManager entityManager;

  @Transactional
  @Override
  public List<User> getAll() {
    TypedQuery<User> fromUser = entityManager.createQuery("FROM User", User.class);
    fromUser.setLockMode(LockModeType.PESSIMISTIC_WRITE);
    return fromUser.getResultList();
  }

  @Transactional
  @Override
  public void create(User user) {
    entityManager.createNativeQuery("INSERT INTO users (firstName, lastName, email, password, role_id) VALUES (?,?,?,?,?)")
        .setParameter(1, user.getFirstName())
        .setParameter(2, user.getLastName())
        .setParameter(3, user.getEmail())
        .setParameter(4, user.getPassword())
        .setParameter(5, user.getRole().getId())
        .executeUpdate();
  }

  @Override
  public User getById(int id) {
    return entityManager.find(User.class, id);
  }
}
