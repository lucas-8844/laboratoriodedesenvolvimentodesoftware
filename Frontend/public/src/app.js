import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import AlunosPage from './pages/AlunosPage';

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<AlunosPage />} />
                <Route path="/alunos" element={<AlunosPage />} />
            </Routes>
        </Router>
    );
}

export default App;

