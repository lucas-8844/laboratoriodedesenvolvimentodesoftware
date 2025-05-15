import React, { useState, useEffect } from 'react';
import { consultarExtrato } from '../services/alunoService';

function AlunoExtratoPage({ alunoId }) {
    const [extrato, setExtrato] = useState([]);

    useEffect(() => {
        loadExtrato();
    }, []);

    const loadExtrato = async () => {
        const response = await consultarExtrato(alunoId);
        setExtrato(response.data);
    };

    return (
        <div className="container mt-4">
            <h2>Extrato de Transações</h2>
            <ul className="list-group">
                {extrato.map((transacao) => (
                    <li key={transacao.id} className="list-group-item">
                        {transacao.tipo} - {transacao.valor} moedas - {new Date(transacao.data).toLocaleString()}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default AlunoExtratoPage;
