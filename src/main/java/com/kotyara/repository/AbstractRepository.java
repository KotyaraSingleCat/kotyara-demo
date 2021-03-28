package com.kotyara.repository;
import java.util.List;

public interface AbstractRepository<T> {

  List<T> getAll();

  void create(T t);

  T getById(int id);
}
