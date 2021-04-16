package com.kotyara.api.abstractcrud.service.convertor;

import com.kotyara.api.dto.TicketDTO;
import com.kotyara.api.entity.Ticket;
import com.kotyara.api.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TicketConvertor implements AbstractConvert<Ticket, TicketDTO> {

  @Override
  public Ticket convertToEntity(TicketDTO ticketDTO) {

    User user = new User();
    user.setId(ticketDTO.getReporter_id());

    Ticket ticket = new Ticket(null,
        ticketDTO.getName(),
        ticketDTO.getDescription(),
        user,
        ticketDTO.getStatus(),
        ticketDTO.getPriority(),
        ticketDTO.getTimeSpent(),
        ticketDTO.getEstimated(),
        LocalDateTime.parse(ticketDTO.getCreatedDate()),
        ticketDTO.getType());

    return ticket;
  }

  @Override
  public TicketDTO covertToDTO(Ticket ticket) {

    TicketDTO ticketDTO = new TicketDTO(ticket.getId(),
        ticket.getName(),
        ticket.getDescription(),
        ticket.getReporter().getId(),
        ticket.getStatus(),
        ticket.getPriority(),
        ticket.getTimeSpent(),
        ticket.getTimeEstimated(),
        ticket.getCreatedDate().toString(),
        ticket.getType());

    return ticketDTO;
  }
}
