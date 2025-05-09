import axios from 'axios';

const api = axios.create({
    baseURL: 'http://localhost:8080', // URL base do back-end
});

export default api;

import React from 'react';
import HomePage from './pages/HomePage';

function App() {
    return (
        <div className="App">
            <HomePage />
        </div>
    );
}

export default App;

