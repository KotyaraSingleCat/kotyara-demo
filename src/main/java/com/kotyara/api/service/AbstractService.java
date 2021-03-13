package com.kotyara.api.service;

import java.util.List;

public interface AbstractService<T> {
  void create(T t);
  List<T> getAll();
}
