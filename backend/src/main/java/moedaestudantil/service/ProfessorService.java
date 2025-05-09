package com.moedaestudantil.service;

import com.moedaestudantil.model.Professor;
import com.moedaestudantil.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> listar() {
        return professorRepository.findAll();
    }

    public Professor salvar(Professor professor) {
        return professorRepository.save(professor);
    }

    public Professor atualizar(Long id, Professor professorAtualizado) {
        Optional<Professor> professorExistente = professorRepository.findById(id);
        if (professorExistente.isPresent()) {
            Professor professor = professorExistente.get();
            professor.setNome(professorAtualizado.getNome());
            professor.setEmail(professorAtualizado.getEmail());
            professor.setCpf(professorAtualizado.getCpf());
            return professorRepository.save(professor);
        }
        return null;
    }

    public boolean deletar(Long id) {
        if (professorRepository.existsById(id)) {
            professorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
