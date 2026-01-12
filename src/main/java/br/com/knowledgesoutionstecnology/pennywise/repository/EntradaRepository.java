package br.com.knowledgesoutionstecnology.pennywise.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.knowledgesoutionstecnology.pennywise.model.Entrada;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Long> {
    boolean existsByDescricaoAndData(String descricao, LocalDate data);
}
