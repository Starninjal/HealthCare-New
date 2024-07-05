package com.example.final_project_jayme.mapper;

import com.example.final_project_jayme.dto.ConsultaDTO;
import com.example.final_project_jayme.dto.ContatoDTO;
import com.example.final_project_jayme.dto.PacienteDTO;
import com.example.final_project_jayme.entities.Consulta;
import com.example.final_project_jayme.entities.Contato;
import com.example.final_project_jayme.entities.Paciente;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class ContatoMapper {
    private final ModelMapper modelMapper;

    public Contato toContato(ContatoDTO contatoDTO) {
        return modelMapper.map(contatoDTO, Contato.class);
    }

    public ContatoDTO toContatoDTO(Contato contato) {
        PacienteDTO pacienteDTO = modelMapper.map(contato.getPaciente(), PacienteDTO.class);
        ContatoDTO contatoDTO = modelMapper.map(contato, ContatoDTO.class);
        contatoDTO.setPacienteDTO(pacienteDTO);
        return contatoDTO;
    }

    public List<ContatoDTO> toConsultaDTOList(List<Contato> contatos) {
        return contatos.stream().map(c -> modelMapper.map(c, ContatoDTO.class)).toList();
    }
}
