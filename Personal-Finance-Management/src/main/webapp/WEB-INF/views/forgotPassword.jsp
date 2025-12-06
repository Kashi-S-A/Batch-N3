<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<title>Forgot Password</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
    body {
        background: linear-gradient(135deg, #b7e1d8, #d9f1ec);
        height: 100vh;
        display: flex;
        align-items: center;
        justify-content: center;
        font-family: 'Inter', sans-serif;
    }
    .card-box {
        width: 380px;
        background: rgba(255,255,255,0.75);
        padding: 40px;
        border-radius: 18px;
        box-shadow: 0 15px 40px rgba(0,0,0,0.15);
        text-align: center;
    }
    .btn-submit {
        width: 100%;
        background: #0A7866;
        color: white;
        border-radius: 10px;
        padding: 12px;
        font-weight: 600;
        margin-top: 15px;
    }
</style>
</head>

<body>

<div class="card-box">
    <h3 class="text-success">Forgot Password</h3>
    <p class="text-muted">Enter registered email to receive OTP</p>
    
    <p style="color: green">${msg}</p>

	<form action="/verifyMail" method="post">
	    <input type="email" name="email" class="form-control" placeholder="Enter Your Email" required>
	    <button type="submit" class="btn-submit">Send OTP</button>
	</form>

    <a href="/login" class="text-primary mt-3 d-block">Back to Login</a>
</div>

</body>
</html>