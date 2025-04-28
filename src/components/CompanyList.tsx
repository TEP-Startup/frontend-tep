import React, { useEffect, useState } from 'react';
import { getCompanies } from '../services/api';
import { Link } from 'react-router-dom';

interface Company {
  id: number;
  name: string;
  sector: string;
  logoUrl: string;
}

const CompanyList: React.FC = () => {
  const [companies, setCompanies] = useState<Company[]>([]);

  useEffect(() => {
    getCompanies().then((response) => setCompanies(response.data));
  }, []);

  return (
    <div>
      <h1>Empresas</h1>
      <ul>
        {companies.map((company) => (
          <li key={company.id}>
            <h2>{company.name}</h2>
            <p>{company.sector}</p>
            <Link to={`/companies/${company.id}`}>Ver detalhes</Link>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default CompanyList;