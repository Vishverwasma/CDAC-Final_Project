import axios from "axios";

export const BASE_URL='http://localhost:2215';

export const myAxios = axios.create({
    baseurl:BASE_URL,
});