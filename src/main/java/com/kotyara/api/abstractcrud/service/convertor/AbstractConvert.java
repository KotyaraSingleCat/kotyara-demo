package com.kotyara.api.abstractcrud.service.convertor;

public interface AbstractConvert<Entity, DTO> {

  Entity convertToEntity(DTO dto);

  DTO covertToDTO(Entity entity);
}
