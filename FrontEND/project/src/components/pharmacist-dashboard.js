import React from 'react';
import { Link } from 'react-router-dom';


const PharmacistDashboard = () => {
  return (
    <div>
      <h2>Pharmacist Dashboard</h2>
      <div>
      <Link to="/bydistributor">
      <button>
            <img src="distributor_icon.png" alt="By Distributor" />
          By Distributor
     </button>
     </Link>
        <Link to="/byproduct"><button>
        <img src="distributor_icon.png" alt="By Product" />
          By Product</button></Link>
        <Link to="/orderRequest"><button>Orders</button></Link>
        <Link to="/cart"><button>cart</button></Link>
        <Link to="/Bill"><button>Bill</button></Link>
        <Link to="/DraftOrderPage"><button>Draft</button></Link>
    
      </div>
    </div>
  );
};

export default PharmacistDashboard;
//design for the button and add pictures