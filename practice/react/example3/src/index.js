import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';
import CommentList from './component/CommentList';
import NotificationList from './notification/NotificationList';
import Accommodate from './hook/Accommodate';
import ConfirmButton from './clickEvent/ConfirmButton';
import LandingPage from './conditionalRendering/LandingPage';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <>
    <LandingPage />
    <ConfirmButton />
    <Accommodate />
    <NotificationList />
    <CommentList />
  </>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
