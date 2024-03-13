import { createSlice } from '@reduxjs/toolkit';

const cartSlice = createSlice({
    name:"cart",
    initialState:{
        cart:[],
    },
    reducers:{
        addToCart:(state,action)=>{
            const existingItem = state.cart.find((item)=>item.id===action.payload.id);
            if(existingItem){
                state.cart = state.cart.map((item)=>
                item.id===action.payload.id?{...item,qty:item.qty+1}:item);
            }else{
            state.cart.push(action.payload);
            }
        },
        removeFromCart: (state,action)=>{
            state.cart = state.cart.filter((medicine)=>medicine.id!==action.payload.id);
        },
        incrementQty : (state ,action)=>{
            state.cart= state.cart.map((item)=>item.id===action.payload.id?
            {...item,qty: item.qty+1}:item);
        },
    decrementQty : (state ,action)=>{
        state.cart= state.cart.map((item)=>item.id===action.payload.id?
        {...item,qty: item.qty-1}:item);
    },
},
});

export const { addToCart , removeFromCart , incrementQty , decrementQty} = cartSlice.actions;
export default cartSlice.reducer;