package com.kotyara.api.service;

import com.kotyara.api.abstractcrud.repository.AbstractRepository;
import com.kotyara.api.abstractcrud.service.convertor.AbstractConvert;
import com.kotyara.api.dto.TicketDTO;
import com.kotyara.api.entity.Ticket;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class TicketServiceImplTest {

  private static TicketServiceImpl ticketService;

  private static TicketDTO dto;

  private static AbstractRepository<Ticket> repository = Mockito.mock(AbstractRepository.class);

  private static AbstractConvert<Ticket, TicketDTO> converter = Mockito.mock(AbstractConvert.class);

  @BeforeAll
  static void beforeAll() {
    dto = new TicketDTO(null, "ticket", "new ticket", 1, "ACTIVE", "HIGH", null, null,null, null);
    ticketService = new TicketServiceImpl(repository, converter);
  }

  @Test
  public void testOfCreatingTicket() {
    ticketService.create(dto);
    verify(converter).convertToEntity(dto);
    verify(repository).create(converter.convertToEntity(dto));
  }

  @Test
  public void testOfDeletingTickets() {
    ticketService.remove(2);
    verify(repository).remove(2);
  }
}