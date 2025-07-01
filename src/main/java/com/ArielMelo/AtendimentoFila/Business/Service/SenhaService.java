package com.ArielMelo.AtendimentoFila.Business.Service;

import com.ArielMelo.AtendimentoFila.Infrastructure.Entities.Senha;
import com.ArielMelo.AtendimentoFila.Infrastructure.Entities.Status;
import com.ArielMelo.AtendimentoFila.Infrastructure.Repository.SenhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class SenhaService {

    @Autowired
    private SenhaRepository senhaRepository;

    private AtomicInteger contador = new AtomicInteger(0);

    public Senha gerarNovaSenha(){
        String codigo = String.format("A%03d", contador.incrementAndGet());
        Senha nova = new Senha(codigo, LocalDateTime.now(), Status.NOVA);
        return senhaRepository.save(nova);
    }

    public List<Senha> ListarSenhasAtivas(){
        return senhaRepository.findByStatus(Status.NOVA);
    }

    public Senha chamarProximaSenha(){
        Senha proxima = senhaRepository
                .findFirstByStatusOrderByHorarioSolicitacaoAsc(Status.NOVA)
                .orElseThrow(() -> new RuntimeException("Não há senhas na fila"));

        proxima.setStatus(Status.EM_ATENDIMENTO);
        return senhaRepository.save(proxima);
    }

    public Senha finalizarSenha(Long id){
        Senha senha = senhaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Senha não encontrada"));

        senha.setStatus(Status.ATENDIDA);
        return senhaRepository.save(senha);
    }

    public List<Senha> ListarTodas(){
        return senhaRepository.findAll();
    }
}
