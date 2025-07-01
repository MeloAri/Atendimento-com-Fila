package com.ArielMelo.AtendimentoFila.Infrastructure.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@Table(name = "Senha")
public class Senha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;

    private LocalDateTime horarioSolicitacao;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Senha() {}

    public Senha(String codigo, LocalDateTime horarioSolicitacao, Status status) {
        this.codigo = codigo;
        this.horarioSolicitacao = horarioSolicitacao;
        this.status = status;
    }

    // Getters e setters

    public Long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDateTime getHorarioSolicitacao() {
        return horarioSolicitacao;
    }

    public void setHorarioSolicitacao(LocalDateTime horarioSolicitacao) {
        this.horarioSolicitacao = horarioSolicitacao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}


