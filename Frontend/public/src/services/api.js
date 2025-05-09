import axios from 'axios';

const api = axios.create({
    baseURL: 'http://localhost:8080',  // URL base do back-end
});

export default api;

import api from './api';

export const getAlunos = async () => api.get('/alunos');
export const createAluno = async (aluno) => api.post('/alunos', aluno);
export const updateAluno = async (id, aluno) => api.put(`/alunos/${id}`, aluno);
export const deleteAluno = async (id) => api.delete(`/alunos/${id}`);

import api from './api';

export const getEmpresas = async () => api.get('/empresas');
export const createEmpresa = async (empresa) => api.post('/empresas', empresa);
export const updateEmpresa = async (id, empresa) => api.put(`/empresas/${id}`, empresa);
export const deleteEmpresa = async (id) => api.delete(`/empresas/${id}`);

import api from './api';

export const getProfessores = async () => api.get('/professores');
export const createProfessor = async (professor) => api.post('/professores', professor);
export const updateProfessor = async (id, professor) => api.put(`/professores/${id}`, professor);
export const deleteProfessor = async (id) => api.delete(`/professores/${id}`);

import api from './api';

export const getTransacoes = async () => api.get('/transacoes');
export const createTransacao = async (transacao) => api.post('/transacoes', transacao);
export const updateTransacao = async (id, transacao) => api.put(`/transacoes/${id}`, transacao);
export const deleteTransacao = async (id) => api.delete(`/transacoes/${id}`);


