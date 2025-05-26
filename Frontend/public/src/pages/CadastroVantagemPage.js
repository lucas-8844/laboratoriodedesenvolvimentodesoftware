import React, { useState } from 'react';
import { cadastrarVantagem } from '../services/vantagemService';

function CadastroVantagemPage() {
    const [nome, setNome] = useState('');
    const [descricao, setDescricao] = useState('');
    const [custoEmMoedas, setCustoEmMoedas] = useState('');
    const [empresaId, setEmpresaId] = useState('');

    const handleCadastrar = async () => {
        try {
            await cadastrarVantagem({
                nome,
                descricao,
                custoEmMoedas: parseInt(custoEmMoedas),
                empresa: { id: parseInt(empresaId) }
            });
            alert('Vantagem cadastrada com sucesso!');
            setNome('');
            setDescricao('');
            setCustoEmMoedas('');
            setEmpresaId('');
        } catch (error) {
            alert('Erro ao cadastrar vantagem');
        }
    };

    return (
        <div className="container mt-4">
            <h2>Cadastro de Vantagens</h2>
            <input className="form-control mb-2" placeholder="Nome" value={nome} onChange={(e) => setNome(e.target.value)} />
            <input className="form-control mb-2" placeholder="Descrição" value={descricao} onChange={(e) => setDescricao(e.target.value)} />
            <input className="form-control mb-2" placeholder="Custo em Moedas" value={custoEmMoedas} onChange={(e) => setCustoEmMoedas(e.target.value)} />
            <input className="form-control mb-2" placeholder="ID da Empresa" value={empresaId} onChange={(e) => setEmpresaId(e.target.value)} />
            <button className="btn btn-success" onClick={handleCadastrar}>Cadastrar</button>
        </div>
    );
}

export default CadastroVantagemPage;
