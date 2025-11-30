<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- <%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<%
    if (request.getUserPrincipal() != null) {
        response.sendRedirect("/dashboard");
        return;
    }
%> --%>

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

    /* VALIDATION COLORS */
    .valid-input {
        border: 2px solid #28a745 !important;
    }

    .invalid-input {
        border: 2px solid #dc3545 !important;
    }

    /* BUTTONS */
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

    /* Show/Hide Icon */
    .password-toggle {
        position: absolute;
        right: 12px;
        top: 38px;
        cursor: pointer;
        user-select: none;
        font-size: 18px;
    }

</style>
</head>

<body>

<div class="login-card">
    
    <div class="brand-title">Finance Manager</div>
    <p class="text-center text-muted mb-4">Secure login to continue</p>
	<p style="color: green">${msg}</p>

    <form method="post" action="/do-login" onsubmit="return validateForm()">

        <!-- EMAIL -->
        <div class="mb-3">
            <label class="form-label fw-semibold">Email Address</label>
            <input type="text" id="email" name="username" class="form-control" placeholder="example@email.com">
            <small id="emailError" class="text-danger"></small>
        </div>

        <!-- PASSWORD -->
        <div class="mb-3 position-relative">
            <label class="form-label fw-semibold">Password</label>
            <input type="password" id="password" name="password" class="form-control" placeholder="Enter password">

            <span class="password-toggle" onclick="togglePassword()">👁️</span>

            <small id="passwordError" class="text-danger"></small>
        </div>

        <button type="submit" class="btn-login mt-3">Sign In</button>
    </form>

    <a href="/register" class="footer-link">New user? Create an account</a>
</div>

<script>

    // ------------ Show / Hide Password ------------
    function togglePassword() {
        const field = document.getElementById("password");
        field.type = field.type === "password" ? "text" : "password";
    }

    // ------------ Live Validation Events ------------
    document.getElementById("email").addEventListener("input", validateEmail);
    document.getElementById("password").addEventListener("input", validatePassword);

    // ------------ Email Validation ------------
    function validateEmail() {
        const email = document.getElementById("email");
        const error = document.getElementById("emailError");

        const regex = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.com$/;

        if (!regex.test(email.value.trim())) {
            error.textContent = "Enter a valid email (must contain @ and .com)";
            setInvalid(email);
            return false;
        }

        error.textContent = "";
        setValid(email);
        return true;
    }

    // ------------ Password Validation ------------
    function validatePassword() {
        const pass = document.getElementById("password");
        const error = document.getElementById("passwordError");

        if (pass.value.length < 4) {
            error.textContent = "Password must be at least 4 characters.";
            setInvalid(pass);
            return false;
        }

        error.textContent = "";
        setValid(pass);
        return true;
    }

    // ------------ Helpers ------------
    function setValid(element) {
        element.classList.remove("invalid-input");
        element.classList.add("valid-input");
    }

    function setInvalid(element) {
        element.classList.remove("valid-input");
        element.classList.add("invalid-input");
    }

    // ------------ Submit Validation ------------
    function validateForm() {
        return validateEmail() && validatePassword();
    }

</script>

</body>
</html>
