import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter } from 'react-router-dom';
import './index.css';
import AppRouter from './Router';
import Home from './Home';
import reportWebVitals from './reportWebVitals';
import axios from 'axios';

ReactDOM.render(
  <React.StrictMode>
    <BrowserRouter>
      {/* <Home /> */}
      < AppRouter />
    </BrowserRouter>
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
