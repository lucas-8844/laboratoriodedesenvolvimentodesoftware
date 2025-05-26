import React, { useEffect, useState } from 'react';
import { listarVantagens } from '../services/vantagemService';

function ListagemVantagensPage() {
    const [vantagens, setVantagens] = useState([]);

    useEffect(() => {
        loadVantagens();
    }, []);

    const loadVantagens = async () => {
        const response = await listarVantagens();
        setVantagens(response.data);
    };

    return (
        <div className="container mt-4">
            <h2>Lista de Vantagens</h2>
            <ul className="list-group">
                {vantagens.map((vantagem) => (
                    <li key={vantagem.id} className="list-group-item d-flex justify-content-between align-items-center">
                        <div>
                            <strong>{vantagem.nome}</strong><br />
                            {vantagem.descricao}<br />
                            <span className="badge bg-primary">
                                {vantagem.custoEmMoedas} moedas
                            </span>
                        </div>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default ListagemVantagensPage;
