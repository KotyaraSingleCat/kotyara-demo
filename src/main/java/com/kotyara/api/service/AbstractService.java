package com.kotyara.api.service;

import java.util.List;

public interface AbstractService<Entity, DTO> {
  void create(DTO dto);
  List<Entity> getAll();
  Entity getById(int id);
}
