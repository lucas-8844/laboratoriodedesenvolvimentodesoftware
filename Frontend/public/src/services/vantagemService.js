import api from './api';

export const cadastrarVantagem = async (vantagem) => api.post('/vantagens', vantagem);
export const listarVantagens = async () => api.get('/vantagens');
export const listarVantagensPorEmpresa = async (empresaId) => api.get(`/vantagens/empresa/${empresaId}`);
