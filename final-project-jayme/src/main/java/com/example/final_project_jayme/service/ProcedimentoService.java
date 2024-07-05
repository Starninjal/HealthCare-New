package com.example.final_project_jayme.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.final_project_jayme.entities.Procedimento;
import com.example.final_project_jayme.repositories.ProcedimentoRepository;

@Service
public class ProcedimentoService {

    @Autowired
    private ProcedimentoRepository procedimentoRepository;

    
    public Procedimento saveProcedimento(ProcedimentoDTO procedimentoDTO) {
        Procedimento procedimento = new Procedimento();
        BeanUtils.copyProperties(procedimento, procedimento);
        return procedimentoRepository.save(procedimento);
    }

    public List<Procedimento> findAllProcedimentos() {
        return procedimentoRepository.findAll();
    }
}
