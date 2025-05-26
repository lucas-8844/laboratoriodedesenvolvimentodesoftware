import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Navbar from './components/Navbar';
import HomePage from './pages/HomePage';
import AlunosPage from './pages/AlunosPage';
import EmpresaPage from './pages/EmpresaPage';
import ProfessorPage from './pages/ProfessorPage';
import TransacaoPage from './pages/TransacaoPage';
import EnvioMoedasPage from './pages/EnvioMoedasPage';
import AlunoExtratoPage from './pages/AlunoExtratoPage';
import CadastroVantagemPage from './pages/CadastroVantagemPage';
import ListagemVantagensPage from './pages/ListagemVantagensPage';

function App() {
    return (
        <Router>
            <Navbar />
            <div className="container mt-4">
                <Routes>
                    <Route path="/" element={<HomePage />} />
                    <Route path="/alunos" element={<AlunosPage />} />
                    <Route path="/empresas" element={<EmpresaPage />} />
                    <Route path="/professores" element={<ProfessorPage />} />
                    <Route path="/transacoes" element={<TransacaoPage />} />
                    <Route path="/enviar-moedas" element={<EnvioMoedasPage />} />
                    <Route path="/extrato" element={<AlunoExtratoPage alunoId={1} />} />
                    <Route path="/cadastro-vantagem" element={<CadastroVantagemPage />} />
                    <Route path="/listagem-vantagens" element={<ListagemVantagensPage />} />
                </Routes>
            </div>
        </Router>
    );
}

export default App;

export default App;



