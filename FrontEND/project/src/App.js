// App.js
import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Header from './components/header';


import SignIn from './components/SignIn';
import SignUp from './components/SignUp';
import SignUpD from './components/SignUpD';


import ByDistributorPage from './components/BydistributorPage';
import PharmacistDashboard from './components/pharmacist-dashboard';
import Distributor from './Distributor-dashboard';
import Product from './components/ByproductPage';
import Orders from './components/OrderRequest';
import DraftOrder from './components/DraftOrder';
import Cart from './components/cart';
import PharmacistDashboardR from './components/OrderRequest';
import OrderPage from './components/OrderResponse';

  

import BouncedOrdersPage from './components/BouncedOrderPage';
 import ByProductPage from './components/ByproductPage';
 
 
 
 import DistributorDashboard from './Distributor-dashboard';

import './App.css';

function App() {
  return (
    <Router>
      <div className="app">
        <Header />
        <Routes>
          <switch>
          <Route path="/signin" component={SignIn} />
          <Route path="/signup-distributor" component={SignUpD} />
          <Route path="/signup-pharmacist" component={SignUp} />
          </switch>
          <Route path="/signup" element={<SignUp />} />
        </Routes>
      </div>
    
      
      <Routes>
        <Route path="/pharmacist-dashboard" component={PharmacistDashboard} />
        <Route path="/distributor" component={Distributor} />
        <Route path="/product" component={Product} />
        <Route path="/orders" component={Orders} />
        <Route path="/DraftOrder" component={DraftOrder} />
        <Route path="/cart" component={Cart} />
        <Route path="/ByDistributorPage" component={ByDistributorPage} />

        <Route path="/ByProductPage" component={ByProductPage} />
        <Route path="/BouncedOrdersPage" component={BouncedOrdersPage} />
        
        <Route path="/DistributorDashboard" component={DistributorDashboard} />
        <Route path="/PharmacistDashboardR" component={PharmacistDashboardR} />
        <Route path="/OrdersPage" component={OrderPage} />


        


        

        


        
        </Routes>
        </Router>
  );

}
/* <Switch>
        <Route exact path="/" component={PharmacistDashboard} />
        <Route path="/bydistributor" component={ByDistributorPage} />
        
      </Switch>
*/

export default App;
