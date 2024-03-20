import { createSlice } from "@reduxjs/toolkit";

const authSlice = createSlice({
    name:'auth',
initialState:{
    isAuth: false,
    user: null,
},
reducers:{
    loginUser : (state,action)=>{
        state.isAuth=true;
        state.user = action.payload;
    },
    logoutUser:(state,action)=>{
        state.user = null;
        state.auth = false;
    },
    setUser:(state,action)=>{
        state.user = action.payload;
        state.isAuth=true;
    }
}
})
export const { loginUser , logoutUser , setUser} = authSlice.actions;
export default authSlice.reducer;