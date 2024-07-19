import axios from "axios";
import { useState } from "react";
import toast from "react-hot-toast";
import { useDispatch } from "react-redux";
import { Link, useNavigate } from "react-router-dom";
import { loginUser } from "../redux/slices/AuthSlice";
import { BASE_URL } from '../services/helper';



const Login = () => {
    const [ email , setEmail ] = useState("");
    const [ password , setPassword ] = useState("");
    const dispatch = useDispatch();
    const navigate = useNavigate();


    const handleLogin = async(e) =>{
        e.preventDefault();
        try{
            const res = await axios.post(`${BASE_URL}/pharmacist/login`,{
                email: email,
                password: password,
            });
            // const data = await res.data;
            const data = res.data;
            if(res.status===200){
                dispatch(loginUser(data.user));
                toast.success(data.message);
                navigate("/");
            }
        }catch(error){
            if (error.response && error.response.status === 401) {
                toast.error("Invalid email or password");
            } else {
                toast.error("Login failed. Please check your credentials.");
            }
        }
    };
    
    return (
        <div className="flex justify-center items-center h-screen">
            <form onSubmit={handleLogin} className="bg-white rounded-lg p-5 shadow-lg flex flex-col gap-3 w-[80vw] lg:w-[20vw] text-sm">
                 <input type="email" name="email" id="email" className="outline-none border rounded-md px-3 py-2 focus:border-green-300 text-gray-600"
                 autoComplete="off"
                 placeholder="abc@email.com"
                 required
                 value={email}
                 onChange={(e)=>setEmail(e.target.value)}/>
                 <input type="password" name="password" id="password" className="outline-none border rounded-md px-3 py-2 focus:border-green-300 text-gray-600"
                 autoComplete="off"
                 placeholder="**********"
                 required
                 value={password}
                 onChange={(e)=>setPassword(e.target.value)}/>
            <Link to="/forgot-password" className="text-xs text-gray-600 hover:underline cursor-pointer -mb-1">Forgot Password</Link>
            <button type="submit" className="outline-none border rounded-md px-3 py-2 text-white bg-green-500 hover:bg-green-300">Login</button>
            <p className="text-xs text-gray-600 flex gap-2 -mt-1">
                <span>Or</span>
                <Link to="/signup" className="hover:text-green-600">Create new Account</Link>
            </p>
            </form>
        </div>
    )
}

export default Login
