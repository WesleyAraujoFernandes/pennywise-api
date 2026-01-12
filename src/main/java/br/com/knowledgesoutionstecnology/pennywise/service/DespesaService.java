package br.com.knowledgesoutionstecnology.pennywise.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.knowledgesoutionstecnology.pennywise.dto.DespesaDTO;
import br.com.knowledgesoutionstecnology.pennywise.exception.DespesaDuplicadaException;
import br.com.knowledgesoutionstecnology.pennywise.model.Despesa;
import br.com.knowledgesoutionstecnology.pennywise.repository.DespesaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DespesaService {

    private final DespesaRepository despesaRepository;

    public DespesaDTO createDespesa(DespesaDTO dto) {
        boolean exists = despesaRepository.existsByDescricaoAndData(dto.getDescricao(), dto.getData());
        if (exists) {
            throw new DespesaDuplicadaException(
                    "Já existe uma despesa com a descrição: " + dto.getDescricao() + " para a data: " + dto.getData());
        }
        Despesa despesa = Despesa.builder()
                .descricao(dto.getDescricao())
                .valor(dto.getValor())
                .data(dto.getData())
                .categoria(dto.getCategoria())
                .build();
        Despesa saved = despesaRepository.save(despesa);
        return mapToDTO(saved);
    }

    public List<DespesaDTO> getAllDespesas() {
        return despesaRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public DespesaDTO getDespesaById(Long id) {
        return despesaRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new RuntimeException("Despesa não encontrada"));
    }

    public DespesaDTO updateDespesa(Long id, DespesaDTO dto) {
        Despesa despesa = despesaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Despesa não encontrada"));
        despesa.setDescricao(dto.getDescricao());
        despesa.setValor(dto.getValor());
        despesa.setData(dto.getData());
        despesa.setCategoria(dto.getCategoria());
        Despesa updated = despesaRepository.save(despesa);
        return mapToDTO(updated);
    }

    public void deleteDespesa(Long id) {
        despesaRepository.deleteById(id);
    }

    private DespesaDTO mapToDTO(Despesa despesa) {
        return DespesaDTO.builder()
                .id(despesa.getId())
                .descricao(despesa.getDescricao())
                .valor(despesa.getValor())
                .data(despesa.getData())
                .categoria(despesa.getCategoria())
                .build();
    }
}