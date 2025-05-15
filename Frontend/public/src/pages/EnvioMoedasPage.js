import React, { useState } from 'react';
import { enviarMoedas } from '../services/alunoService';

function EnvioMoedasPage() {
    const [alunoId, setAlunoId] = useState('');
    const [valor, setValor] = useState('');

    const handleEnviar = async () => {
        await enviarMoedas({
            tipo: 'DISTRIBUICAO',
            valor: parseInt(valor),
            aluno: { id: parseInt(alunoId) }
        });
        alert('Moedas enviadas com sucesso!');
    };

    return (
        <div className="container mt-4">
            <h2>Enviar Moedas</h2>
            <input 
                className="form-control mb-2"
                placeholder="ID do Aluno"
                value={alunoId}
                onChange={(e) => setAlunoId(e.target.value)}
            />
            <input 
                className="form-control mb-2"
                placeholder="Quantidade de Moedas"
                value={valor}
                onChange={(e) => setValor(e.target.value)}
            />
            <button className="btn btn-success" onClick={handleEnviar}>Enviar</button>
        </div>
    );
}

export default EnvioMoedasPage;
