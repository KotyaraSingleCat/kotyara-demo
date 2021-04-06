package com.kotyara.api.service;

import com.kotyara.api.dto.TicketDTO;
import com.kotyara.api.entity.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements AbstractService<Ticket, TicketDTO> {

  @Override
  public void create(TicketDTO ticketDTO) {

  }

  @Override
  public List<Ticket> getAll() {
    return null;
  }

  @Override
  public Ticket getById(int id) {
    return null;
  }

  @Override
  public void remove(int id) {

  }
}
