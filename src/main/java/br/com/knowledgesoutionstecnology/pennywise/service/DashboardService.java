package br.com.knowledgesoutionstecnology.pennywise.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import br.com.knowledgesoutionstecnology.pennywise.dto.DashboardResumoDTO;
import br.com.knowledgesoutionstecnology.pennywise.repository.DespesaRepository;
import br.com.knowledgesoutionstecnology.pennywise.repository.EntradaRepository;

@Service
public class DashboardService {
    private final EntradaRepository entradaRepository;
    private final DespesaRepository despesaRepository;

    public DashboardService(EntradaRepository entradaRepository, DespesaRepository despesaRepository) {
        this.entradaRepository = entradaRepository;
        this.despesaRepository = despesaRepository;
    }

    public DashboardResumoDTO getResumo() {
        BigDecimal totalEntradas = entradaRepository.sumTotal();
        BigDecimal totalDespesas = despesaRepository.sumTotal();
        return new DashboardResumoDTO(totalEntradas, totalDespesas);
    }

}
