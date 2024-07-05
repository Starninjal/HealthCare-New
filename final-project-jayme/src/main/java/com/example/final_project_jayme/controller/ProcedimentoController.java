package com.example.final_project_jayme.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/procedimento")
public class ProcedimentoController {
    @Autowired
    private ProcedimentoService procedimentoService;

    private final ProcedimentoMapper procedimentoMapper;
}
