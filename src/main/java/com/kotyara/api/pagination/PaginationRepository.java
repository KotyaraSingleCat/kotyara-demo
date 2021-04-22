package com.kotyara.api.pagination;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaginationRepository<Entity> extends PagingAndSortingRepository<Entity, Integer> {

}
