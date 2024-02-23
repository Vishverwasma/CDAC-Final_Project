import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';

const Cart = () => {
  const [cartDetails, setCartDetails] = useState(null);

  // Fetch cart details from the server
  useEffect(() => {
    const fetchCartDetails = async () => {
      try {
        const response = await fetch('/api/cart'); // Assuming an endpoint to fetch cart details
        const data = await response.json();
        setCartDetails(data);
      } catch (error) {
        console.error('Error fetching cart details:', error);
        // Handle errors (e.g., show error message)
      }
    };

    fetchCartDetails();
  }, []);

  const handleAcceptOrder = async (orderId) => {
    try {
      const response = await fetch(`/api/orders/${orderId}/accept`, {
        method: 'PUT',
      });
      if (response.ok) {
        console.log('Order accepted successfully.');
        // Refresh cart details or perform any other necessary actions
      } else {
        console.error('Error accepting order.');
        // Handle error (e.g., show error message)
      }
    } catch (error) {
      console.error('Error accepting order:', error);
      // Handle errors (e.g., show error message)
    }
  };

  const handlePrintBill = async (orderId) => {
    try {
      // Logic to print bill (could be a separate API endpoint)
      console.log('Bill printed successfully for order:', orderId);
      // Perform any necessary actions after printing the bill
    } catch (error) {
      console.error('Error printing bill:', error);
      // Handle errors (e.g., show error message)
    }
  };

  return (
    <div>
      <h2>Cart</h2>
      {cartDetails ? (
        <div>
          <p>Cart ID: {cartDetails.cartId}</p>
          <p>Pharmacist ID: {cartDetails.pharmacistId}</p>
          <ul>
            {cartDetails.items.map(item => (
              <li key={item.medicineId}>
                Medicine ID: {item.medicineId}, Quantity: {item.quantity}, Price: {item.price}
                <button onClick={() => handleAcceptOrder(item.orderId)}>Accept Order</button>
                <button onClick={() => handlePrintBill(item.orderId)}>Print Bill</button>
              </li>
            ))}
          </ul>
        </div>
      ) : (
        <p>Loading cart details...</p>
      )}
    </div>
  );
};

export default Cart;
