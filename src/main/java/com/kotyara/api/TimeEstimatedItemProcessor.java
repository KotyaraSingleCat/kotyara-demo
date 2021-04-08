package com.kotyara.api;

import com.kotyara.api.entity.Ticket;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeEstimatedItemProcessor implements ItemProcessor<Ticket, Ticket> {

  @Override
  public Ticket process(Ticket ticket) {

    Pattern p = Pattern.compile("(\\d+\\s[hmds])");
    String time_taken = ticket.getTimeEstimated();
    LocalDateTime date_of_creation = ticket.getCreatedDate();
    Matcher m = p.matcher(time_taken);
    while (m.find()) {
      if (m.group().contains("d"))
        date_of_creation = date_of_creation.plusDays(Long.parseLong(Arrays.stream(m.group().split("\\s[d]")).findFirst().get()));
      if(m.group().contains("h"))
        date_of_creation = date_of_creation.plusHours(Long.parseLong(Arrays.stream(m.group().split("\\s[h]")).findFirst().get()));
      if(m.group().contains("m"))
        date_of_creation = date_of_creation.plusMinutes(Long.parseLong(Arrays.stream(m.group().split("\\s[m]")).findFirst().get()));
      if(m.group().contains("s"))
        date_of_creation = date_of_creation.plusSeconds(Long.parseLong(Arrays.stream(m.group().split("\\s[s]")).findFirst().get()));
    }

    if(!ticket.getStatus().equals("CLOSED") && LocalDateTime.now().isAfter(date_of_creation))
      ticket.setStatus("EXPIRED");

    return ticket;
  }
}
