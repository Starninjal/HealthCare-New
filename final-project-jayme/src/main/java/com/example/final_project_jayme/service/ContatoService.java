package com.example.final_project_jayme.service;

import com.example.final_project_jayme.dto.ContatoDTO;
import com.example.final_project_jayme.entities.Contato;
import com.example.final_project_jayme.entities.Paciente;
import com.example.final_project_jayme.exception.CustomException;
import com.example.final_project_jayme.repositories.ContatoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PacienteService pacienteService;

    public Contato saveContato(ContatoDTO contatoDTO) {
        Contato contato = new Contato();
        BeanUtils.copyProperties(contatoDTO, contato);
        Paciente paciente = pacienteService.findPacienteBy(contatoDTO.getPacienteDTO().getId());
        contato.setPaciente(paciente);
        return contatoRepository.save(contato);
    }

    public List<Contato> findAllContatos() {
        return contatoRepository.findAll();
    }

    public Contato findContatoBy(Long contatoId) {
        return findAllContatos().stream()
                .filter(c -> c.getId() == contatoId)
                .findFirst().orElseThrow(() -> new CustomException("Contato não encontrado"));
    }

    public Contato deleteContatoBy(Long contatoId) {
        Contato contato = findContatoBy(contatoId);
        contatoRepository.delete(contato);
        return contato;
    }
}
