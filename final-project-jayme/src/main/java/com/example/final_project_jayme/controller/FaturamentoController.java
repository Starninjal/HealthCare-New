package com.example.final_project_jayme.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/faturamento")
public class FaturamentoController {

    private final FaturamentoMapper faturamentoMapper;

    @Autowired
    private FaturamentoService faturamentoService;
    @PostMapping
    public ResponseEntity<FaturamentoDTO> saveFaturamento(@RequestBody FaturamentoDTO faturamentoDTO) {
        Faturamento faturamento = faturamentoService.save(faturamentoDTO);
        return ResponseEntity.ok(faturamentoMapper.toFaturamentoDTO(faturamento));
    }

    @PutMapping
    public ResponseEntity<FaturamentoDTO> updateFaturamento(@RequestBody FaturamentoDTO faturamentoDTO) {
        Faturamento faturamento = faturamentoService.save(faturamentoDTO);
        return ResponseEntity.ok(faturamentoMapper.toFaturamentoDTO(faturamento));
    }

    @GetMapping
    public ResponseEntity<List<FaturamentoDTO>> listFaturamentos() {
        List<Faturamento> faturamentos = faturamentoService.findAllFaturamentos();
        return ResponseEntity.ok(faturamentoMapper.toFaturamentoDTOList(faturamentos));
    }

    @DeleteMapping("/{faturamentoId}")
    public ResponseEntity<FaturamentoDTO> deleteFaturamento(@PathVariable("faturamentoId") Long faturamentoId) {
        Faturamento faturamento = faturamentoService.deleteFaturamentoBy(faturamentoId);
        return ResponseEntity.ok(faturamentoMapper.toFaturamentoDTO(faturamento));
    }
}

