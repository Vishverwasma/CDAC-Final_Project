import axios from "axios";

export const BASE_URL='http://localhost:2215';

export const myAxios = axios.create({
    baseurl:BASE_URL,
});
export const getCart = async(user)=>{
    const res = await axios.get(`${BASE_URL}/cart/get`,{
        params: {
            userId: user._id
        }
    });
    const data = await res.data;
    return data;
}