import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import './SignUp.css';

const SignUp = () => {
  const [distributorId, setDistributorId] = useState('');
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');

  const handleSignUp = () => {
    if (
      name.trim() === '' ||
      email.trim() === '' ||
      password.length < 8
    ) {
      setError(
        'Invalid input. Ensure name and email are provided and password is at least 8 characters long.'
      );
    } else {
      setError('');
      console.log('Signing up...', {
        distributorId,
        name,
        email,
        password,
      });
    }
  };

  return (
    <div className="signup-container">
      <div className="sign-box">
        <h2>Distributor Sign Up</h2>

        <div className="input-group">
          <label htmlFor="distributorId">Distributor ID:</label>
          <input
            type="text"
            id="distributorId"
            value={distributorId}
            onChange={(e) => setDistributorId(e.target.value)}
          />
        </div>

        <div className="input-group">
          <label htmlFor="name">Name:</label>
          <input
            type="text"
            id="name"
            value={name}
            onChange={(e) => setName(e.target.value)}
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
          <label htmlFor="password">Password:</label>
          <input
            type="password"
            id="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
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