import React from 'react'
import Cart from '../Components/Cart'
import Category from '../Components/Category'
import Medicines from '../Components/Medicines'
import Navbar from '../Components/Navbar'
const Home = () => {
    return (
      <>
       <Navbar/>
       <Category />
       <Medicines />
       <Cart />
      </>
    )
}

export default Home
