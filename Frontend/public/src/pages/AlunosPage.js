import React, { useState, useEffect } from 'react';
import { getAlunos, createAluno, updateAluno, deleteAluno } from '../services/alunoService';

function AlunosPage() {
    const [alunos, setAlunos] = useState([]);
    const [nome, setNome] = useState('');
    const [email, setEmail] = useState('');

    useEffect(() => {
        loadAlunos();
    }, []);

    const loadAlunos = async () => {
        const response = await getAlunos();
        setAlunos(response.data);
    };

    const handleCreate = async () => {
        await createAluno({ nome, email, moedas: 100 });
        loadAlunos();
    };

    const handleDelete = async (id) => {
        await deleteAluno(id);
        loadAlunos();
    };

    return (
        <div>
            <h2>Alunos</h2>
            <input placeholder="Nome" value={nome} onChange={(e) => setNome(e.target.value)} />
            <input placeholder="Email" value={email} onChange={(e) => setEmail(e.target.value)} />
            <button onClick={handleCreate}>Cadastrar</button>

            <ul>
                {alunos.map((aluno) => (
                    <li key={aluno.id}>
                        {aluno.nome} - {aluno.email}
                        <button onClick={() => handleDelete(aluno.id)}>Excluir</button>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default AlunosPage;
