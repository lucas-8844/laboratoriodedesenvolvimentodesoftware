import React, { useState, useEffect } from 'react';
import { getEmpresas, createEmpresa, deleteEmpresa } from '../services/empresaService';

function EmpresaPage() {
    const [empresas, setEmpresas] = useState([]);
    const [nome, setNome] = useState('');
    const [cnpj, setCnpj] = useState('');
    const [endereco, setEndereco] = useState('');

    useEffect(() => {
        loadEmpresas();
    }, []);

    const loadEmpresas = async () => {
        const response = await getEmpresas();
        setEmpresas(response.data);
    };

    const handleCreate = async () => {
        await createEmpresa({ nome, cnpj, endereco });
        loadEmpresas();
    };

    const handleDelete = async (id) => {
        await deleteEmpresa(id);
        loadEmpresas();
    };

    return (
        <div>
            <h2>Empresas</h2>
            <input placeholder="Nome" value={nome} onChange={(e) => setNome(e.target.value)} />
            <input placeholder="CNPJ" value={cnpj} onChange={(e) => setCnpj(e.target.value)} />
            <input placeholder="Endereço" value={endereco} onChange={(e) => setEndereco(e.target.value)} />
            <button onClick={handleCreate}>Cadastrar</button>

            <ul>
                {empresas.map((empresa) => (
                    <li key={empresa.id}>
                        {empresa.nome} - {empresa.cnpj} - {empresa.endereco}
                        <button onClick={() => handleDelete(empresa.id)}>Excluir</button>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default EmpresaPage;
