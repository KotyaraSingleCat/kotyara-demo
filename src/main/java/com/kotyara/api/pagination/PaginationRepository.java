package com.kotyara.api.pagination;

import com.kotyara.api.entity.Ticket;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaginationRepository extends PagingAndSortingRepository<Ticket, Integer> {

}
