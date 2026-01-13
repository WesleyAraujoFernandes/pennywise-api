package br.com.knowledgesoutionstecnology.pennywise.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.knowledgesoutionstecnology.pennywise.dto.DashboardResumoDTO;
import br.com.knowledgesoutionstecnology.pennywise.service.DashboardService;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
    private final DashboardService service;

    public DashboardController(DashboardService service) {
        this.service = service;
    }

    @GetMapping("/resumo")
    public ResponseEntity<DashboardResumoDTO> resumo() {
        return ResponseEntity.ok(service.getResumo());
    }

}
