package com.example.final_project_jayme.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter
@NoArgsConstructor
public class ProntuarioDTO {
    private Long id;
    private Date dtEntrada;
    private Date dtAlta;
    private String convenio;
    private PacienteDTO pacienteDTO;
}
