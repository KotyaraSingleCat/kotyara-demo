package com.kotyara.api.abstractcrud.service.convertor;

import org.springframework.stereotype.Component;

@Component
public interface AbstractConvert<Entity, DTO> {

  Entity convertToEntity(DTO dto);

  DTO covertToDTO(Entity entity);
}
