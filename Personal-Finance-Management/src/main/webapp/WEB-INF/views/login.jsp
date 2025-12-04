<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Finance Manager — Login</title>

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
        font-family: 'Inter', sans-serif;
        backdrop-filter: blur(5px);
    }

    .brand-title {
        text-align: center;
        font-size: 30px;
        font-weight: 700;
        margin-bottom: 15px;
        color: var(--primary);
        letter-spacing: 1px;
    }

    .login-card {
        width: 380px;
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

    .btn-login {
        width: 100%;
        background: var(--primary);
        border-radius: 12px;
        padding: 12px;
        font-size: 17px;
        font-weight: 600;
        border: none;
        color: white;
        transition: 0.25s ease;
    }

    .btn-login:hover {
        background: var(--primary-light);
        transform: translateY(-3px);
        box-shadow: 0 8px 20px rgba(10, 120, 102, 0.35);
    }

    .footer-link {
        margin-top: 15px;
        text-align: center;
        display: block;
        font-size: 15px;
        text-decoration: none;
        font-weight: 500;
        color: var(--primary);
        transition: 0.25s;
    }

    .footer-link:hover {
        text-decoration: underline;
        color: var(--primary-light);
    }
</style>
</head>

<body>

    <div class="login-card">
        
        <div class="brand-title">Finance Manager</div>
        <p class="text-center text-muted mb-4">Secure login to continue</p>
        <p style="color: green">${msg}</p>

        <form method="post" action="/do-login">
            <div class="mb-3">
                <label class="form-label fw-semibold">Email Address</label>
                <input type="email" name="username" class="form-control" placeholder="example@email.com">
            </div>

            <div class="mb-1">
                <label class="form-label fw-semibold">Password</label>
                <input type="password" name="password" class="form-control" placeholder="Enter password">
            </div>

            <button type="submit" class="btn-login mt-3">Sign In</button>
        </form>

        <a href="/register" class="footer-link">New user? Create an account</a>

        
		<a href="/forgotPwd" class="footer-link" style="margin-top: 5px;">
		    Forgot Password?
		</a>

    </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>