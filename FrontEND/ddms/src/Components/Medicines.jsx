import React from 'react';
import toast, { Toaster } from 'react-hot-toast';
import { MedicineData } from '../Data/MedicineData.js';
import MedsCard from './MedsCard';


const Medicines = () => {
    const handleToast = (name) => toast.success(`${name} added to Cart`);
    return (
        <>
        <Toaster position="top-center" reverseOrder={false}/>
        <div className="flex flex-wrap gap-10 justify-center lg:justify-start mx-2 my-8">
            {
                MedicineData.map((medicine)=>{
                    return (
                    <MedsCard key={medicine.id} 
                    id={medicine.id}
                    name={medicine.name}
                    price={medicine.price}
                    desc={medicine.desc}
                    rating={medicine.rating}
                    img={medicine.img}
                    handleToast={handleToast}
                    />
);
                })
            }
        </div>
        </>
    )
}

export default Medicines
