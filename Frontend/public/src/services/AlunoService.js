import api from './api';

export const enviarMoedas = async (transacao) => api.post('/transacoes/enviar', transacao);
export const consultarExtrato = async (id) => api.get(`/alunos/${id}/extrato`);
export const resgatarVantagem = async (alunoId, vantagemId) => {
  return api.post('/transacoes/resgatar', { alunoId, vantagemId });
};
