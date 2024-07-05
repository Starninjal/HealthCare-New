package com.example.final_project_jayme.mapper;

import com.example.final_project_jayme.dto.PacienteDTO;
import com.example.final_project_jayme.entities.Paciente;
import com.example.final_project_jayme.entities.Prontuario;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PacienteMapper {
    private final ModelMapper modelMapper;

    public Paciente toPaciente(PacienteDTO pacienteDTO) {
        return modelMapper.map(pacienteDTO, Paciente.class);
    }

    public PacienteDTO toPacienteDTO(Paciente paciente) {
        // prontuario
        return modelMapper.map(paciente, PacienteDTO.class);
    }

    public List<PacienteDTO> toPacienteDTOList(List<Paciente> pacientes) {
        return pacientes.stream().map(p -> modelMapper.map(p, PacienteDTO.class)).toList();
    }
}
