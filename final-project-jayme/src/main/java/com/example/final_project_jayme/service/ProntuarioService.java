package com.example.final_project_jayme.service;

import com.example.final_project_jayme.dto.ProntuarioDTO;
import com.example.final_project_jayme.entities.Paciente;
import com.example.final_project_jayme.entities.Prontuario;
import com.example.final_project_jayme.exception.CustomException;
import com.example.final_project_jayme.repositories.ProntuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProntuarioService {

    @Autowired
    private ProntuarioRepository prontuarioRepository;

    @Autowired
    private PacienteService pacienteService;
    public Prontuario save(ProntuarioDTO prontuarioDTO) {
        Prontuario prontuario = new Prontuario();
        BeanUtils.copyProperties(prontuarioDTO, prontuario);
        Paciente paciente = pacienteService.findPacienteBy(prontuarioDTO.getPacienteDTO().getId());
        prontuario.setPaciente(paciente);
        return prontuarioRepository.save(prontuario);
    }

    public List<Prontuario> findAllProntuarios() {
        return prontuarioRepository.findAll();
    }

    public Prontuario deleteProntuarioBy(Long prontuarioId) {
        Prontuario prontuario = findAllProntuarios().stream().filter(p -> p.getId() == prontuarioId).findFirst().orElseThrow(() -> new CustomException("Prontuário não foi encontrado"));
        prontuarioRepository.delete(prontuario);
        return prontuario;
    }
}
