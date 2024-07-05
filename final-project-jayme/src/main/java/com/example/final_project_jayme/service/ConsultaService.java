package com.example.final_project_jayme.service;

import com.example.final_project_jayme.dto.ConsultaDTO;
import com.example.final_project_jayme.entities.Consulta;
import com.example.final_project_jayme.entities.Paciente;
import com.example.final_project_jayme.exception.CustomException;
import com.example.final_project_jayme.repositories.ConsultaRepository;
import com.example.final_project_jayme.repositories.PacienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteService pacienteService;

    public Consulta save(ConsultaDTO consultaDTO) {
        Consulta consulta = new Consulta();
        Paciente paciente = pacienteService.findPacienteBy(consultaDTO.getPacienteDTO().getId());
        BeanUtils.copyProperties(consultaDTO, consulta);
        consulta.setPaciente(paciente);
        return consultaRepository.save(consulta);
    }

    public List<Consulta> findAllConsultas() {
        return consultaRepository.findAll();
    }

    public Consulta findConsultaBy(Long consultaId) {
        return findAllConsultas().stream().filter(p -> p.getId() == consultaId).findFirst().orElseThrow(() -> new CustomException("Consulta não encontrado"));
    }

    public Consulta deletePacienteBy(Long consultaId) {
        Consulta consulta = findConsultaBy(consultaId);
        consultaRepository.delete(consulta);
        return consulta;
    }
}
