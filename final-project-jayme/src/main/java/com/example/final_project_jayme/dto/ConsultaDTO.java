package com.example.final_project_jayme.dto;

import com.example.final_project_jayme.entities.Paciente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class ConsultaDTO {
    private Long id;
    private Date dataConsulta;
    private LocalTime horaConsulta;
    private PacienteDTO pacienteDTO;

}
