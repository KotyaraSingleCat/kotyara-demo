package com.kotyara.api;

import com.kotyara.api.entity.Ticket;
import org.springframework.batch.item.ItemProcessor;

public class TimeEstimatedItemProcessor implements ItemProcessor<Ticket, Ticket> {

  @Override
  public Ticket process(Ticket ticket) throws Exception {
    return null;
  }
}
