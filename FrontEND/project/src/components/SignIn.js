import React, { useState } from 'react';
import './SignIn.css'; 
// import { Form } from 'react-router-dom';
import { Link } from 'react-router-dom';
const SignIn = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');

  
  

  const handleSignIn = () => { if (username.length >= 16|| password.length >= 16 || !/[!@#$%^&*(),.?":{}|<>0-9]/.test(password)) {
    setError('Invalid username or password. Ensure username is 16 characters and password is 16 characters with at least one symbol.');
  } else {
    setError('');
    console.log('Signing In...', { username, password });
  }
  };

  return (
    <div className="signin-container">
      <div className="signin-box">
        <h2>Sign In</h2>

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
        {error && <div className="error-message">{error}</div>}

        <div className="button-group">
          <button onClick={handleSignIn}>Submit</button>
          <button onClick={() => window.history.back()}>Back</button>
          <div className="register-options">
            <span>Not registered yet? </span>
            <Link to ="/SignUpD">Register as Distributor</Link>
            <span> or </span>
            <Link to ="/Sign">Register as Pharmacist</Link>
          </div>
          <div className="forgot-password">
            <Link to="#">Forgot Password?</Link>
          </div>
        </div>
      </div>
    </div>
  );
};

export default SignIn;


/*const handleSignIn = () => {
  if (username.length === 0 || password.length === 0) {
    setError('Username and password are required.');
    return;
  }

  // Make API request to authenticate user
  // Assuming the backend endpoint returns user role as 'role' property in the response
  fetch('your-authentication-endpoint', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify({ username, password }),
  })
    .then(response => {
      if (!response.ok) {
        throw new Error('Invalid username or password.');
      }
      return response.json();
    })
    .then(data => {
      // Check user's role and redirect accordingly
      if (data.role === 'distributor') {
        // Redirect to distributor dashboard
        window.location.href = '/distributor-dashboard';
      } else if (data.role === 'pharmacist') {
        // Redirect to pharmacist dashboard
        window.location.href = '/pharmacist-dashboard';
      } else {
        throw new Error('Unknown user role.');
      }
    })
    .catch(error => {
      setError(error.message);
    });
};*/