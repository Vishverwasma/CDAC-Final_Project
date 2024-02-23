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

  const handleCartClick = () => {
    console.log('Cart clicked!');
  };

  return (
    <header className="header">
      <div className="logo-container">
        <Link to="/" className="logo-link">
          <img src={logo} alt="Company Logo" className="logo" />
          <h1 className="company-name">medico</h1>
        </Link>
      </div>
      <nav className="navigation">
        <ul className="nav-list">
          <li><Link to="/" className="nav-link">Home</Link></li>
          <li><Link to="#" className="nav-link">Medicine</Link></li>
          <li><Link to="#" className="nav-link">Contact</Link></li>
          <li><Link to="#" className="nav-link">About Us</Link></li>
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
                  <li onClick={() => handleCategoryChange('Antiseptic')}>Antiseptic</li>
                  <li onClick={() => handleCategoryChange('Antipyretics')}>Antipyretics</li>
                  <li onClick={() => handleCategoryChange('Antacids')}>Antacids</li>
                  <li onClick={() => handleCategoryChange('Antihistamines')}>Antihistamines</li>
                  <li onClick={() => handleCategoryChange('Anti-inflammatory')}>Anti-inflammatory</li>
                  <li onClick={() => handleCategoryChange('Emergency')}>Emergency</li>
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
          className="search-input"
        />
        <button className="search-button" onClick={handleSearch}>
          Search
        </button>
      </div>

      <div className="user-actions">
        <div className="user-signin-signup">
          <Link to="/signin" className="user-link">Sign in</Link> / <Link to="/signup" className="user-link">Sign up</Link>
          <div className="cart-option" onClick={handleCartClick}>
            <span role="img" aria-label="Cart" className="cart-icon">🛒</span>
            <Link to="#" className="cart-link">Cart</Link>
          </div>
        </div>
      </div>
    </header>
  );
};

export default Header;
