package com.example.final_project_jayme.controller;

import com.example.final_project_jayme.dto.ConsultaDTO;
import com.example.final_project_jayme.dto.PacienteDTO;
import com.example.final_project_jayme.entities.Consulta;
import com.example.final_project_jayme.entities.Paciente;
import com.example.final_project_jayme.mapper.ConsultaMapper;
import com.example.final_project_jayme.mapper.PacienteMapper;
import com.example.final_project_jayme.service.ConsultaService;
import com.example.final_project_jayme.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/consulta")
public class ConsultaController {

    private final ConsultaMapper consultaMapper;

    @Autowired
    private ConsultaService consultaService;
    @PostMapping
    public ResponseEntity<ConsultaDTO> savePaciente(@RequestBody ConsultaDTO consultaDTO) {
        Consulta consulta = consultaService.save(consultaDTO);
        return ResponseEntity.ok(consultaMapper.toConsultaDTO(consulta));
    }

    @PutMapping
    public ResponseEntity<ConsultaDTO> updatePaciente(@RequestBody ConsultaDTO consultaDTO) {
        Consulta consulta = consultaService.save(consultaDTO);
        return ResponseEntity.ok(consultaMapper.toConsultaDTO(consulta));
    }

    @GetMapping
    public ResponseEntity<List<ConsultaDTO>> listPacientes() {
        List<Consulta> consultas = consultaService.findAllConsultas();
        return ResponseEntity.ok(consultaMapper.toConsultaDTOList(consultas));
    }

    @DeleteMapping("/{pacienteId}")
    public ResponseEntity<ConsultaDTO> deletePaciente(@PathVariable("consultaId") Long consultaId) {
        Consulta consulta = consultaService.deletePacienteBy(consultaId);
        return ResponseEntity.ok(consultaMapper.toConsultaDTO(consulta));
    }
}
