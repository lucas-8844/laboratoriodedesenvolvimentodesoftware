import React, { useEffect, useState } from 'react';
import { listarVantagens } from '../services/vantagemService';
import { resgatarVantagem } from '../services/alunoService';

function ResgatarVantagemPage() {
    const [vantagens, setVantagens] = useState([]);
    const [alunoId, setAlunoId] = useState('');

    useEffect(() => {
        const load = async () => {
            const resp = await listarVantagens();
            setVantagens(resp.data);
        };
        load();
    }, []);

    const handleResgatar = async (vantagemId) => {
        try {
            await resgatarVantagem(parseInt(alunoId), vantagemId);
            alert("Vantagem resgatada com sucesso!");
        } catch (error) {
            alert("Erro: " + error.response.data);
        }
    };

    return (
        <div className="container mt-4">
            <h2>Resgatar Vantagem</h2>
            <input className="form-control mb-3" placeholder="ID do Aluno" value={alunoId} onChange={(e) => setAlunoId(e.target.value)} />
            <ul className="list-group">
                {vantagens.map((v) => (
                    <li key={v.id} className="list-group-item d-flex justify-content-between align-items-center">
                        <div>
                            <strong>{v.nome}</strong><br />
                            {v.descricao} — <strong>{v.custoEmMoedas} moedas</strong>
                        </div>
                        <button className="btn btn-success" onClick={() => handleResgatar(v.id)}>Resgatar</button>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default ResgatarVantagemPage;
