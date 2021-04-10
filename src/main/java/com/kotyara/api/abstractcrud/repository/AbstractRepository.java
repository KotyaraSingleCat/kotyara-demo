package com.kotyara.api.abstractcrud.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbstractRepository<T> {

  List<T> getAll();

  void create(T t);

  T getById(int id);

  void remove(int id);
}
