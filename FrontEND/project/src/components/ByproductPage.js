import React, { useState } from 'react';

const ByProductPage = () => {
  const [productType, setProductType] = useState('');
  const [medicines, setMedicines] = useState([]);

  const handleSearch = () => {
    // Perform search logic based on productType
    // For demonstration purposes, let's assume you have an API endpoint for searching medicines by product type
    fetch(`your-api-url/product/${productType}`)
      .then(response => response.json())
      .then(data => setMedicines(data))
      .catch(error => console.error('Error fetching data:', error));
  };

  return (
    <div>
      <button type="submit" id="search" >SEARCH</button>
      <input type="search" placeholder="Search the product by medicine type"/>
      <div>
        <select value={productType} onChange={e => setProductType(e.target.value)}>
          <option value="">Select Product Type</option>
          <option value="antiseptics">Antiseptics</option>
          <option value="antibiotics">Antibiotics</option>
          <option value="antipyretics">Antipyretics</option>
          <option value="antacids">Antacids</option>
          <option value="antihistamines">Antihistamines</option>
          <option value="anti-inflammatory">Anti-inflammatory</option>
          <option value="emergency">Emergency</option>
        </select>
        <button onClick={handleSearch}>Search</button>
      </div>
      <div>
        <h3>Search Results:</h3>
        <table>
          <thead>
            <tr>
              <th>Category ID</th>
              <th>Category Name</th>
              <th>Medicine ID</th>
              <th>Medicine Name</th>
              <th>Unit Price</th>
              <th>Quantity</th>
            </tr>
          </thead>
          <tbody>
            {medicines.map(medicine => (
              <tr key={medicine.id}>
                <td>{medicine.categoryId}</td>
                <td>{medicine.categoryName}</td>
                <td>{medicine.medicineId}</td>
                <td>{medicine.medicineName}</td>
                <td>{medicine.unitPrice}</td>
                <td>{medicine.quantity}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default ByProductPage;