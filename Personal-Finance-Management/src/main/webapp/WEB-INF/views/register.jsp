<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Finance Manager - Register</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

    :root {
        --primary: #0A7866;
        --primary-light: #15a089;
        --background: #E8EFF1;
        --glass: rgba(255,255,255,0.2);
        --text-dark: #1f1f1f;
    }

    body {
        background: linear-gradient(135deg, #b7e1d8, #d9f1ec);
        height: 100vh;
        display: flex;
        align-items: center;
        justify-content: center;
        font-family: Arial, sans-serif;
        margin: 0;
    }

    .register-card {
        width: 420px;
        background: rgba(255,255,255,0.75);
        padding: 40px;
        border-radius: 18px;
        box-shadow: 0 15px 40px rgba(0,0,0,0.15);
        backdrop-filter: blur(15px);
        animation: fadeIn 0.6s ease;
    }

    @keyframes fadeIn {
        from { opacity: 0; transform: translateY(15px); }
        to { opacity: 1; transform: translateY(0); }
    }

    .title {
        text-align: center;
        font-size: 28px;
        font-weight: bold;
        margin-bottom: 10px;
        color: var(--primary);
        letter-spacing: 1px;
    }

    .sub-text {
        text-align: center;
        color: #555;
        font-size: 14px;
        margin-bottom: 25px;
    }

    .form-control {
        padding: 12px;
        border-radius: 10px;
        border: 1.4px solid #ccc;
        transition: 0.3s;
    }

    .form-control:focus {
        border-color: var(--primary);
        box-shadow: 0 0 0 3px rgba(9, 121, 104, 0.15);
    }

    .btn-register {
        width: 100%;
        background: var(--primary);
        border-radius: 12px;
        padding: 12px;
        font-size: 17px;
        border: none;
        font-weight: bold;
        color: white;
        transition: 0.25s;
    }

    .btn-register:hover {
        background: var(--primary-light);
        transform: translateY(-3px);
        box-shadow: 0 8px 20px rgba(10, 120, 102, 0.35);
    }

    .footer-link {
        text-align: center;
        display: block;
        margin-top: 15px;
        font-size: 15px;
        color: var(--primary);
        text-decoration: none;
        font-weight: 500;
    }

    .footer-link:hover {
        text-decoration: underline;
        color: var(--primary-light);
    }

</style>
</head>

<body>

<div class="register-card">
    
    <div class="title">Create Account</div>
    <p class="sub-text">Join and manage your finances smartly</p>

    <form method="post">
        <div class="mb-3">
            <label class="form-label">Full Name</label>
            <input type="text" class="form-control" placeholder="Enter your full name">
        </div>

        <div class="mb-3">
            <label class="form-label">Email Address</label>
            <input type="email" class="form-control" placeholder="Enter your email">
        </div>

        <div class="mb-3">
            <label class="form-label">Create Password</label>
            <input type="password" class="form-control" placeholder="Create a password">
        </div>

        <small class="text-muted d-block mb-3">
            Password must be 8-20 characters, include numbers, and avoid spaces or special symbols.
        </small>

        <button class="btn-register">Register</button>
    </form>

    <a href="#" class="footer-link">Already registered? Sign In</a>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
