import { configureStore } from "@reduxjs/toolkit";
import AuthSlice from "./slices/AuthSlice";
import SearchSlice from "./slices/SearchSlice";
import cartSlice from "./slices/cartSlice";
import categorySlice from "./slices/categorySlice";
const Store = configureStore({
    reducer:{
        cart:cartSlice,
        category: categorySlice,
        search: SearchSlice,
        auth: AuthSlice,
    },
});

export default Store;