package com.example.final_project_jayme.mapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FaturamentoItemMapper {
    private final ModelMapper modelMapper;

    public FaturamentoItem toFaturamentoItem(FaturamentoItemDTO faturamentoItemDTO) {
        return modelMapper.map(faturamentoItemDTO, FaturamentoItem.class);
    }

    public FaturamentoItemDTO toFaturamentoItemDTO(FaturamentoItem faturamentoItem) {
        return modelMapper.map(faturamentoItem, FaturamentoItemDTO.class);
    }

        public List<FaturamentoItemDTO> toPacienteDTOList(List<FaturamentoItem> faturamentoItems) {
        return faturamentoItems.stream().map(f -> modelMapper.map(f, FaturamentoItemDTO.class)).toList();
    }
}
