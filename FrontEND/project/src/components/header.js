
import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import logo from '../images/logo.jpg';
import './header.css';

const Header = () => {
  const [selectedCategory, setSelectedCategory] = useState('');
  const [showDropdown, setShowDropdown] = useState(false);

  const handleCategoryChange = (category) => {
    setSelectedCategory(category);
    setShowDropdown(false);
  };

  const toggleDropdown = () => {
    setShowDropdown(!showDropdown);
  };

  const handleSearch = () => {
    console.log(`Searching for ${selectedCategory || 'medicine'}`);
  };
// Function to handle cart click
const handleCartClick = () => {
  // Implement your cart logic here
  console.log('Cart clicked!');
  // Optionally, redirect to the cart page using Link
  // Example: <Link to="/cart">Go to Cart</Link>
};
  return (
    <header>
      <div className="logo-container">
        <Link to="/">
          <img src={logo} alt="Company Logo" className="logo" />
        </Link>
        <h1 className="company-name">medico</h1>
      </div>
      <nav className="navigation">
        <ul>
          <li><Link to="/">Home</Link></li> {/* Update the Link component */}
          <li><Link to="#">Medicine</Link></li>
          <li><Link to="#">Contact</Link></li>
          <li><Link to="#">About Us</Link></li>
        </ul>
      </nav>

      <div className="search-bar">
        <div className="categories-dropdown">
          <div className="categories-button" onClick={toggleDropdown}>
            Categories
            {showDropdown && (
              <div className="dropdown-content">
                <ul>
                  <li onClick={() => handleCategoryChange('Painkiller')}>Painkiller</li>
                  <li onClick={() => handleCategoryChange('Antibiotics')}>Antiseptic</li>
                  <li onClick={() => handleCategoryChange('Antipyretics')}>Antipyretics</li>
                  <li onClick={() => handleCategoryChange('Antacids')}>Antacids</li>
                  <li onClick={() => handleCategoryChange('Antihistamines')}>Antihistamines</li>
                  <li onClick={() => handleCategoryChange('Anti-inflammatory')}>Anti-inflammatory</li>
                  <li onClick={() => handleCategoryChange('Emergency_Condition')}>Emergency_Condition</li>
                </ul>
              </div>
            )}
          </div>
        </div>
        <span>|</span>
        <input
          type="text"
          placeholder={`Search for ${selectedCategory || 'medicine'}`}
          readOnly
        />
        <button className="search-button" onClick={handleSearch}>
          Search
        </button>
      </div>

      <div className="user-actions">
        <div className="user-signin-signup">
          <Link to="/signin">Sign in</Link> / <Link to="/signup">Sign up</Link>
          <div className="cart-option" onClick={handleCartClick}>
          {/* Add your cart icon or content here */}
          <span role="img" aria-label="Cart">🛒</span> 
          <Link to="#">cart</Link>
          
        </div>

        </div>
      </div>
    </header>
  );
};

export default Header;
