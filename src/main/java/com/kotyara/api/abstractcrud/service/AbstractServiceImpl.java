package com.kotyara.api.abstractcrud.service;

import com.kotyara.api.abstractcrud.service.convertor.AbstractConvert;
import com.kotyara.api.abstractcrud.repository.AbstractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class AbstractServiceImpl<Entity, DTO> implements AbstractService<Entity, DTO> {

  private final AbstractRepository<Entity> repository;

  private final AbstractConvert<Entity, DTO> converter;

  @Autowired
  public AbstractServiceImpl(AbstractRepository<Entity> repository,
      AbstractConvert<Entity, DTO> converter) {
    this.repository = repository;
    this.converter = converter;
  }

  @Override
  public void create(DTO dto) {
    repository.create(convertToEntity(dto));
  }

  @Override
  public List<Entity> getAll() {
    return repository.getAll();
  }

  @Override
  public Entity getById(int id) {
    return repository.getById(id);
  }

  @Override
  public void remove(int id) { repository.remove(id); }


  private Entity convertToEntity(DTO dto){
    return converter.convertToEntity(dto);
  }

  private DTO convertToDTO(Entity entity){
    return converter.covertToDTO(entity);
  }
}
