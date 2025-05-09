import React, { useEffect, useState } from 'react';
import api from '../services/api';

function HomePage() {
    const [alunos, setAlunos] = useState([]);

    useEffect(() => {
        api.get('/alunos')
            .then(response => {
                setAlunos(response.data);
            })
            .catch(error => {
                console.error("Erro ao buscar alunos: ", error);
            });
    }, []);

    return (
        <div className="container">
            <h1 className="mt-4">Lista de Alunos</h1>
            <ul className="list-group">
                {alunos.map(aluno => (
                    <li key={aluno.id} className="list-group-item">
                        {aluno.nome} - {aluno.email}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default HomePage;
