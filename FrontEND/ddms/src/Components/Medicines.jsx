import React from 'react';
import toast, { Toaster } from 'react-hot-toast';
import { useDispatch , useSelector } from "react-redux";
import { MedicineData } from '../Data/MedicineData.js';
import MedsCard from './MedsCard';
import { addToCart } from '../redux/slices/cartSlice.jsx'; 

const Medicines = () => {
    const category = useSelector((state)=>state.category.category);
    const search = useSelector((state)=>state.search.search);
    const dispatch = useDispatch();
   
    const handleToast = (name) => toast.success(`${name} added to Cart`);

    const handleAddToCart = (medicine) =>{
        dispatch(addToCart(medicine));
        handleToast(medicine.name);
    };

    return (
        <>
        <Toaster position="top-center" reverseOrder={false}/>
        <div className="flex flex-wrap gap-10 justify-center lg:justify-start mx-2 my-8">
            {MedicineData.filter((medicine)=>{
                if(category==="All"){
                    return medicine.name.toLowerCase().includes(search.toLowerCase());
                }else{
                    return (category===medicine.category && medicine.name.toLowerCase().includes(search.toLowerCase()));
                }
               }).map((medicine)=>(
               <MedsCard 
                key={medicine.id} 
                    id={medicine.id}
                    name={medicine.name}
                    price={medicine.price}
                    desc={medicine.desc}
                    rating={medicine.rating}
                    img={medicine.img}
                    handleToast={handleAddToCart}
                    />
               ))
            }
        </div>
        </>
    )
}

export default Medicines
