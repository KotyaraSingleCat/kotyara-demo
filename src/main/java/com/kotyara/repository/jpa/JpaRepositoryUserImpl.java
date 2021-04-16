package com.kotyara.repository.jpa;

import com.kotyara.api.entity.User;
import com.kotyara.api.entity.UserRole;
import com.kotyara.api.abstractcrud.repository.AbstractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Primary
@Repository("jpaUserRepository")
public class JpaRepositoryUserImpl implements AbstractRepository<User> {

  @Autowired
  EntityManager entityManager;

  @EntityGraph(value = "graph.UserRoleActionPoint", type = EntityGraph.EntityGraphType.LOAD)
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
    UserRole role = entityManager.find(UserRole.class, user.getRole().getId());
    user.setRole(role);
    entityManager.persist(user);
  }

  @Transactional
  @Override
  public User getById(int id) {
    return entityManager.find(User.class, id);
  }

  @Transactional
  @Override
  public void remove(int id) {
    User user = entityManager.find(User.class, id);
    entityManager.remove(user);
  }

//  @Transactional
//  public User updatePassword(User user) {
//    User findUser = entityManager.find(User.class, user.getId());
//    entityManager.getTransaction().begin();
//    findUser.setPassword(user.getPassword());
//    entityManager.getTransaction().commit();
//    return findUser;
//  }
}
