package com.moedaestudantil.controller;

import com.moedaestudantil.model.Aluno;
import com.moedaestudantil.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> listar() {
        return alunoService.listar();
    }

    @PostMapping
    public Aluno salvar(@RequestBody Aluno aluno) {
        return alunoService.salvar(aluno);
    }
    @GetMapping("/{id}/extrato")
public ResponseEntity<List<Transacao>> consultarExtrato(@PathVariable Long id) {
    try {
        List<Transacao> extrato = transacaoService.consultarPorAluno(id);
        return ResponseEntity.ok(extrato);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}

}
