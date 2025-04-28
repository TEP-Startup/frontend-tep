import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8080', // URL do backend
});

export const getCompanies = () => api.get('/public/companies');
export const getCompanyById = (id: number) => api.get(`/public/companies/${id}`);

export default api;