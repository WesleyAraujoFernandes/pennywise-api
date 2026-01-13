package br.com.knowledgesoutionstecnology.pennywise.repository;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.knowledgesoutionstecnology.pennywise.model.Despesa;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {
    boolean existsByDescricaoAndData(String descricao, LocalDate data);

    @Query("select coalesce(sum(d.valor),0) from Despesa d")
    BigDecimal sumTotal();
}
