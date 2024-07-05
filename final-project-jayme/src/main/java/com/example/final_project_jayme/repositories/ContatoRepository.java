package com.example.final_project_jayme.repositories;

import com.example.final_project_jayme.entities.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
