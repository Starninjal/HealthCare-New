package com.example.final_project_jayme.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.final_project_jayme.entities.Procedimento;

public interface ProcedimentoRepository extends JpaRepository<Procedimento, Long> {
    
}
