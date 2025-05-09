package com.moedaestudantil.service;

import com.moedaestudantil.model.Aluno;
import com.moedaestudantil.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> listar() {
        return alunoRepository.findAll();
    }

    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }
}
