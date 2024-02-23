import React, { useState } from 'react';

const DraftOrder = () => {
  // Hardcoded data for draft orders
  const draftOrders = [
    { orderId: 1, date: '2024-02-20', medicines: [{ medicineId: 101, medicineName: 'Medicine A', quantity: 5 }] },
    { orderId: 2, date: '2024-02-21', medicines: [{ medicineId: 102, medicineName: 'Medicine B', quantity: 10 }] },
    { orderId: 3, date: '2024-02-22', medicines: [{ medicineId: 103, medicineName: 'Medicine C', quantity: 8 }] },
    // Add more draft orders as needed
  ];

  // State to store the selected draft order
  const [selectedOrder, setSelectedOrder] = useState(null);

  // Function to handle click on a draft order
  const handleOrderClick = (order) => {
    setSelectedOrder(order);
  };

  // Function to close the modal or expandable section
  const handleCloseModal = () => {
    setSelectedOrder(null);
  };

  return (
    <div>
      <h2>Draft Orders</h2>
      <div>
        {draftOrders.map(order => (
          <div key={order.orderId} className="draft-order" onClick={() => handleOrderClick(order)}>
            <div className="order-number">Draft #{order.orderId}</div>
            <div className="order-date">{order.date}</div>
          </div>
        ))}
      </div>

      {/* Modal or expandable section */}
      {selectedOrder && (
        <div className="modal">
          <div className="modal-content">
            <span className="close" onClick={handleCloseModal}>&times;</span>
            <h3>Order ID: {selectedOrder.orderId}</h3>
            <h4>Medicines:</h4>
            <ul>
              {selectedOrder.medicines.map(medicine => (
                <li key={medicine.medicineId}>
                  Medicine ID: {medicine.medicineId}, Medicine Name: {medicine.medicineName}, Quantity: {medicine.quantity}
                </li>
              ))}
            </ul>
          </div>
        </div>
      )}
    </div>
  );
};

export default DraftOrder;
