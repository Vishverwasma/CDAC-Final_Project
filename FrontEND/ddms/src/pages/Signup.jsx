import axios from 'axios';
import React, { useState } from 'react';
import toast from "react-hot-toast";
import { Link, useNavigate } from 'react-router-dom';
import { BASE_URL } from '../services/helper';
const Signup = () => {
    const navigate = useNavigate();

    const [name,setName] = useState("");
    const [license,setLicense] = useState("");
    const [email,setEmail] = useState("");
    const [password,setPassword] = useState("");
    const [address,setAddress] = useState("");

    const handleSignup = async(e)=>{
        e.preventDefault();
        const res = await axios.post(`${BASE_URL}/pharmacist/signup`, {
            name: name,
            licenseNumber: license,
            email: email,
            password: password,
            address: address
        });
        const data = await res.data;
        if(res.status===201){
            toast.success(data.message);
            navigate("/login");
        }
        else if(res.status===400 || res.status===500){
            toast.error(data.message);
        }
    }
    return (
        <div className="flex justify-center items-center h-screen">
        <form onSubmit={handleSignup} className="bg-white rounded-lg p-5 shadow-lg flex flex-col gap-3 w-[80vw] lg:w-[20vw] text-sm">
            <input type="text" name="name" id="name" className="outline-none border rounded-md px-3 py-2 focus:border-green-300 text-gray-600"
             autoComplete="off"
             placeholder="Username"
             required
             value={name}
             onChange={(e)=>setName(e.target.value)}/>
             <input type="text" name="license" id="license" className="outline-none border rounded-md px-3 py-2 focus:border-green-300 text-gray-600"
             autoComplete="off"
             placeholder="ISP8568SC"
             required
             value={license}
             onChange={(e)=>setLicense(e.target.value)}/>
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
             <input type="text" name="address" id="address" className="outline-none border rounded-md px-3 py-2 focus:border-green-300 text-gray-600"
             autoComplete="off"
             placeholder="City , State"
             required
             value={address}
             onChange={(e)=>setAddress(e.target.value)}/>
        
        <button type="submit" className="outline-none border rounded-md px-3 py-2 text-white bg-green-500 hover:bg-green-300">Create Account</button>
        <p className="text-xs text-gray-600 flex gap-2 -mt-1">
            <span>Or</span>
            <Link to="/login" className="hover:text-green-600">Login to Your Account</Link>
        </p>
        </form>
    </div>
    )
}

export default Signup
