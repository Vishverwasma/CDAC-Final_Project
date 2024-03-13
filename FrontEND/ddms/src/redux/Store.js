import { configureStore } from "@reduxjs/toolkit";
import cartSlice from "./slices/cartSlice";
import categorySlice from "./slices/categorySlice";
const Store = configureStore({
    reducer:{
        cart:cartSlice,
        category: categorySlice,
    },
});

export default Store;