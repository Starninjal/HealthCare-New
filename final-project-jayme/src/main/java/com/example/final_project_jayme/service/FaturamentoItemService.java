package com.example.final_project_jayme.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.final_project_jayme.dto.FaturamentoItemDTO;
import com.example.final_project_jayme.entities.FaturamentoItem;
import com.example.final_project_jayme.exception.CustomException;
import com.example.final_project_jayme.repositories.FaturamentoItemRepository;

@Service
public class FaturamentoItemService {

    @Autowired
    private FaturamentoItemRepository faturamentoItemRepository;
    public FaturamentoItem save(FaturamentoItemDTO faturamentoItemDTO) {
        FaturamentoItem faturamentoItem = new FaturamentoItem();
        BeanUtils.copyProperties(faturamentoItemDTO, faturamentoItem);
        return faturamentoItemRepository.save(faturamentoItem);
    }

    public List<FaturamentoItem> findAllFaturamentoItem() {
        return faturamentoItemRepository.findAll();
    }

    public FaturamentoItem findFaturamentoItemBy(Long faturamentoItemId) {
        return findAllFaturamentoItem().stream()
                    .filter(f -> f.getId() == faturamentoItemId)
                    .findFirst().orElseThrow(() -> new CustomException("FaturamentoItem não encontrado"));
    }
    
    public FaturamentoItem deleteFaturamentoItemBy(Long faturamentoItemId) {
        FaturamentoItem faturamentoItem = findFaturamentoItemBy(faturamentoItemId);
        faturamentoItemRepository.delete(faturamentoItem);
        return faturamentoItem;
    }

}
