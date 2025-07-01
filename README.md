🧾 Sistema de Atendimento com Fila – API REST em Java
Projeto desenvolvido com Java e Spring Boot que simula o funcionamento de um sistema de senhas para atendimento em filas, como utilizado em bancos, clínicas, órgãos públicos ou empresas com alto fluxo de atendimento presencial.

✅ Principais Funcionalidades
Geração automática de senhas numeradas (ex: A001, A002...)

Controle de status das senhas: NOVA, EM_ATENDIMENTO e ATENDIDA

Chamada automática da próxima senha na fila

Finalização de senhas atendidas

Histórico completo de todas as senhas geradas

API RESTful testada com Postman

🛠️ Tecnologias Utilizadas
Java 17

Spring Boot

Spring Web

Spring Data JPA

Banco de Dados H2

Lombok

Postman para testes

🧠 Conceitos abordados
CRUD com JPA

Enumeração com @Enumerated

Fila de atendimento com ordenação por horário

Boas práticas com Service, Repository e Controller

AtomicInteger para controle de contador de senhas

DTOs e controle de fluxo RESTful

🔗 Possibilidades de expansão
Integração com painel visual (frontend com WebSocket ou polling)

Suporte a múltiplas filas (ex: fila A, B, C)

Registro de atendentes

Relatórios de tempo médio por senha


POST /senhas               → Gera uma nova senha
PUT  /senhas/proxima       → Chama a próxima senha
PUT  /senhas/{id}/finalizar → Finaliza uma senha
GET  /senhas/ativas        → Lista senhas ainda não atendidas
GET  /senhas/historico     → Lista todo o histórico de senhas
