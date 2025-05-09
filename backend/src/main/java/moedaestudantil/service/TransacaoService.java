package com.moedaestudantil.service;

import com.moedaestudantil.model.Transacao;
import com.moedaestudantil.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public List<Transacao> listar() {
        return transacaoRepository.findAll();
    }

    public Transacao salvar(Transacao transacao) {
        transacao.setData(java.time.LocalDateTime.now());
        return transacaoRepository.save(transacao);
    }

    public Transacao atualizar(Long id, Transacao transacaoAtualizada) {
        Optional<Transacao> transacaoExistente = transacaoRepository.findById(id);
        if (transacaoExistente.isPresent()) {
            Transacao transacao = transacaoExistente.get();
            transacao.setTipo(transacaoAtualizada.getTipo());
            transacao.setValor(transacaoAtualizada.getValor());
            transacao.setAluno(transacaoAtualizada.getAluno());
            transacao.setEmpresa(transacaoAtualizada.getEmpresa());
            return transacaoRepository.save(transacao);
        }
        return null;
    }

    public boolean deletar(Long id) {
        if (transacaoRepository.existsById(id)) {
            transacaoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
