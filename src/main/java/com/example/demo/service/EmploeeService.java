package com.example.demo.service;

import com.example.demo.exception.EmploeeNotFoundException;
import com.example.demo.mapper.EmploeeMapper;
import com.example.demo.repository.EmploeeRepository;
import com.example.demo.repository.entity.EmploeeEntity;
import com.example.demo.service.dto.CreateEmploeeDTO;
import com.example.demo.service.dto.EmploeeDTO;
import com.example.demo.service.dto.UpdateEmploeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmploeeService {
    private static EmploeeRepository emploeeRepository;
    private static EmploeeMapper emploeeMapper;

    public List<EmploeeDTO> findAll() {
        var emploee = emploeeRepository.findAllByIsDeleted(false);
        return emploeeMapper.toEmploeeDTOList(emploee);
    }

    public static EmploeeDTO findById(Long id) {
        var emploee = emploeeRepository.findByIdAndIsDeleted(id, false)
                .orElseThrow(() -> new EmploeeNotFoundException("Book not found with id:" + id));
        return emploeeMapper.toEmploeeDTO(emploee);
    }

    public EmploeeDTO create(CreateEmploeeDTO createEmploeeDTO) {
        EmploeeEntity emploee = emploeeMapper.toEmploeeEntity(createEmploeeDTO);
        return emploeeMapper.toEmploeeDTO(emploeeRepository.save(emploee));
    }

    public void update(Long id, UpdateEmploeeDTO updateEmploeeDTO) {
        EmploeeEntity emploee = getEmploeeEntity(id);
        emploeeMapper.toEmploeeEntity(updateEmploeeDTO, emploee);
        emploeeRepository.save(emploee);
    }

    public static void delete(Long id) {
        EmploeeEntity emploee = getEmploeeEntity(id);
        emploee.setDeleted(true);
        emploeeRepository.save(emploee);
    }

    private static EmploeeEntity getEmploeeEntity(Long id) {
        return emploeeRepository.findByIdAndIsDeleted(id, false)
                .orElseThrow(() -> new EmploeeNotFoundException("Book not found with id:" + id));
    }

    private static EmploeeEntity mapToEmploeeEntity(CreateEmploeeDTO createBookDTO) {
        var emploee = new EmploeeEntity();
        emploee.setName(createBookDTO.getName());
        emploee.setProfessionality(createBookDTO.getProfessionality());
        return emploee;
    }

}
