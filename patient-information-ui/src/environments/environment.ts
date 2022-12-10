declare global {
  interface Window {
    _env_: any
  }
}

if (!window._env_) {
  window._env_ = {};
}

const API_URL = window._env_.API_URL ? window._env_.API_URL : 'http://localhost:8080';

export const environment = {
  production: false,
  apiUrl: API_URL,
  defaultPageSize: 10,
  
};
