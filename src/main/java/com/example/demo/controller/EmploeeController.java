package com.example.demo.controller;

import com.example.demo.service.EmploeeService;
import com.example.demo.service.dto.CreateEmploeeDTO;
import com.example.demo.service.dto.EmploeeDTO;
import com.example.demo.service.dto.UpdateEmploeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/emploees")
@RequiredArgsConstructor
public class EmploeeController {
    public final EmploeeService emploeeService;
    @GetMapping
    public ResponseEntity<List<EmploeeDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(emploeeService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmploeeDTO> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(EmploeeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<EmploeeDTO> create(@RequestBody CreateEmploeeDTO createBookDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(emploeeService.create(createBookDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UpdateEmploeeDTO updateEmploeeDTO){
        emploeeService.update(id,updateEmploeeDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        EmploeeService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
