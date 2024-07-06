package com.example.final_project_jayme.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FaturamentoItemDTO {
    private String descricao;
    private BigDecimal valor;
}
