import logo from "./logo.svg";
import "./App.css";
import "./css/backgroud.css";
import HomeView from "./View/HomeView";
import LoginView from "./View/LoginView";
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import SignUp from "./View/SignUpView";
import React from "react";

function App() {
  return (
      <Router>
        <Routes>
          <Route path="/login" element={<LoginView />}/>
          <Route path="/signup" element={<SignUp />} />
          <Route path="/*" element={<HomeView />}/>
        </Routes>
      </Router>
  );
}

export default App;
