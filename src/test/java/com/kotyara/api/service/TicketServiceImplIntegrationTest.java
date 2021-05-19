package com.kotyara.api.service;

import com.kotyara.api.entity.Ticket;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@ContextConfiguration(initializers = {TicketServiceImplIntegrationTest.Initializer.class})
@SpringBootTest
@Slf4j
public class TicketServiceImplIntegrationTest {

  @Autowired
  private TicketServiceImpl service;

  @Test
  public void testOfGetAllTickets() {
    List<Ticket> all = service.getAll();
    Assertions.assertEquals(5, all.size());
  }

  @Test
  public void testGettingTicketById() {
    Ticket ticket = service.getById(2);
    Assertions.assertEquals("Qdd AWS", ticket.getName());
  }

  static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
      TestPropertyValues.of(
          "spring.datasource.url=" + "jdbc:mysql://localhost:3306/bug-tracker?useSSL=false&serverTimezone=Europe/Kiev&allowPublicKeyRetrieval=true",
          "spring.datasource.username=" + "kotyara",
          "spring.datasource.password=" + "kotyara"
      ).applyTo(configurableApplicationContext.getEnvironment());
    }
  }
}