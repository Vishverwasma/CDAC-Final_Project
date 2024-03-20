import { createSlice } from '@reduxjs/toolkit';

const cartSlice = createSlice({
    name:"cart",
    initialState:{
        cart:[],
    },
    reducers:{
        addToCart:(state,action)=>{
            const existingItem = state.cart.find((item)=>item.id===action.payload.id);
            //From Here ~>
            // if(existingItem){
            //     state.cart = state.cart.map((item)=>item.id===action.payload.id?{...item,qty:item.qty+1}:item);
            // }else{
            // state.cart.push(action.payload);
            // }
            //Commented above code and Made changes in code on 20/03/2024 at 6:15pm
            if (existingItem !== -1) {
                state.cart[existingItem].qty += action.payload.qty;
            } else {
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
    setCart: (state , action)=>{
        state.cart = action.payload;
    },
},
});

export const { addToCart , removeFromCart , incrementQty , decrementQty , setCart} = cartSlice.actions;
export default cartSlice.reducer;