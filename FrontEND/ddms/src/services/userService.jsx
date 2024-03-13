import { myAxios } from './helper'

const signUp=(user)=>{
    return myAxios.post('/pharmacist/signup').then((response)=>response.json())
}