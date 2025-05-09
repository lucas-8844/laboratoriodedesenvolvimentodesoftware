package com.moedaestudantil.service;

import com.moedaestudantil.model.Empresa;
import com.moedaestudantil.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Empresa> listar() {
        return empresaRepository.findAll();
    }

    public Empresa salvar(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public Empresa atualizar(Long id, Empresa empresaAtualizada) {
        Optional<Empresa> empresaExistente = empresaRepository.findById(id);
        if (empresaExistente.isPresent()) {
            Empresa empresa = empresaExistente.get();
            empresa.setNome(empresaAtualizada.getNome());
            empresa.setCnpj(empresaAtualizada.getCnpj());
            empresa.setEndereco(empresaAtualizada.getEndereco());
            return empresaRepository.save(empresa);
        }
        return null;
    }

    public boolean deletar(Long id) {
        if (empresaRepository.existsById(id)) {
            empresaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
