package com.kotyara.api.controller;

import com.kotyara.api.abstractcrud.controller.AbstractControllerImpl;
import com.kotyara.api.dto.TicketDTO;
import com.kotyara.api.entity.Ticket;
import com.kotyara.api.service.TicketServiceImpl;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ticket")
public class TicketController extends AbstractControllerImpl<Ticket, TicketDTO> {

  public TicketController(TicketServiceImpl service) {
    super(service);
  }

  @Override
  public void create(@Validated({TicketDTO.New.class}) TicketDTO ticketDTO) {
    super.create(ticketDTO);
  }
}
