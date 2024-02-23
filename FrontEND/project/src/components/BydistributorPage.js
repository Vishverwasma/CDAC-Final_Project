import React, { useState, useEffect } from 'react';

const ByDistributorPage = () => {
  const [medicines, setMedicines] = useState([]);

  useEffect(() => {
    // Fetch data from your API endpoint
    fetch('your-api-url')
      .then(response => response.json())
      .then(data => setMedicines(data))
      .catch(error => console.error('Error fetching data:', error));
  }, []);

  return (
    <div>
      <h2>Search Medicines By Distributor</h2>
      <table>
        <thead>
          <tr>
            <th>Distributor ID</th>
            <th>Medicine ID</th>
            <th>Medicine Name</th>
            <th>Availability</th>
          </tr>
        </thead>
        <tbody>
          {medicines.map(medicine => (
            <tr key={medicine.id}>
              <td>{medicine.distributorId}</td>
              <td>{medicine.medicineId}</td>
              <td>{medicine.medicineName}</td>
              <td>{medicine.availability}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ByDistributorPage;
