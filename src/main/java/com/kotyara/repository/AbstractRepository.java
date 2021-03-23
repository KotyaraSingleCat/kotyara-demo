package com.kotyara.repository;
import java.util.List;

public interface AbstractRepository<T, G> {

  List<T> getAll();

  void create(G g);
}
