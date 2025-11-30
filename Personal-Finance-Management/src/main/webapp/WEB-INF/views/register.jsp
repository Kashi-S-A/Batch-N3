<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Register</title>

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
            margin-bottom: 5px;
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

        /* ----- Validation Styles ----- */
        .valid-input {
            border: 2px solid #28a745 !important;
        }

        .invalid-input {
            border: 2px solid #dc3545 !important;
        }

        .password-meter {
            height: 6px;
            width: 100%;
            background: #ddd;
            border-radius: 5px;
            margin-top: 5px;
        }

        .meter-fill {
            height: 6px;
            width: 0%;
            background: red;
            border-radius: 5px;
            transition: 0.3s;
        }

        .password-toggle {
            position: absolute;
            right: 10px;
            top: 9px;
            cursor: pointer;
        }

    </style>

</head>

<body>

<div class="register-card">

    <h3 class="title">Create Account</h3>
    <p class="sub-text">Join us and manage everything easily</p>

    <form method="post" action="register" onsubmit="return validateForm()">

        <!-- FULL NAME -->
        <div class="mb-3">
            <label class="form-label">Full Name</label>
            <input type="text" id="name" name="name" class="form-control" placeholder="Enter full name">
            <small id="nameError" class="text-danger"></small>
        </div>

        <!-- EMAIL -->
        <div class="mb-3">
            <label class="form-label">Email Address</label>
            <input type="text" id="email" name="email" class="form-control" placeholder="Enter email">
            <small id="emailError" class="text-danger"></small>
        </div>

        <!-- PASSWORD -->
        <div class="mb-3 position-relative">
            <label class="form-label">Password</label>
            <input type="password" id="password" name="password" class="form-control" placeholder="Create password">

            <span class="password-toggle" onclick="togglePassword('password')">👁️</span>

            <div class="password-meter">
                <div id="meterFill" class="meter-fill"></div>
            </div>

            <small id="passwordError" class="text-danger"></small>
        </div>

        <!-- CONFIRM PASSWORD -->
        <div class="mb-3 position-relative">
            <label class="form-label">Confirm Password</label>
            <input type="password" id="confirmPassword" name="confirmPassword" class="form-control" placeholder="Confirm password">

            <span class="password-toggle" onclick="togglePassword('confirmPassword')">👁️</span>

            <small id="confirmError" class="text-danger"></small>
        </div>

        <button type="submit" class="btn-register">Register</button>

    </form>

    <a href="login" class="footer-link">Already have an account? Login</a>

</div>

<script>

    // 🔥 Show/Hide Password
    function togglePassword(fieldId) {
        const field = document.getElementById(fieldId);
        field.type = field.type === "password" ? "text" : "password";
    }

    // 🔥 Real-time Validation
    document.getElementById("name").addEventListener("input", validateName);
    document.getElementById("email").addEventListener("input", validateEmail);
    document.getElementById("password").addEventListener("input", validatePassword);
    document.getElementById("confirmPassword").addEventListener("input", validateConfirmPassword);

    // 🔥 Name Validation
    function validateName() {
        const name = document.getElementById("name");
        const error = document.getElementById("nameError");

        const regex = /^[A-Za-z ]{3,}$/;

        if (!regex.test(name.value.trim())) {
            error.textContent = "Name must be at least 3 letters only.";
            setInvalid(name);
            return false;
        }

        error.textContent = "";
        setValid(name);
        return true;
    }

    // 🔥 Email Validation
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

    // 🔥 Password Strength + Validation
    function validatePassword() {
        const password = document.getElementById("password");
        const error = document.getElementById("passwordError");
        const meter = document.getElementById("meterFill");

        const value = password.value;
        let strength = 0;

        if (value.length >= 4) strength++;
        if (/[!@#$%^&*()_+\-=]/.test(value)) strength++;
        if (/[A-Z]/.test(value)) strength++;
        if (/[0-9]/.test(value)) strength++;

        if (strength === 0) meter.style.width = "0%";
        if (strength === 1) { meter.style.width = "33%"; meter.style.background = "red"; }
        if (strength === 2) { meter.style.width = "66%"; meter.style.background = "orange"; }
        if (strength >= 3) { meter.style.width = "100%"; meter.style.background = "green"; }

        const passRegex = /^(?=.*[!@#$%^&*()_+\-=]).{4,}$/;

        if (!passRegex.test(value)) {
            error.textContent = "Min 4 chars & 1 special character.";
            setInvalid(password);
            validateConfirmPassword();
            return false;
        }

        error.textContent = "";
        setValid(password);
        validateConfirmPassword();
        return true;
    }

    // 🔥 Confirm Password
    function validateConfirmPassword() {
        const pass = document.getElementById("password").value;
        const confirm = document.getElementById("confirmPassword");
        const error = document.getElementById("confirmError");

        if (confirm.value !== pass || confirm.value.length === 0) {
            error.textContent = "Passwords do not match!";
            setInvalid(confirm);
            return false;
        }

        error.textContent = "";
        setValid(confirm);
        return true;
    }

    // 🔥 Helper Methods
    function setValid(element) {
        element.classList.remove("invalid-input");
        element.classList.add("valid-input");
    }

    function setInvalid(element) {
        element.classList.remove("valid-input");
        element.classList.add("invalid-input");
    }

    // 🔥 Final Submit Validation
    function validateForm() {
        return validateName() && validateEmail() && validatePassword() && validateConfirmPassword();
    }

</script>

</body>
</html>
