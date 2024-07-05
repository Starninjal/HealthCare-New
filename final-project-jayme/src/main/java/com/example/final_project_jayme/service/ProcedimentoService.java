package com.example.final_project_jayme.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.final_project_jayme.dto.ProcedimentoDTO;
import com.example.final_project_jayme.entities.Procedimento;
import com.example.final_project_jayme.exception.CustomException;
import com.example.final_project_jayme.repositories.ProcedimentoRepository;

@Service
public class ProcedimentoService {

    @Autowired
    private ProcedimentoRepository procedimentoRepository;


    public Procedimento save(ProcedimentoDTO procedimentoDTO) {
        Procedimento procedimento = new Procedimento();
        BeanUtils.copyProperties(procedimento, procedimento);
        return procedimentoRepository.save(procedimento);
    }

    public List<Procedimento> findAllProcedimentos() {
        return procedimentoRepository.findAll();
    }

    public Procedimento findProcedimentoBy(Long procedimentoId) {
        return findAllProcedimentos().stream().
                        filter(p -> p.getId() == procedimentoId)
                        .findFirst().orElseThrow(() -> new CustomException("Procedimento não encontrado"));
    }

    public Procedimento deleteProcedimentoBy(Long procedimentoId) {
        Procedimento procedimento = findProcedimentoBy(procedimentoId);
        procedimentoRepository.delete(procedimento);
        return procedimento;
    }
}
