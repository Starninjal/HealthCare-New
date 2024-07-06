package com.example.final_project_jayme.repositories;

import com.example.final_project_jayme.entities.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaturamentoItemRepository extends JpaRepository<Consulta, Long> {
}
