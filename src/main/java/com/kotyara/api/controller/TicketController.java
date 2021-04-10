package com.kotyara.api.controller;

import com.kotyara.api.abstractcrud.controller.AbstractControllerImpl;
import com.kotyara.api.abstractcrud.service.AbstractService;
import com.kotyara.api.dto.TicketDTO;
import com.kotyara.api.entity.Ticket;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ticket")
public class TicketController extends AbstractControllerImpl<Ticket, TicketDTO> {

  public TicketController(AbstractService<Ticket, TicketDTO> service) {
    super(service);
  }
}
