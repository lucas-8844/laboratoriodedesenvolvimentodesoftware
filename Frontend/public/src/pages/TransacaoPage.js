import React, { useState, useEffect } from 'react';
import { getTransacoes, createTransacao, deleteTransacao } from '../services/transacaoService';

function TransacaoPage() {
    const [transacoes, setTransacoes] = useState([]);
    const [tipo, setTipo] = useState('');
    const [valor, setValor] = useState('');

    useEffect(() => {
        loadTransacoes();
    }, []);

    const loadTransacoes = async () => {
        const response = await getTransacoes();
        setTransacoes(response.data);
    };

    const handleCreate = async () => {
        await createTransacao({ tipo, valor });
        loadTransacoes();
    };

    const handleDelete = async (id) => {
        await deleteTransacao(id);
        loadTransacoes();
    };

    return (
        <div>
            <h2>Transações</h2>
            <input placeholder="Tipo" value={tipo} onChange={(e) => setTipo(e.target.value)} />
            <input placeholder="Valor" value={valor} onChange={(e) => setValor(e.target.value)} />
            <button onClick={handleCreate}>Registrar</button>

            <ul>
                {transacoes.map((transacao) => (
                    <li key={transacao.id}>
                        {transacao.tipo} - {transacao.valor} moedas
                        <button onClick={() => handleDelete(transacao.id)}>Excluir</button>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default TransacaoPage;
