import React, { useEffect, useState } from 'react';
import { useDispatch, useSelector } from "react-redux";
import { MedicineData } from '../Data/MedicineData';
import { setCategory } from '../redux/slices/categorySlice';

const Category = () => {
    const [categories , setCategories ] = useState([]);
    const listUniqueCategories = () => {
        const uniqueCategories = [
             ...new Set(MedicineData.map((medicine)=>medicine.category)),
        ];
        setCategories(uniqueCategories);
        console.log(uniqueCategories);
    };
    useEffect(()=>{
        listUniqueCategories();
    },[]);

    const dispatch = useDispatch();
    const selectedCategory = useSelector((state)=>state.category.category);

    return (
        <div className="ml-6">
            <h3 className="text-xl font-semibold">
                Find Medicine By Category</h3>
            <div className="my-5 flex gap-3 overflow-x-scroll scroll-smooth lg:overflow-x-hidden">
            <button
                            onClick={()=> dispatch(setCategory("All"))}
                             className={`px-3 py-2 bg-gray-200 font-bold rounded-lg hover:bg-green-500 hover:text-white ${ selectedCategory==="All" && "bg-green-500 text-white"}`}>
                                 All
                            </button>
                {
                    categories.map((category,index)=>{
                        return (
                            <button
                            onClick={()=> dispatch(setCategory(category))}
                            key={index} className={`px-3 py-2 bg-gray-200 font-bold rounded-lg hover:bg-green-500 hover:text-white ${ selectedCategory===category && "bg-green-500 text-white"}`}>
                                  {category}
                            </button>
                        );
                    })
                }
            </div>
        </div>
    )
}

export default Category

// Painkillers
// Antibiotics
// Antipyretics
// Antacids
// Antihistamines
// Anti-inflammatory
// Emergency_Condition