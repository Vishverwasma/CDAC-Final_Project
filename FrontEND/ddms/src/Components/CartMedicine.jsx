import React from 'react';
import { FaMinus, FaTrashAlt } from "react-icons/fa";
import { IoMdAdd } from "react-icons/io";
import { useDispatch } from "react-redux";
import { removeFromCart ,incrementQty ,decrementQty } from '../redux/slices/cartSlice';
import {toast} from 'react-hot-toast'
const CartMedicine = ({id,name,qty,price,img}) => {
    const dispatch = useDispatch();
    return (
        <div className="flex gap-2 shadow-md rounded-lg p-2 mb-3">
        <FaTrashAlt onClick={()=>{
             dispatch(removeFromCart({id,img,name,qty,price}));
             toast(`${name} removed`,{
                icon:"👋",
             })
             }} className="absolute right-7 text-gray-600 cursor-pointer"/>
            <img src={img} alt="" className="w-[50px] h-[50px]"/>
            <div className="leading-5">
                <h2 className="font-bold text-gray-800">{name}</h2>
            <div className="flex justify-between">
                <span className="text-green-500 font-bold">₹{price}</span>
            <div className="flex justify-center item-center gap-2 absolute right-7">
                <FaMinus onClick={()=> qty>1 ? dispatch(decrementQty({id})) : (qty=0)} className="border-2 border-gray-600 text-gray-600 hover:text-white hover:bg-red-500 hover:border-none rounded-md p-1 text-xl transition-all ease-linear cursor-pointer"/>
            <span>
                    {qty}
            </span>
                <IoMdAdd onClick={()=> qty>=1 ? dispatch(incrementQty({id})) : (qty=0)} className="border-2 border-gray-600 text-gray-600 hover:text-white hover:bg-green-500 hover:border-none rounded-md p-1 text-xl transition-all ease-linear cursor-pointer"/></div>
            </div>
           </div>
        </div>
    )
}

export default CartMedicine
