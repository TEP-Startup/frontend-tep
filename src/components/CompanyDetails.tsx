import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { getCompanyById } from '../services/api';

interface Company {
  id: number;
  name: string;
  description: string;
  sector: string;
  logoUrl: string;
  website: string;
}

const CompanyDetails: React.FC = () => {
  const { id } = useParams<{ id: string }>();
  const [company, setCompany] = useState<Company | null>(null);

  useEffect(() => {
    if (id) {
      getCompanyById(Number(id)).then((response) => setCompany(response.data));
    }
  }, [id]);

  if (!company) return <p>Carregando...</p>;

  return (
    <div>
      <h1>{company.name}</h1>
      <p>{company.description}</p>
      <p>Setor: {company.sector}</p>
      <a href={company.website} target="_blank" rel="noopener noreferrer">
        Website
      </a>
    </div>
  );
};

export default CompanyDetails;