package com.kotyara.api.pagination.service;

import com.kotyara.api.entity.Ticket;
import com.kotyara.api.pagination.dto.SearchCriteria;
import com.kotyara.api.pagination.repository.TicketRepository;
import com.kotyara.api.pagination.filter.TicketSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaginationService {

  @Autowired
  TicketRepository ticketRepository;

  public List<Ticket> findAllPagination(SearchCriteria searchParameters){
    PageRequest pageRequest = PageRequest.of((int)searchParameters.getOffset(), searchParameters.getLimit(), Sort.by(Sort.Direction.ASC, "name", "priority"));
    Specification<Ticket> filters = new TicketSpecification(searchParameters.getCondition());
    Page<Ticket> page = ticketRepository.findAll(filters, pageRequest);
    if(page.hasContent()) {
      return page.getContent();
    } else {
      return new ArrayList<>();
    }
  }
}
