<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Login Page</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background: #e9f5f2;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }
    .login-container {
      background: #fff;
      padding: 25px 30px;
      border-radius: 10px;
      box-shadow: 0 4px 8px rgba(0,0,0,0.2);
      width: 320px;
    }
    .login-container h2 {
      text-align: center;
      margin-bottom: 20px;
      color: #333;
    }
    label {
      display: block;
      margin-bottom: 6px;
      font-weight: bold;
      color: #555;
    }
    input {
      width: 100%;
      padding: 10px;
      margin-bottom: 15px;
      border: 1px solid #ccc;
      border-radius: 6px;
      outline: none;
      font-size: 14px;
    }
    input:focus {
      border-color: #2196F3;
    }
    button {
      width: 100%;
      padding: 12px;
      background: #2196F3;
      border: none;
      border-radius: 6px;
      color: white;
      font-size: 16px;
      cursor: pointer;
    }
    button:hover {
      background: #1976d2;
    }
    .extra-links {
      text-align: center;
      margin-top: 10px;
    }
    .extra-links a {
      text-decoration: none;
      color: #2196F3;
      font-size: 14px;
    }
    .extra-links a:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>
  <div class="login-container">
    <h2>Login</h2>
    <h4 style="color: green">${succmsg}</h4>
    <h4 style="color: red">${errmsg}</h4>
    <form action="login" method="post">
      <label for="email">Email</label>
      <input type="email" id="email" name="email" placeholder="Enter your email" required>

      <label for="password">Password</label>
      <input type="password" id="password" name="password" placeholder="Enter password" required>

      <button type="submit">Login</button>

      <div class="extra-links">
        <a href="#">Forgot Password?</a> | <a href="register.jsp">Register</a>
      </div>
    </form>
  </div>
</body>
</html>
    