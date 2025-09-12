<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width,initial-scale=1" />
  <title>Contact Form</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f3f4f6;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      margin: 0;
    }
    .form-container {
      background: #fff;
      padding: 24px;
      border-radius: 10px;
      box-shadow: 0 4px 10px rgba(0,0,0,0.1);
      width: 100%;
      max-width: 400px;
    }
    h2 {
      margin-top: 0;
      margin-bottom: 20px;
      font-size: 1.2rem;
      text-align: center;
    }
    label {
      display: block;
      margin-bottom: 6px;
      font-weight: bold;
      font-size: 0.9rem;
    }
    input, textarea {
      width: 100%;
      padding: 10px;
      margin-bottom: 16px;
      border: 1px solid #ccc;
      border-radius: 6px;
      font-size: 0.9rem;
    }
    input:focus, textarea:focus {
      border-color: #2563eb;
      outline: none;
    }
    button {
      width: 100%;
      padding: 10px;
      background: #2563eb;
      color: #fff;
      border: none;
      border-radius: 6px;
      font-size: 1rem;
      font-weight: bold;
      cursor: pointer;
    }
    button:hover {
      background: #1e4ed8;
    }
  </style>
</head>
<body>
  <div class="form-container">
    <h2>Contact Form</h2>
    <form action="read">
      <label for="name">Name</label>
      <input type="text" id="name" name="name" placeholder="Your full name" required>

      <label for="email">Email</label>
      <input type="email" id="email" name="email" placeholder="you@example.com" required>

      <label for="address">Address</label>
      <textarea id="address" name="address" rows="4" placeholder="Street, city, postal code" required></textarea>

	  <label for="password">Password</label>
      <input type="password" id="pwd" name="password" placeholder="Enter pwd" required>

      <button type="submit">Submit</button>
    </form>
  </div>
</body>
</html>
