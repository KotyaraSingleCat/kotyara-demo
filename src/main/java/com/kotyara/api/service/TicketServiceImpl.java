package com.kotyara.api.service;

import com.kotyara.api.abstractcrud.repository.AbstractRepository;
import com.kotyara.api.abstractcrud.service.AbstractServiceImpl;
import com.kotyara.api.abstractcrud.service.convertor.AbstractConvert;
import com.kotyara.api.dto.TicketDTO;
import com.kotyara.api.entity.Ticket;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl extends AbstractServiceImpl<Ticket, TicketDTO> {

  public TicketServiceImpl(AbstractRepository<Ticket> repository, AbstractConvert<Ticket, TicketDTO> converter) {
    super(repository, converter);
  }
}
