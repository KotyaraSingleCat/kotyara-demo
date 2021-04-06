package com.kotyara.repository;

import com.kotyara.api.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class JpaRepositoryTicketImpl implements AbstractRepository<Ticket> {

  @Autowired
  EntityManager entityManager;

  @Transactional
  @Override
  public List<Ticket> getAll() {
    TypedQuery<Ticket> fromTicket = entityManager.createQuery("FROM Ticket", Ticket.class);
    fromTicket.setLockMode(LockModeType.PESSIMISTIC_WRITE);
    return fromTicket.getResultList();
  }

  @Transactional
  @Override
  public void create(Ticket ticket) {
    entityManager.persist(ticket);
  }

  @Transactional
  @Override
  public Ticket getById(int id) {
    return entityManager.find(Ticket.class, id);
  }
}
