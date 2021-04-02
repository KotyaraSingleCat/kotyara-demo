package com.kotyara.repository;

import com.kotyara.api.entity.Ticket;

import java.util.List;

public class JpaRepositoryTicketImpl implements AbstractRepository<Ticket> {

  @Override
  public List<Ticket> getAll() {
    return null;
  }

  @Override
  public void create(Ticket ticket) {

  }

  @Override
  public Ticket getById(int id) {
    return null;
  }
}
