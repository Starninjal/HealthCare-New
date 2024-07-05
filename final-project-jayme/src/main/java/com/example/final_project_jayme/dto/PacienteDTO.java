package com.example.final_project_jayme.dto;

import com.example.final_project_jayme.entities.Consulta;
import com.example.final_project_jayme.entities.Paciente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PacienteDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String sexo;
    private Date dtNascimento;
    private List<ProntuarioDTO> prontuarios;
}
