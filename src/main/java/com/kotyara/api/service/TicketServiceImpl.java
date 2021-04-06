package com.kotyara.api.service;

import com.kotyara.api.dto.TicketDTO;
import com.kotyara.api.dto.UserDTO;
import com.kotyara.api.entity.Ticket;
import com.kotyara.api.entity.User;
import com.kotyara.api.entity.UserRole;
import com.kotyara.repository.AbstractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

@Service
public class TicketServiceImpl implements AbstractService<Ticket, TicketDTO> {

  @Autowired
  @Qualifier("jpaTicketRepository")
  private AbstractRepository<Ticket> jpaRepository;

  @Override
  public void create(TicketDTO ticketDTO) {
    jpaRepository.create(convertToEntity(ticketDTO));
  }

  @Override
  public List<Ticket> getAll() {
    return jpaRepository.getAll();
  }

  @Override
  public Ticket getById(int id) {
    return jpaRepository.getById(id);
  }

  @Override
  public void remove(int id) { jpaRepository.remove(id); }

  private Ticket convertToEntity(TicketDTO ticketDTO){
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
                                  LocalDate.parse(ticketDTO.getCreatedDate()),
                                  ticketDTO.getType());
    return ticket;
  }

  private TicketDTO convertToDTO(Ticket ticket){
    TicketDTO ticketDTO = new TicketDTO(ticket.getName(),
        ticket.getDescription(),
        ticket.getReporter().getId(),
        ticket.getStatus(),
        ticket.getPriority(),
        ticket.getTimeSpent(),
        ticket.getEstimated(),
        ticket.getCreatedDate().toString(),
        ticket.getType());
    return ticketDTO;
  }
}
