import React, { useState } from 'react';
import axios from "axios";
import { BASE_URL } from "../services/helper.js";
import toast from "react-hot-toast";
import { useNavigate } from "react-router-dom"

const ResetPassword = () => {
    
    const [email,setEmail] = useState("");
    const [license,setLicense] = useState("");
    const [password,setPassword] = useState("");
    const navigate = useNavigate();

    const handleResetPassword = async (e) =>{
        e.preventDefault();
        try{
            const res = await axios.put(`${BASE_URL}/pharmacist/change-password/${email}`,{
                licenseNumber: license,
                newPassword: password
            });
            const data = await res.data;
            if(data.success){
                toast.success(data.message);
                navigate("/login");
            } else {
                toast.error(data.message);
            }
        }catch(error){
            console.log(error.message);
            toast.error("Failed to reset password. Please try again later.");
        }
    }
    return (
        <div className="flex justify-center items-center h-screen">
        <form onSubmit={handleResetPassword} className="bg-white rounded-lg p-5 shadow-lg flex flex-col gap-3 w-[80vw] lg:w-[23vw] text-sm">
             <span className="text-lg text-gray-600 cursor-pointer -mb-1 text-center">Enter Your Email For Verification : </span>
             <input type="email" name="email" id="email" className="outline-none border rounded-md px-3 py-2 focus:border-green-300 text-gray-600"
             autoComplete="off"
             placeholder="abc@email.com"
             required
             value={email}
             onChange={(e)=>setEmail(e.target.value)}/>
             <span className="text-lg text-gray-600 cursor-pointer -mb-1 text-center">Enter Your LICENSE NUMBER For Verification</span>
             <input type="text" name="license" id="license" className="outline-none border rounded-md px-3 py-2 focus:border-green-300 text-gray-600"
             autoComplete="off"
             placeholder="ISP8568SC"
             required
             value={license}
             onChange={(e)=>setLicense(e.target.value)}/>
             <span className="text-lg text-gray-600 cursor-pointer -mb-1 text-center">Enter Your new password</span>
             <input type="password" name="password" id="password" className="outline-none border rounded-md px-3 py-2 focus:border-green-300 text-gray-600"
             autoComplete="off"
             placeholder="**********"
             required
             value={password}
             onChange={(e)=>setPassword(e.target.value)}/>
        <button type="submit" className="outline-none border rounded-md px-3 py-2 text-white bg-green-500 hover:bg-green-300">Reset Password</button>
        
        </form>
    </div>
    )
}

export default ResetPassword
