package com.kotyara.api.pagination.filter;

import com.kotyara.api.entity.Ticket;
import com.kotyara.api.pagination.dto.Condition;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;

public class TicketSpecification implements Specification<Ticket> {
  private Condition condition;

  public TicketSpecification(Condition condition) {
    this.condition = condition;
  }

  @Override
  public Predicate toPredicate(Root<Ticket> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
    if(condition.getField().equals("status")) {
      return statusFilter(root, criteriaQuery, criteriaBuilder);
    }
    if(condition.getField().equals("createdDate")){
      return createdDateFilter(root, criteriaQuery, criteriaBuilder);
    }
    return null;
  }

  private Predicate statusFilter(Root<Ticket> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder){
    return criteriaBuilder.equal(root.get(condition.getField()), condition.getValue());
  }

  private Predicate createdDateFilter(Root<Ticket> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder){
    if (condition.getOperation().equalsIgnoreCase(">")) {
      return criteriaBuilder.greaterThanOrEqualTo(
          root.get(condition.getField()), LocalDateTime.parse(condition.getValue()));
    }
    else if (condition.getOperation().equalsIgnoreCase("<")) {
      return criteriaBuilder.lessThanOrEqualTo(
          root.get(condition.getField()), LocalDateTime.parse(condition.getValue()));
    }
    else if (condition.getOperation().equalsIgnoreCase("=")) {
      if (root.get(condition.getValue()).getJavaType() == String.class) {
        return criteriaBuilder.like(
            root.get(condition.getField()), "%" + LocalDateTime.parse(condition.getValue()) + "%");
      } else {
        return criteriaBuilder.equal(root.get(condition.getField()), LocalDateTime.parse(condition.getValue()));
      }
    }
    return null;
  }
}
