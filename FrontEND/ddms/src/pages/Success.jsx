import React, { useEffect, useState } from 'react'
import { FadeLoader } from "react-spinners"
import axios from "axios"
import { BASE_URL } from '../services/helper';
import { useSelector } from 'react-redux'
import toast from 'react-hot-toast'


const Success = () => {
    const user = useSelector(state => state.auth.user);

    const [loading, setLoading] = useState(true);
    useEffect(()=>{
        setTimeout(()=>{
            setLoading(false);
        },3000)
    },[]);

    const clearCart = async()=>{
        const res = await axios.get(`${BASE_URL}/cart/clear/${user._id}`);
        const data = await res.data;
        toast.success(data.message)
    }

    useEffect(()=>{
        clearCart();
    },[]);
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
