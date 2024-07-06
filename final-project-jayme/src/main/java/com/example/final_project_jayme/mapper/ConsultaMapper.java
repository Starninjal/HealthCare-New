package com.example.final_project_jayme.mapper;

import com.example.final_project_jayme.dto.ConsultaDTO;
import com.example.final_project_jayme.entities.Consulta;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ConsultaMapper {
    private final ModelMapper modelMapper;

    public Consulta toConsulta(ConsultaDTO consultaDTO) {
        return modelMapper.map(consultaDTO, Consulta.class);
    }

    public ConsultaDTO toConsultaDTO(Consulta consulta) {
        return modelMapper.map(consulta, ConsultaDTO.class);
    }

    public List<ConsultaDTO> toConsultaDTOList(List<Consulta> consultas) {
        return consultas.stream().map(c -> modelMapper.map(c, ConsultaDTO.class)).toList();
    }
}
