package com.example.final_project_jayme.mapper;

import java.util.List;

import org.modelmapper.ModelMapper;

import com.example.final_project_jayme.dto.FaturamentoItemDTO;
import com.example.final_project_jayme.entities.FaturamentoItem;

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

        public List<FaturamentoItemDTO> toFaturamentoItemDTOList(List<FaturamentoItem> faturamentoItems) {
        return faturamentoItems.stream().map(f -> modelMapper.map(f, FaturamentoItemDTO.class)).toList();
    }
}
