package com.example.final_project_jayme.controller;

import com.example.final_project_jayme.dto.ProntuarioDTO;
import com.example.final_project_jayme.entities.Prontuario;
import com.example.final_project_jayme.mapper.ProntuarioMapper;
import com.example.final_project_jayme.service.ProntuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/prontuario")
public class ProntuarioController {

    @Autowired
    private ProntuarioService prontuarioService;

    private final ProntuarioMapper prontuarioMapper;
    @PostMapping
    public ResponseEntity<ProntuarioDTO> saveProntuario(@RequestBody ProntuarioDTO prontuarioDTO) {
        Prontuario prontuario = prontuarioService.save(prontuarioDTO);
        return ResponseEntity.ok(prontuarioMapper.toProntuarioDTO(prontuario));
    }

    @PutMapping
    public ResponseEntity<ProntuarioDTO> updateProntuario(@RequestBody ProntuarioDTO prontuarioDTO) {
        Prontuario prontuario = prontuarioService.save(prontuarioDTO);
        return ResponseEntity.ok(prontuarioMapper.toProntuarioDTO(prontuario));
    }

    @GetMapping
    public ResponseEntity<List<ProntuarioDTO>> listProntuario() {
        List<Prontuario> prontuarios = prontuarioService.findAllProntuarios();
        return ResponseEntity.ok(prontuarioMapper.toProntuarioDTOList(prontuarios));
    }

    @DeleteMapping("/{prontuarioId}")
    public ResponseEntity<ProntuarioDTO> deleteProntuarioBy(@PathVariable("prontuarioId") Long prontuarioId) {
        Prontuario prontuario = prontuarioService.deleteProntuarioBy(prontuarioId);
        return ResponseEntity.ok(prontuarioMapper.toProntuarioDTO(prontuario));
    }


}
