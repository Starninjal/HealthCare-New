package com.example.final_project_jayme.controller;

import com.example.final_project_jayme.dto.ContatoDTO;
import com.example.final_project_jayme.entities.Contato;
import com.example.final_project_jayme.mapper.ConsultaMapper;
import com.example.final_project_jayme.mapper.ContatoMapper;
import com.example.final_project_jayme.service.ConsultaService;
import com.example.final_project_jayme.service.ContatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contato")
public class ContatoController {

    private final ContatoMapper contatoMapper;
    @Autowired
    private ContatoService contatoService;
    @PostMapping
    public ResponseEntity<ContatoDTO> saveContato(@RequestBody ContatoDTO contatoDTO) {
        Contato contato = contatoService.saveContato(contatoDTO);
        return ResponseEntity.ok(contatoMapper.toContatoDTO(contato));
    }

    @PutMapping
    public ResponseEntity<ContatoDTO> updateContato(@RequestBody ContatoDTO contatoDTO) {
        Contato contato = contatoService.saveContato(contatoDTO);
        return ResponseEntity.ok(contatoMapper.toContatoDTO(contato));
    }

    @GetMapping
    public ResponseEntity<List<ContatoDTO>> listContato() {
        List<Contato> contatos = contatoService.findAllContatos();
        return ResponseEntity.ok(contatoMapper.toConsultaDTOList(contatos));
    }

    @DeleteMapping
    public ResponseEntity<ContatoDTO> deleteContato(@PathVariable("contatoId") Long contatoId) {
        Contato contato = contatoService.deleteContatoBy(contatoId);
        return ResponseEntity.ok(contatoMapper.toContatoDTO(contato));
    }
}
