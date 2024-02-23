// SignUp.js
import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import './SignUp.css'; // Import your CSS file for styling

const SignUp = () => {
  const [pharmacistName, setPharmacistName] = useState('');
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [email, setEmail] = useState('');
  const [address, setAddress] = useState('');
  const [licenseNumber, setLicenseNumber] = useState('');
  const [error, setError] = useState('');

  const handleSignUp = () => {
    if (
      username.length >= 16 ||
      password.length >= 16 ||
      !/[!@#$%^&*(),.?":{}|<>0-9]/.test(password)
    ) {
      setError(
        'Invalid username or password. Ensure username is 16 characters and password is 16 characters with at least one symbol.'
      );
    } else {
      setError('');
      console.log('Signing up...', {
        username,
        password,
        email,
        address,
        licenseNumber,
        pharmacistName,
      });
    }
  };

  return (
    <div className="signup-container">
      <div className="sign-box">
        <h2>Sign Up</h2>

        <div className="input-group">
          <label htmlFor="username">Username:</label>
          <input
            type="text"
            id="username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
          />
        </div>

        <div className="input-group">
          <label htmlFor="password">Password:</label>
          <input
            type="password"
            id="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
        </div>

        <div className="input-group">
          <label htmlFor="email">Email:</label>
          <input
            type="email"
            id="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
        </div>

        <div className="input-group">
          <label htmlFor="address">Address:</label>
          <input
            type="text"
            id="address"
            value={address}
            onChange={(e) => setAddress(e.target.value)}
          />
        </div>

        <div className="input-group">
          <label htmlFor="licenseNumber">License Number:</label>
          <input
            type="text"
            id="licenseNumber"
            value={licenseNumber}
            onChange={(e) => setLicenseNumber(e.target.value)}
          />
        </div>

        <div className="input-group">
          <label htmlFor="pharmacistName">Pharmacist Name:</label>
          <input
            type="text"
            id="pharmacistName"
            value={pharmacistName}
            onChange={(e) => setPharmacistName(e.target.value)}
          />
        </div>

        {error && <div className="error-message">{error}</div>}

        <div className="button-group">
          <button onClick={handleSignUp}>Submit</button>
          <Link to="/">
            <button>Back</button>
          </Link>
        </div>
      </div>
    </div>
  );
};

export default SignUp;