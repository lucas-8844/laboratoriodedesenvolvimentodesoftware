import React, { useState, useEffect } from 'react';
import { getProfessores, createProfessor, deleteProfessor } from '../services/professorService';

function ProfessorPage() {
    const [professores, setProfessores] = useState([]);
    const [nome, setNome] = useState('');
    const [email, setEmail] = useState('');
    const [cpf, setCpf] = useState('');

    useEffect(() => {
        loadProfessores();
    }, []);

    const loadProfessores = async () => {
        const response = await getProfessores();
        setProfessores(response.data);
    };

    const handleCreate = async () => {
        await createProfessor({ nome, email, cpf });
        loadProfessores();
    };

    const handleDelete = async (id) => {
        await deleteProfessor(id);
        loadProfessores();
    };

    return (
        <div>
            <h2>Professores</h2>
            <input placeholder="Nome" value={nome} onChange={(e) => setNome(e.target.value)} />
            <input placeholder="Email" value={email} onChange={(e) => setEmail(e.target.value)} />
            <input placeholder="CPF" value={cpf} onChange={(e) => setCpf(e.target.value)} />
            <button onClick={handleCreate}>Cadastrar</button>

            <ul>
                {professores.map((professor) => (
                    <li key={professor.id}>
                        {professor.nome} - {professor.email} - {professor.cpf}
                        <button onClick={() => handleDelete(professor.id)}>Excluir</button>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default ProfessorPage;
