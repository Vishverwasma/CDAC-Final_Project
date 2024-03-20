import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import ProtectedRoutes from './Components/ProtectedRoutes';
import Error from './pages/Error';
import Home from './pages/Home';
import Login from './pages/Login';
import ResetPassword from './pages/Reset-Password';
import Signup from './pages/Signup';
import Success from './pages/Success';
function App() {
  return (
    <BrowserRouter>
       <Routes>
        <Route path="/" element={<Home/>} />
        {/* <Route path="/success" element={<ProtectedRoutes element={<Success/>}/>} /> */}
        <Route path="/success" element={<Success />} />
        <Route path="/login" element={<Login/>} />
        <Route path="/signup" element={<Signup/>} />
        <Route path="/forgot-password" element={<ResetPassword/>} />
        <Route path="/*" element={<Error/>} />
       </Routes>
    </BrowserRouter>
  );
}

export default App;
