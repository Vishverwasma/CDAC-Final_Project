import React from 'react'
import { AiFillStar } from "react-icons/ai"
import { useDispatch, useSelector } from 'react-redux'
import {addToCart} from "../redux/slices/cartSlice";
import axios from "axios"
import toast from "react-hot-toast"
import { setCart } from '../redux/slices/cartSlice'
import { BASE_URL, getCart } from '../services/helper'

const MedsCard = ({id, name, price, desc, rating, img, handleToast}) => {
    const dispatch = useDispatch();
    const user = useSelector((state) =>state.auth.user)

    const handleAddToCart = async()=>{
        console.log(user);
        if (!user || !user._id) {
            toast.error("Please login to Add Medicine to Cart");
            return;
        }
        try{
            const res = await axios.post(`${BASE_URL}/cart/addMedicine/${user._id}`,
            {
                id: id,
                img: img,
                name: name,
                price: price,
                rating: rating,
                qty: 1,
            });
                const data = await res.data;
                dispatch(addToCart(data.medicine));
                toast.success(data.message);
                // getCart(user).then((data)=>dispatch(setCart(data.cartItems)));
        }catch (error) {
            console.error("Error adding medicine to cart:", error);
            toast.error("Failed to add medicine to cart. Please try again.");
        }
    };
    return (
        <div className="font-bold w-[250px] bg-white p-5 flex flex-col rounded-lg gap-2">
            <div>
            <img src={img}
            alt=""
            className="w-auto h-[130px] hover:scale-110 cursor-grab transition-all duration-500 ease-in-out"/>
            </div>
            <div className="text-sm flex justify-between">
                <h2>{name}</h2>
                <span className="text-green-500">₹{price}</span>
            </div>
            <p className="text-sm font-normal">{desc}</p>
            <div className="flex justify-between">
                <span className="flex justify-center items-center ">
                    <AiFillStar className="mr-1 text-yellow-400"/>{rating}
                </span>
                <button 
                onClick={handleAddToCart}
                //     onClick={()=>{
                // !user
                // ? toast.error("Please login to Add Medicine to Cart")
                // : addToCart({id,name,price,rating,img,qty:1,desc});
                // }}
                 className="p-1 text-white bg-green-600 rounded-lg text-sm">Add To Cart</button>
            </div>
        </div>
    )
}

export default MedsCard
