package com.example.demo.mapper;

import com.example.demo.repository.entity.EmploeeEntity;
import com.example.demo.service.dto.CreateEmploeeDTO;
import com.example.demo.service.dto.EmploeeDTO;
import com.example.demo.service.dto.UpdateEmploeeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;
@Mapper(componentModel = "spring")
public interface EmploeeMapper {
    EmploeeDTO toEmploeeDTO(EmploeeEntity bookEntity);
    EmploeeEntity toEmploeeEntity(CreateEmploeeDTO createEmploeeDTO);
    void toEmploeeEntity(UpdateEmploeeDTO updateEmploeeDTO, @MappingTarget EmploeeEntity emploee);

    List<EmploeeDTO> toEmploeeDTOList(List<EmploeeEntity> emploeeEntities);

}
