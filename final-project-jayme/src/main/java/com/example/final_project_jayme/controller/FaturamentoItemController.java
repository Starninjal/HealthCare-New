package com.example.final_project_jayme.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/faturamentoItem")
public class FaturamentoItemController {

    private final FaturamentoItemMapper faturamentoItemMapper;

    @Autowired
    private FaturamentoItemService faturamentoItemService;
    @PostMapping
    public ResponseEntity<FaturamentoItemDTO> saveFaturamentoItem(@RequestBody FaturamentoItemDTO faturamentoItemDTO) {
        FaturamentoItem faturamentoItem = faturamentoItemService.save(faturamentoItemDTO);
        return ResponseEntity.ok(faturamentoItemMapper.toFaturamentoItemDTO(faturamentoItem));
    }

    @PutMapping
    public ResponseEntity<FaturamentoItemDTO> updateFaturamentoItem(@RequestBody FaturamentoItemDTO faturamentoItemDTO) {
        FaturamentoItem faturamentoItem = faturamentoItemService.save(faturamentoItemDTO);
        return ResponseEntity.ok(faturamentoItemMapper.toFaturamentoItemDTO(faturamentoItem));
    }

    @GetMapping
    public ResponseEntity<List<FaturamentoItemDTO>> listFaturamentoItems() {
        List<FaturamentoItem> faturamentoItems = faturamentoItemService.findAllFaturamentoItems();
        return ResponseEntity.ok(faturamentoItemMapper.toFaturamentoItemDTOList(faturamentoItems));
    }

    @DeleteMapping("/{faturamentoItemId}")
    public ResponseEntity<FaturamentoItemDTO> deleteFaturamentoItem(@PathVariable("faturamentoItemId") Long faturamentoItemId) {
        FaturamentoItem faturamentoItem = faturamentoItemService.deleteFaturamentoItemBy(faturamentoItemId);
        return ResponseEntity.ok(faturamentoItemMapper.toFaturamentoItemDTO(faturamentoItem));
    }
}

