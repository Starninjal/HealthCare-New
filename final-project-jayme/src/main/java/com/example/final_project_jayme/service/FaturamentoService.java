package com.example.final_project_jayme.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.final_project_jayme.dto.FaturamentoDTO;
import com.example.final_project_jayme.entities.Faturamento;
import com.example.final_project_jayme.exception.CustomException;
import com.example.final_project_jayme.repositories.FaturamentoRepository;

@Service
public class FaturamentoService {

    @Autowired
    private FaturamentoRepository faturamentoRepository;
    public Faturamento save(FaturamentoDTO faturamentoDTO) {
        Faturamento faturamento = new Faturamento();
        BeanUtils.copyProperties(faturamentoDTO, faturamento);
        return faturamentoRepository.save(faturamento);
    }

    public List<Faturamento> findAllFaturamento() {
        return faturamentoRepository.findAll();
    }

    public Faturamento findFaturamentoBy(Long faturamentoId) {
        return findAllFaturamento().stream()
                    .filter(f -> f.getId() == faturamentoId)
                    .findFirst().orElseThrow(() -> new CustomException("Faturamento não encontrado"));
    }
    
    public Faturamento deleteFaturamentoBy(Long faturamentoId) {
        Faturamento faturamento = findFaturamentoBy(faturamentoId);
        faturamentoRepository.delete(faturamento);
        return faturamento;
    }

}
