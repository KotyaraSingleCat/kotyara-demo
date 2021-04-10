package com.kotyara.repository.jdbc;

import com.kotyara.api.entity.Ticket;
import com.kotyara.api.abstractcrud.repository.AbstractRepository;

import java.util.List;

public class JdbcRepositoryTicketImpl implements AbstractRepository <Ticket> {

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

  @Override
  public void remove(int id) {

  }
}
