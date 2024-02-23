import React, { useState } from 'react';
import { Link } from 'react-router-dom';

const PharmacistDashboardR = () => {
  const [medicineName, setMedicineName] = useState('');
  const [quantity, setQuantity] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      // Send order request to the server (distributor)
      const response = await fetch('/api/order-request', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ medicineName, quantity }),
      });
      const data = await response.json();
      console.log('Order request response:', data);
      // You can handle the response here (e.g., show success message)
    } catch (error) {
      console.error('Error submitting order request:', error);
      // Handle errors (e.g., show error message)
    }
  };

  return (
    <div>
      <h2>Pharmacist Dashboard</h2>
      <div>
        <form onSubmit={handleSubmit}>
          <div>
            <label htmlFor="medicineName">Medicine Name:</label>
            <input
              type="text"
              id="medicineName"
              value={medicineName}
              onChange={(e) => setMedicineName(e.target.value)}
            />
          </div>
          <div>
            <label htmlFor="quantity">Quantity:</label>
            <input
              type="number"
              id="quantity"
              value={quantity}
              onChange={(e) => setQuantity(e.target.value)}
            />
          </div>
          <button type="submit">Submit Order Request</button>
        </form>
      </div>
      <div>
        <Link to="/cart">Go To Cart</Link>
      </div>
    </div>
  );
};

export default PharmacistDashboardR;
