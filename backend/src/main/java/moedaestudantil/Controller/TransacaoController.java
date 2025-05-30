package com.moedaestudantil.controller;

import com.moedaestudantil.model.Transacao;
import com.moedaestudantil.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping
    public List<Transacao> listar() {
        return transacaoService.listar();
    }

    @PostMapping
    public Transacao salvar(@RequestBody Transacao transacao) {
        return transacaoService.salvar(transacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transacao> atualizar(@PathVariable Long id, @RequestBody Transacao transacao) {
        Transacao atualizada = transacaoService.atualizar(id, transacao);
        if (atualizada != null) {
            return ResponseEntity.ok(atualizada);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (transacaoService.deletar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping("/enviar")
public ResponseEntity<Transacao> enviarMoedas(@RequestBody Transacao transacao) {
    try {
        Transacao novaTransacao = transacaoService.salvar(transacao);
        return ResponseEntity.ok(novaTransacao);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @PostMapping("/resgatar")
public ResponseEntity<?> resgatarVantagem(@RequestBody Map<String, String> payload) {
    try {
        Long alunoId = Long.parseLong(payload.get("alunoId"));
        Long vantagemId = Long.parseLong(payload.get("vantagemId"));

        Vantagem vantagem = vantagemRepository.findById(vantagemId)
            .orElseThrow(() -> new RuntimeException("Vantagem não encontrada"));

        Transacao transacao = transacaoService.resgatarVantagem(alunoId, vantagem);
        return ResponseEntity.ok(transacao);
    } catch (Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
}
}

