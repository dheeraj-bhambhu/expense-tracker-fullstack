import axios from "axios";

const api = axios.create({
  baseURL: "https://expense-tracker-fullstack-project-1.onrender.com"
});

export default api;