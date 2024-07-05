package com.example.final_project_jayme.repositories;

import com.example.final_project_jayme.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
