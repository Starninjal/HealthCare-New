package com.example.final_project_jayme.dto;

import java.util.List;

import com.example.final_project_jayme.entities.Paciente;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MedicamentoDTO {
    private Long id;
    private String nome;
    private String marca;
    private String dosagem;

    List<Paciente> pacientes;
}
