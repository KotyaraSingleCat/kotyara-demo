package com.kotyara.api.service;

import java.util.List;

public interface AbstractService<T, G> {
  void create(G g);
  List<T> getAll();
}
