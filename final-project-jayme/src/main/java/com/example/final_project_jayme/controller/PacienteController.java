package com.example.final_project_jayme.controller;

import com.example.final_project_jayme.dto.PacienteDTO;
import com.example.final_project_jayme.entities.Paciente;
import com.example.final_project_jayme.mapper.PacienteMapper;
import com.example.final_project_jayme.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteMapper pacienteMapper;

    @Autowired
    private PacienteService pacienteService;
    @PostMapping
    public ResponseEntity<PacienteDTO> savePaciente(@RequestBody PacienteDTO pacienteDTO) {
        Paciente paciente = pacienteService.save(pacienteDTO);
        return ResponseEntity.ok(pacienteMapper.toPacienteDTO(paciente));
    }

    @PutMapping
    public ResponseEntity<PacienteDTO> updatePaciente(@RequestBody PacienteDTO pacienteDTO) {
        Paciente paciente = pacienteService.save(pacienteDTO);
        return ResponseEntity.ok(pacienteMapper.toPacienteDTO(paciente));
    }

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> listPacientes() {
        List<Paciente> pacientes = pacienteService.findAllPacientes();
        return ResponseEntity.ok(pacienteMapper.toPacienteDTOList(pacientes));
    }

    @DeleteMapping("/{pacienteId}")
    public ResponseEntity<PacienteDTO> deletePaciente(@PathVariable("pacienteId") Long pacienteId) {
        Paciente paciente = pacienteService.deletePacienteBy(pacienteId);
        return ResponseEntity.ok(pacienteMapper.toPacienteDTO(paciente));
    }
}
