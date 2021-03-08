package com.kotyara.api.service;

import java.util.List;

public interface AbstractService<T> {
  void createUser(T t);
  List<T> getAll();
}
