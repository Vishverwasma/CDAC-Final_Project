import { useState } from "react"
import { Link } from "react-router-dom"

const Login = () => {
    const [ email , setEmail ] = useState("");
    const [ password , setPassword ] = useState("");
    return (
        <div className="flex justify-center items-center h-screen">
            <form action="" className="bg-white rounded-lg p-5 shadow-lg flex flex-col gap-3 w-[80vw] lg:w-[20vw] text-sm">
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
            <Link to="/forgot-password" className="text-xs text-gray-600 hover:underline cursor-default-mb-1"></Link>
            </form>
        </div>
    )
}

export default Login
