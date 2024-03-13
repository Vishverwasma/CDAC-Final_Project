import axios from 'axios';
import React, { useEffect, useState } from 'react';

const MedsFromTable = () => {
  const [medicineData, setMedicineData] = useState([]);

  useEffect(() => {
    const fetchMedicineData = async () => {
      try {
        const response = await axios.get('http://localhost:2215/medicine/get-all'); // Endpoint to fetch all medicines
        setMedicineData(response.data.content); // Assuming the medicine data is under the 'content' property
      } catch (error) {
        console.error('Error fetching medicine data:', error);
      }
    };

    fetchMedicineData();
  }, []);

  return (
    <div>
      <h2>Medicine List</h2>
      <ul>
        {medicineData.map((medicine) => (
          <li key={medicine.medicineId}>
            <div>{medicine.medicineName}</div>
            <div>Category ID: {medicine.categoryId}</div>
            <div>Quantity: {medicine.medicineQuantity}</div>
            <div>Manufacture Date: {medicine.manufactureDate}</div>
            <div>Unit Price: {medicine.unitPrice}</div>
            <div>Rating: {medicine.rating}</div>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default MedsFromTable;
