import axios from "axios";
import React, { useEffect, useState } from 'react';
import { GiHamburgerMenu } from "react-icons/gi";
import { MdClose } from "react-icons/md";
import { useDispatch, useSelector } from "react-redux";
import { loginUser, setUser } from "../redux/slices/AuthSlice";
import { setSearch } from "../redux/slices/SearchSlice";
import { BASE_URL, getCart } from "../services/helper";
import NavList from './NavList';
import { setCart } from "../redux/slices/cartSlice";


axios.defaults.withCredentials = true;


const Navbar = () => {
    const dispatch = useDispatch();
    const [ toggleNav , setToggleNav ] = useState(false);
    const auth = useSelector((state) => state.auth.isAuth);
    const user = useSelector((state) => state.auth.user);
    
    useEffect(() => {
        if (auth && user && user._id) {
            getUser(user._id);
        }
    }, [auth, user]);
    
    const getUser = async()=>{
    if (auth && user && user._id) {
        try {
        const res = await axios.get(`${BASE_URL}/pharmacist/get-user/${user._id}`,{
            withCredentials: true,
        });
        const data = await res.data;
        dispatch(setUser(data.user));
        dispatch(loginUser());
        console.log("auth:", auth);
        console.log("user:", user);
        getCart(user).then((data)=>dispatch(setCart(data.cartItems)));
       }
       catch (error) {
        console.error("Error fetching user data:", error);
       }
    } else {
        console.warn("User object or user ID is undefined. Cannot fetch user data.");
        // Handle case where user object or user ID is undefined
    }
};

    return (
        <nav className="flex flex-col lg:flex-row justify-between py-3 mx-6 mb-10">
            <div>
                <h3 className="text-xl font-bold text-gray-600">
                    {new Date().toUTCString().slice(0,16)}
                </h3>
                <h1 className="text-2xl font-bold ">
                    DDMS-CDAC
                </h1>
            </div>
            <div>
                <input type="search" 
                id="" 
                placeholder="Search Your Order"
                autoComplete="off"
                onChange={(e)=>dispatch(setSearch(e.target.value))}
                className="p-3 border border-gray-400 text-sm rounded-lg outline-none w-full lg:w-[25vw]"/>
            </div>
            <GiHamburgerMenu className={`absolute top-5 right-5 lg:right-8 lg:top-6 text-2xl text-gray-600 cursor-pointer ${
                toggleNav  && "hidden"
            } transition-all ease-in-out duration-500`}
            onClick={()=> setToggleNav(true)}/>
            <MdClose className={`absolute top-5 right-5 lg:right-8 lg:top-6 text-2xl text-gray-600 cursor-pointer ${
                !toggleNav  && "hidden"
            } transition-all ease-in-out duration-500`}
            onClick={()=>setToggleNav(false)}
            />
        <NavList toggleNav={toggleNav} setToggleNav={setToggleNav} auth={auth}/>
        </nav>
    )
}

export default Navbar
