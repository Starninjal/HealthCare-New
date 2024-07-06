package com.example.final_project_jayme.mapper;

public class MedicamentoMapper {
    private final ModelMapper modelMapper;

    public Medicamento toMedicamento(MedicamentoDTO medicamentoDTO) {
        return modelMapper.map(medicamentoDTO, Medicamento.class);
    }

    public MedicamentoDTO toMedicamentoDTO(Medicamento medicamento) {
        return modelMapper.map(medicamento, MedicamentoDTO.class);
    }

    public List<MedicamentoDTO> toPacienteDTOList(List<Medicamento> medicamentos) {
        return medicamentos.stream().map(f -> modelMapper.map(f, MedicamentoDTO.class)).toList();

    }
}
