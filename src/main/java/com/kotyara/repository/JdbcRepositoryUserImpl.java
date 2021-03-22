package com.kotyara.repository;

import com.kotyara.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class JdbcRepositoryUserImpl implements AbstractRepository<User> {

  @Autowired
  EntityManager entityManager;

  @Transactional
  @Override
  public List<User> getAll() {
    TypedQuery<User> fromUser = entityManager.createQuery("from User", User.class);
    fromUser.setLockMode(LockModeType.PESSIMISTIC_WRITE);
    return fromUser.getResultList();
  }

  @Transactional
  @Override
  public void create(User user) {

  }
}
