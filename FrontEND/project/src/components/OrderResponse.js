import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';

const OrderPage = () => {
  const { orderId } = useParams();
  const [order, setOrder] = useState(null);

  // Simulated fetch request to get order details
  useEffect(() => {
    // You need to replace this with actual API call to fetch order details
    const fetchOrderDetails = async () => {
      try {
        // Simulated API call
        const response = await fetch(`/api/orders/${orderId}`);
        const data = await response.json();
        setOrder(data);
      } catch (error) {
        console.error('Error fetching order details:', error);
      }
    };

    fetchOrderDetails();
  }, [orderId]);

  const handleAcceptOrder = () => {
    // Logic to handle accepting the order
    console.log(`Order ${orderId} accepted.`);
  };

  const handleCancelOrder = () => {
    // Logic to handle canceling the order
    console.log(`Order ${orderId} canceled.`);
  };

  return (
    <div>
      <h2>Order Details</h2>
      {order ? (
        <div>
          <p>Order ID: {order.orderId}</p>
          {/* Display other order details here */}
          <div>
            <button onClick={handleAcceptOrder}>Accept Order</button>
            <button onClick={handleCancelOrder}>Cancel Order</button>
          </div>
        </div>
      ) : (
        <p>Loading order details...</p>
      )}
    </div>
  );
};

export default OrderPage;
