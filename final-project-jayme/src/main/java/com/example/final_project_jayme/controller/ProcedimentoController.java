package com.example.final_project_jayme.controller;

import com.example.final_project_jayme.dto.ProcedimentoDTO;
import com.example.final_project_jayme.entities.Procedimento;
import com.example.final_project_jayme.mapper.ProcedimentoMapper;
import com.example.final_project_jayme.service.ProcedimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/procedimento")
public class ProcedimentoController {

    private final ProcedimentoMapper procedimentoMapper;

    @Autowired
    private ProcedimentoService procedimentoService;
    @PostMapping
    public ResponseEntity<ProcedimentoDTO> saveProcedimento(@RequestBody ProcedimentoDTO procedimentoDTO) {
        Procedimento procedimento = procedimentoService.save(procedimentoDTO);
        return ResponseEntity.ok(procedimentoMapper.toProcedimentoDTO(procedimento));
    }

    @PutMapping
    public ResponseEntity<ProcedimentoDTO> updateProcedimento(@RequestBody ProcedimentoDTO procedimentoDTO) {
        Procedimento procedimento = procedimentoService.save(procedimentoDTO);
        return ResponseEntity.ok(procedimentoMapper.toProcedimentoDTO(procedimento));
    }

    @GetMapping
    public ResponseEntity<List<ProcedimentoDTO>> listProcedimentos() {
        List<Procedimento> procedimentos = procedimentoService.findAllProcedimentos();
        return ResponseEntity.ok(procedimentoMapper.toProcedimentoDTOList(procedimentos));
    }

    @DeleteMapping("/{procedimentoId}")
    public ResponseEntity<ProcedimentoDTO> deleteProcedimento(@PathVariable("procedimentoId") Long procedimentoId) {
        Procedimento procedimento = procedimentoService.deleteProcedimentoBy(procedimentoId);
        return ResponseEntity.ok(procedimentoMapper.toProcedimentoDTO(procedimento));
    }
}
