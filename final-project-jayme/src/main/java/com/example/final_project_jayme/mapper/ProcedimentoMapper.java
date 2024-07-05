package com.example.final_project_jayme.mapper;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.final_project_jayme.dto.PacienteDTO;
import com.example.final_project_jayme.dto.ProcedimentoDTO;
import com.example.final_project_jayme.entities.Paciente;
import com.example.final_project_jayme.entities.Procedimento;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProcedimentoMapper {
    private final ModelMapper modelMapper;

    public Procedimento toProcedimento(ProcedimentoDTO procedimentoDTO) {
        return modelMapper.map(procedimentoDTO, Procedimento.class);
    }

    public ProcedimentoDTO toProcedimentoDTO(Procedimento procedimento) {
            return modelMapper.map(procedimento, ProcedimentoDTO.class);
    }

    public List<ProcedimentoDTO> toProcedimentoDTOList(List<Procedimento> procedimentos) {
        return procedimentos.stream().map(p -> modelMapper.map(p, ProcedimentoDTO.class)).toList();
    }
}
