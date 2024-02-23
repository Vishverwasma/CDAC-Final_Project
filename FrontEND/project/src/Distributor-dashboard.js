import React from 'react';
import { Link } from 'react-router-dom';

const DistributorDashboard = () => {
  return (
    <div>
      <h2>Distributor Dashboard</h2>
      <div>
        <Link to="/order-requests">
          <button>Order Requests</button>
        </Link>
        <Link to="/order-history">
          <button>Order History</button>
        </Link>
        <Link to="/canceled-orders">
          <button>Canceled Orders</button>
        </Link>
        <Link to="/invoices">
          <button>Invoices</button>
        </Link>
        <Link to="/">
          <button>Back</button>
        </Link>
      </div>
    </div>
  );
};

export default DistributorDashboard;
