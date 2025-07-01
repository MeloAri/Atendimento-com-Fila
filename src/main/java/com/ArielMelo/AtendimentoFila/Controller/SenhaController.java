package com.ArielMelo.AtendimentoFila.Controller;

import com.ArielMelo.AtendimentoFila.Business.Service.SenhaService;
import com.ArielMelo.AtendimentoFila.Infrastructure.Entities.Senha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/senhas")
public class SenhaController {

    @Autowired
    private SenhaService senhaService;

    @PostMapping
    public Senha criar(){
        return senhaService.gerarNovaSenha();
    }

    @GetMapping("/ativas")
    public List<Senha> listarAtivas(){
        return senhaService.ListarSenhasAtivas();
    }

    @PutMapping("/proxima")
    public Senha chamarProxima(){
        return senhaService.chamarProximaSenha();
    }

    @PutMapping("/{id}/finalizar")
    public Senha finalizar(@PathVariable Long id){
        return senhaService.finalizarSenha(id);
    }

    @GetMapping("/historico")
    public List<Senha> listarTodas(){
        return senhaService.ListarTodas();
    }
}
