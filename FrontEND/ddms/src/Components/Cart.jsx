import { React, useState } from 'react';
import { HiOutlineShoppingCart } from "react-icons/hi2";
import { IoMdClose } from "react-icons/io";
import { useDispatch , useSelector } from "react-redux";
import CartMedicine from './CartMedicine.jsx';
import { useNavigate } from "react-router-dom"
import axios from "axios";
import { BASE_URL } from '../services/helper.js';
axios.defaults.withCredentials = true;

const Cart = () => {
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const [activeCart,setActiveCart] = useState(false);
    const cartItems = useSelector((state)=>state.cart.cart);
    const totalQty = cartItems.reduce((totalQty,item)=>totalQty+item.qty,0);
    const totalPrice = cartItems.reduce((total,item)=>total+item.qty*item.price,0);
    const user = useSelector(state => state.auth.user);
    console.log(cartItems);
            
    
    const checkOut = async()=>{
        try {
            if (user && user._id) {
         const res = await axios.get(`${BASE_URL}/cart/medicine/checkout`,{
            params: {
                userId: user._id
            }
         });
         const {url} = await res.data;
         window.location.href = url;
        } else {
            console.error("User ID is undefined. Cannot proceed with checkout.");
        }
    } catch (error) {
        console.error("Error during checkout:", error);
    }
    }

    console.log("Cart Items:", cartItems);
    const handleToggleCart = () => {
        setActiveCart(!activeCart);
    };

    return (
        <>
            <div className={`fixed right-0 top-0 w-full lg:w-[20vw] h-full p-5 bg-white mb-3 ${activeCart?"translate-x-0":"translate-x-full"} transition-all duration-500 z-50`}>
                <div className="flex justify-between items-center my-3">
                    <span className="text-xl font-bold text-gray-800">MyOrder</span>
                    <IoMdClose onClick={()=>setActiveCart(!activeCart)} className="border-2 border-gray-600 text-gray-600 font-bold p-1 text-xl rounded-md hover:text-red-300 cursor-pointer"/>
                </div>

                {cartItems.length>0 ? cartItems.map((medicine)=>{
                    return (<CartMedicine 
                        key={medicine.id}
                    {...medicine}
                    // id={medicine.id}
                    // name={medicine.name}
                    // price={medicine.price}
                    // desc={medicine.desc}
                    // qty={medicine.qty}
                    // img={medicine.img}
                    />
                );
                }):<h2 className="text-center text-xl font-bold text-gray">Your Cart is Empty!</h2>}
               
            <div className="absolute bottom-0">
                <h3 className="font-semibold text-gray-800">Meds : {totalQty}</h3>
                <h3 className="font-semibold text-gray-800">Total Amount : {totalPrice}</h3>
                <hr className="w-[90vw] lg:w-[18vw] my-2"/>
                <button onClick={checkOut} className="bg-green-500 font-bold px-3 text-white py-2 rounded-lg w-[90vw] lg:w-[18vw] mb-5">Checkout</button>
            </div>
            </div>
            <HiOutlineShoppingCart onClick={handleToggleCart} className={`rounded-full bg-white shadow-md text-5xl p-3 fixed bottom-4 right-4 ${totalQty>0 && "animate-bounce delay-500 transition-all"}`}/>
        </>
    )
}

export default Cart
