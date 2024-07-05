package com.example.final_project_jayme.mapper;

import com.example.final_project_jayme.dto.ProntuarioDTO;
import com.example.final_project_jayme.entities.Prontuario;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProntuarioMapper {
    private final ModelMapper modelMapper;

    public Prontuario toProntuario(ProntuarioDTO prontuarioDTO) {
        return modelMapper.map(prontuarioDTO, Prontuario.class);
    }

    public ProntuarioDTO toProntuarioDTO(Prontuario prontuario) {
        return modelMapper.map(prontuario, ProntuarioDTO.class);
    }

    public List<ProntuarioDTO> toProntuarioDTOList(List<Prontuario> prontuarios) {
        return prontuarios.stream().map(p -> modelMapper.map(p, ProntuarioDTO.class)).toList();
    }
}
