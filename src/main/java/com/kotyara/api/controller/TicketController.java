package com.kotyara.api.controller;

import com.kotyara.api.dto.TicketDTO;
import com.kotyara.api.dto.UserDTO;
import com.kotyara.api.entity.Ticket;
import com.kotyara.api.entity.User;
import com.kotyara.api.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

  @Autowired
  private AbstractService<Ticket, TicketDTO> ticketService;

  @GetMapping("/{id}")
  public ResponseEntity<Ticket> getById(@PathVariable int id){
    Ticket ticket = ticketService.getById(id);
    if (ticket == null) {
      return ResponseEntity.notFound().build();
    } else {
      return ResponseEntity.ok(ticket);
    }
  }

  @GetMapping
  public List<Ticket> getAll(){
    return ticketService.getAll();
  }

  @PostMapping
  public void create(@RequestBody TicketDTO ticketDTO){
    ticketService.create(ticketDTO);
  }

}
