import React, { useEffect, useState } from 'react'
import { FadeLoader } from "react-spinners"
const Success = () => {
    const [loading, setLoading] = useState(true);
    useEffect(()=>{
        setTimeout(()=>{
            setLoading(false);
        },3000)
    },[])
    return (
        <div className="flex flex-col items-center justify-center h-screen">
        {
            loading ? (<FadeLoader color="#36d7b7" />) : 
            (<div>
            <h2 className="text-3xl font-semibold mb-4 text-center">Order Successfully</h2>
            <p>Your Order has Been Placed Successfully!</p>
            </div>
            )}
        </div>
    )
}

export default Success
