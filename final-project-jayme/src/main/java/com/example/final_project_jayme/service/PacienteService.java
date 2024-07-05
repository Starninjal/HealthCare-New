package com.example.final_project_jayme.service;

import com.example.final_project_jayme.dto.PacienteDTO;
import com.example.final_project_jayme.entities.Paciente;
import com.example.final_project_jayme.exception.CustomException;
import com.example.final_project_jayme.repositories.PacienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;
    public Paciente save(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente();
        BeanUtils.copyProperties(pacienteDTO, paciente);
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> findAllPacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente findPacienteBy(Long pacienteId) {
        return findAllPacientes().stream().filter(p -> p.getId() == pacienteId).findFirst().orElseThrow(() -> new CustomException("Paciente não encontrado"));
    }

    public Paciente deletePacienteBy(Long pacienteId) {
        Paciente paciente = findPacienteBy(pacienteId);
        pacienteRepository.delete(paciente);
        return paciente;
    }
}
