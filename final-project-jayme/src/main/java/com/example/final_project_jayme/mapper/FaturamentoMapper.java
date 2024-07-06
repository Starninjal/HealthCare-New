package com.example.final_project_jayme.mapper;

import java.util.List;

import org.modelmapper.ModelMapper;

import com.example.final_project_jayme.dto.FaturamentoDTO;
import com.example.final_project_jayme.dto.PacienteDTO;
import com.example.final_project_jayme.entities.Faturamento;
import com.example.final_project_jayme.entities.Paciente;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FaturamentoMapper {
    private final ModelMapper modelMapper;

    public Faturamento toFaturamento(FaturamentoDTO faturamentoDTO) {
        return modelMapper.map(faturamentoDTO, Faturamento.class);
    }

    public FaturamentoDTO toFaturamentoDTO(Faturamento faturamento) {
        return modelMapper.map(faturamento, FaturamentoDTO.class);
    }

        public List<FaturamentoDTO> toPacienteDTOList(List<Faturamento> faturamentos) {
        return faturamentos.stream().map(f -> modelMapper.map(f, FaturamentoDTO.class)).toList();
    }
}
