package com.example.final_project_jayme.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.final_project_jayme.dto.MedicamentoDTO;
import com.example.final_project_jayme.entities.Medicamento;
import com.example.final_project_jayme.exception.CustomException;
import com.example.final_project_jayme.repositories.MedicamentoRepository;

@Service
public class MedicamentoService {
    
    @Autowired
    private MedicamentoRepository medicamentoRepository;

    public Medicamento save(MedicamentoDTO medicamentoDTO) {
        Medicamento medicamento = new Medicamento();
        BeanUtils.copyProperties(medicamentoDTO, medicamento);
        return medicamentoRepository.save(medicamento);
    }

    public List<Medicamento> findAllMedicamentos() {
        return medicamentoRepository.findAll();
    }

    public Medicamento findMedicamentoBy(Long medicamentoId) {
        return findAllMedicamentos().stream()
                        .filter(m -> m.getId() == medicamentoId)
                        .findFirst().orElseThrow(() -> new CustomException("Medicamento não foi encontrado"));
    }

    public Medicamento deleteMedicamentoBy(Long medicamentoId) {
        Medicamento medicamento = findMedicamentoBy(medicamentoId);
        medicamentoRepository.delete(medicamento);
        return medicamento;
    }
}
