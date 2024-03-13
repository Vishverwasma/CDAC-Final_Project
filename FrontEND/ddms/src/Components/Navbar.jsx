import React, { useState } from 'react';
import { GiHamburgerMenu } from "react-icons/gi";
import { MdClose } from "react-icons/md";
import { useDispatch, useSelector } from "react-redux";
import { setSearch } from "../redux/slices/SearchSlice";
import NavList from './NavList';

const Navbar = () => {
    const dispatch = useDispatch();
    const [ toggleNav , setToggleNav ] = useState(false);
    const auth = useSelector((state) => state.auth.user);
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
