package com.kotyara.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kotyara.api.dto.TicketDTO;
import com.kotyara.api.service.TicketServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

//@RunWith(SpringRunner.class)
@WebMvcTest(value = TicketController.class)
public class TicketControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private TicketServiceImpl ticketService;

  public static TicketDTO ticketDTO;

  @BeforeAll
  static void beforeAll() {
    ticketDTO = new TicketDTO(null, "ticket", "new ticket", 1, "ACTIVE", "HIGH", null, null,null, null);
  }

  @Test
  public void testOfCreatingTicket() throws Exception {
    ticketService.create(ticketDTO);

    mvc.perform(MockMvcRequestBuilders
        .post("/ticket")
        .contentType(MediaType.APPLICATION_JSON)
        .content(stringify(ticketDTO)))
        .andDo(print());

    ArgumentCaptor<TicketDTO> requestCaptor = ArgumentCaptor.forClass(TicketDTO.class);
    verify(ticketService).create(requestCaptor.capture());
    assertFalse(requestCaptor.getAllValues().isEmpty());
    TicketDTO capturedArgument = requestCaptor.getValue();
    assertNull(capturedArgument.getId());
  }

  @Test
  public void testOfGetAllTickets() throws Exception {
    mvc.perform(MockMvcRequestBuilders
        .get("/ticket")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(MockMvcResultMatchers.status().isOk());

    verify(ticketService).getAll();
  }

  @Test
  public void testOfDeletingTickets() throws Exception {
    mvc.perform(MockMvcRequestBuilders
        .delete("/ticket/2")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(MockMvcResultMatchers.status().isOk());

    verify(ticketService).remove(2);
  }

  @Test
  public void testGettingTicketById() throws Exception {
    mvc.perform(MockMvcRequestBuilders
        .get("/ticket/2")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(MockMvcResultMatchers.status().is(404));

    verify(ticketService).getById(2);
  }

  private String stringify(TicketDTO dto) throws JsonProcessingException {
    return new ObjectMapper().writeValueAsString(dto);
  }
}