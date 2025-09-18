<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>E-Commerce Home</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background: #f5f5f5;
    }
    header {
      background: #2c3e50;
      color: white;
      padding: 15px;
      text-align: center;
    }
    nav {
      background: #34495e;
      padding: 10px;
      text-align: center;
    }
    nav a {
      color: white;
      text-decoration: none;
      margin: 0 15px;
      font-weight: bold;
    }
    nav a:hover {
      text-decoration: underline;
    }
    .container {
      padding: 20px;
    }
    .products {
      display: grid;
      grid-template-columns: repeat(auto-fill, minmax(220px, 1fr));
      gap: 20px;
    }
    .product-card {
      background: white;
      border-radius: 8px;
      box-shadow: 0 2px 6px rgba(0,0,0,0.15);
      padding: 15px;
      text-align: center;
      transition: transform 0.2s;
    }
    .product-card:hover {
      transform: scale(1.03);
    }
    .product-card img {
      width: 100%;
      height: 160px;
      object-fit: cover;
      border-radius: 6px;
      margin-bottom: 10px;
    }
    .product-card h3 {
      margin: 10px 0 5px;
      color: #333;
    }
    .product-card p {
      color: #777;
      font-size: 14px;
      margin-bottom: 10px;
    }
    .price {
      font-size: 16px;
      font-weight: bold;
      color: #27ae60;
      margin-bottom: 12px;
    }
    .btn {
      display: inline-block;
      background: #27ae60;
      color: white;
      padding: 8px 15px;
      border-radius: 6px;
      text-decoration: none;
      font-size: 14px;
    }
    .btn:hover {
      background: #219150;
    }
  </style>
</head>
<body>
  <header>
    <h1>MyShop</h1>
    <p>Your one-stop shop for everything!</p>
  </header>

  <nav>
    <a href="#">Home</a>
    <a href="#">Products</a>
    <a href="#">Cart</a>
  </nav>

  <div class="container">
    <h2>Featured Products</h2>
    <div class="products">
      <div class="product-card">
        <img src="https://via.placeholder.com/220x160" alt="Product 1">
        <h3>Wireless Headphones</h3>
        <p>High-quality sound with noise cancellation.</p>
        <div class="price">$59.99</div>
        <a href="#" class="btn">Add to Cart</a>
      </div>
      <div class="product-card">
        <img src="https://via.placeholder.com/220x160" alt="Product 2">
        <h3>Smartwatch</h3>
        <p>Track your fitness and stay connected.</p>
        <div class="price">$129.99</div>
        <a href="#" class="btn">Add to Cart</a>
      </div>
      <div class="product-card">
        <img src="https://via.placeholder.com/220x160" alt="Product 3">
        <h3>Gaming Laptop</h3>
        <p>Powerful performance for gaming and work.</p>
        <div class="price">$999.99</div>
        <a href="#" class="btn">Add to Cart</a>
      </div>
      <div class="product-card">
        <img src="https://via.placeholder.com/220x160" alt="Product 4">
        <h3>Bluetooth Speaker</h3>
        <p>Portable speaker with deep bass sound.</p>
        <div class="price">$39.99</div>
        <a href="#" class="btn">Add to Cart</a>
      </div>
    </div>
  </div>
</body>
</html>
