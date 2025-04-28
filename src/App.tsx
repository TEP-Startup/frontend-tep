import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import CompanyList from './components/CompanyList';
import CompanyDetails from './components/CompanyDetails';

const App: React.FC = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<CompanyList />} />
        <Route path="/companies" element={<CompanyList />} /> {/* Adicionada rota */}
        <Route path="/companies/:id" element={<CompanyDetails />} />
      </Routes>
    </Router>
  );
};

export default App;