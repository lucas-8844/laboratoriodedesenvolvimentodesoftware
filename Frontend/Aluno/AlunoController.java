package com.moedaestudantil.controller;

import com.moedaestudantil.model.Aluno;
import com.moedaestudantil.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@CrossOrigin(origins = "*") // Para permitir chamadas do front-end
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping
    public Aluno cadastrarAluno(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @GetMapping
    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll();
    }
}
