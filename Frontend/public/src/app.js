import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import AlunosPage from './pages/AlunosPage';
import EmpresaPage from './pages/EmpresaPage';
import ProfessorPage from './pages/ProfessorPage';
import TransacaoPage from './pages/TransacaoPage';

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<AlunosPage />} />
                <Route path="/alunos" element={<AlunosPage />} />
                <Route path="/empresas" element={<EmpresaPage />} />
                <Route path="/professores" element={<ProfessorPage />} />
                <Route path="/transacoes" element={<TransacaoPage />} />
            </Routes>
        </Router>
    );
}

export default App;


