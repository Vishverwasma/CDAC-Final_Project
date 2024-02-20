

// SignIn.js
import React, { useState } from 'react';
import './SignIn.css'; 
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
          <div className="forgot-password">
            <a href="#">Forgot Password?</a>
          </div>
        </div>
      </div>
    </div>
  );
};

export default SignIn;
