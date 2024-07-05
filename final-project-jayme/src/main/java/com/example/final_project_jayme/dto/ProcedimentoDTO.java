package com.example.final_project_jayme.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProcedimentoDTO {
    private Long id;
    private String descricao;
    private String valor;
    private PacienteDTO pacienteDTO;
}
