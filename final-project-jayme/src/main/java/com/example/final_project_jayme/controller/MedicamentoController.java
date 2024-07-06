package com.example.final_project_jayme.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/medicamento")
public class MedicamentoController {

    private final MedicamentoMapper medicamentoMapper;
    @Autowired
    private MedicamentoService medicamentoService;
    @PostMapping
    public ResponseEntity<MedicamentoDTO> saveMedicamento(@RequestBody MedicamentoDTO medicamentoDTO) {
        Medicamento medicamento = medicamentoService.saveMedicamento(medicamentoDTO);
        return ResponseEntity.ok(medicamentoMapper.toMedicamentoDTO(medicamento));
    }

    @PutMapping
    public ResponseEntity<MedicamentoDTO> updateMedicamento(@RequestBody MedicamentoDTO medicamentoDTO) {
        Medicamento medicamento = medicamentoService.saveMedicamento(medicamentoDTO);
        return ResponseEntity.ok(medicamentoMapper.toMedicamentoDTO(medicamento));
    }

    @GetMapping
    public ResponseEntity<List<MedicamentoDTO>> listMedicamento() {
        List<Medicamento> medicamentos = medicamentoService.findAllMedicamentos();
        return ResponseEntity.ok(medicamentoMapper.toConsultaDTOList(medicamentos));
    }

    @DeleteMapping
    public ResponseEntity<MedicamentoDTO> deleteMedicamento(@PathVariable("medicamentoId") Long medicamentoId) {
        Medicamento medicamento = medicamentoService.deleteMedicamentoBy(medicamentoId);
        return ResponseEntity.ok(medicamentoMapper.toMedicamentoDTO(medicamento));
    }
}


