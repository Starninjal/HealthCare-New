package com.example.final_project_jayme.mapper;

import java.util.List;

import org.modelmapper.ModelMapper;

import com.example.final_project_jayme.dto.MedicamentoDTO;
import com.example.final_project_jayme.entities.Medicamento;

public class MedicamentoMapper {
    private final ModelMapper modelMapper;

    public Medicamento toMedicamento(MedicamentoDTO medicamentoDTO) {
        return modelMapper.map(medicamentoDTO, Medicamento.class);
    }

    public MedicamentoDTO toMedicamentoDTO(Medicamento medicamento) {
        return modelMapper.map(medicamento, MedicamentoDTO.class);
    }

    public List<MedicamentoDTO> toMedicamentoDTOList(List<Medicamento> medicamentos) {
        return medicamentos.stream().map(f -> modelMapper.map(f, MedicamentoDTO.class)).toList();

    }
}
