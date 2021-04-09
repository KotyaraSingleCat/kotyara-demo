package com.kotyara.api;

import com.kotyara.api.entity.Ticket;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class TicketPreparedStatementSetter implements ItemPreparedStatementSetter<Ticket> {

  @Override
  public void setValues(Ticket ticket, PreparedStatement preparedStatement) throws SQLException {
    preparedStatement.setString(1, ticket.getStatus());
    preparedStatement.setInt(2, ticket.getId());
  }
}
