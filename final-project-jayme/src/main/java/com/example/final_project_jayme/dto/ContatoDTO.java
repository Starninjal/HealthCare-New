package com.example.final_project_jayme.dto;

import com.example.final_project_jayme.entities.Paciente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContatoDTO {
    private Long id;
    private String telefone;
    private String email;
    private PacienteDTO pacienteDTO;
}
