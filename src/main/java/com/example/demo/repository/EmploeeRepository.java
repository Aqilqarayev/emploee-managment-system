package com.example.demo.repository;

import com.example.demo.repository.entity.EmploeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmploeeRepository extends JpaRepository<  EmploeeEntity, Long> {
    List<EmploeeEntity> findAllByIsDeleted(boolean isDeleted);

    Optional<EmploeeEntity> findByIdAndIsDeleted(Long id, boolean isDeleted);

}
