package com.ArielMelo.AtendimentoFila.Infrastructure.Repository;

import com.ArielMelo.AtendimentoFila.Infrastructure.Entities.Senha;
import com.ArielMelo.AtendimentoFila.Infrastructure.Entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SenhaRepository extends JpaRepository<Senha, Long> {
    List<Senha> findByStatus(Status status);
    Optional<Senha> findFirstByStatusOrderByHorarioSolicitacaoAsc(Status status);
}
