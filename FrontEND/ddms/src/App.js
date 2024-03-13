import './App.css';
import { BrowserRouter ,Route ,Routes } from 'react-router-dom';
import Home from './pages/Home';
import Success from './pages/Success';
import Error from './pages/Error';
import Login from './pages/Login';
import Signup from './pages/Signup';
import User from './pages/User';
import ProtectedRoutes from './Components/ProtectedRoutes';
function App() {
  return (
    <BrowserRouter>
       <Routes>
        <Route path="/" element={<Home/>} />
        <Route path="/success" element={<ProtectedRoutes element={<Success/>}/>} />
        <Route path="/User" element={<User/>} />
        <Route path="/User/login" element={<Login/>} />
        <Route path="/User/register" element={<Signup/>} />
        <Route path="/*" element={<Error/>} />
       </Routes>
    </BrowserRouter>
  );
}

export default App;
