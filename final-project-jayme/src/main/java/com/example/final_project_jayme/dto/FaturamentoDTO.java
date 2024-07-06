package com.example.final_project_jayme.dto;

import java.util.List;

import com.example.final_project_jayme.entities.FaturamentoItem;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FaturamentoDTO {
    private Long id;

    private PacienteDTO pacienteDTO;

    private List<FaturamentoItem> itens;

}
