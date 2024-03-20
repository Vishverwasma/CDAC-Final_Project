import React from 'react';
import { FaMinus, FaTrashAlt } from "react-icons/fa";
import { IoMdAdd } from "react-icons/io";
import { useDispatch , useSelector } from "react-redux";
import {toast} from 'react-hot-toast'
import { BASE_URL, getCart } from '../services/helper';
import axios from "axios";
import { setCart } from '../redux/slices/cartSlice';


const CartMedicine = ({id,name,qty,price,img,_id}) => {
    const dispatch = useDispatch();
    const user = useSelector(state =>state.auth.user)

    const removeFromCart = async(id)=>{
        const res = await axios.delete(`${BASE_URL}/cart/medicine/del/${id}`)
        const data = await res.data;
        toast.success(data.message);
        getCart(user).then((data)=>dispatch(setCart(data.cartItems)))
    };
    const incrementQty = async(id) => {
        const res = await axios.put(`${BASE_URL}/cart/medicine/put/${id}`)
        const data = await res.data;
        getCart(user).then((data)=>dispatch(setCart(data.cartItems)))
    };
    const decrementQty = async(id)=>{
        const res = await axios.put(`${BASE_URL}/cart/medicine/put/${id}`)
        const data = await res.data;
        getCart(user).then((data)=>dispatch(setCart(data.cartItems)))
    };
    return (
        <div className="flex gap-2 shadow-md rounded-lg p-2 mb-3">
        <FaTrashAlt onClick={()=>{
             removeFromCart(_id);
             }} className="absolute right-7 text-gray-600 cursor-pointer"/>
            <img src={img} alt="" className="w-[50px] h-[50px]"/>
            <div className="leading-5">
                <h2 className="font-bold text-gray-800">{name}</h2>
            <div className="flex justify-between">
                <span className="text-green-500 font-bold">₹{price}</span>
            <div className="flex justify-center item-center gap-2 absolute right-7">
                <FaMinus onClick={()=>{
                    removeFromCart()
                }}
                onClick={()=> qty>1 ? decrementQty(_id) : (qty=0)}
                 className="border-2 border-gray-600 text-gray-600 hover:text-white hover:bg-red-500 hover:border-none rounded-md p-1 text-xl transition-all ease-linear cursor-pointer"/>
            <span>
                    {qty}
            </span>
                <IoMdAdd 
                onClick={()=> qty>=1 ? incrementQty(_id) : (qty=0)}
                className="border-2 border-gray-600 text-gray-600 hover:text-white hover:bg-green-500 hover:border-none rounded-md p-1 text-xl transition-all ease-linear cursor-pointer"/></div>
            </div>
           </div>
        </div>
    )
}

export default CartMedicine
