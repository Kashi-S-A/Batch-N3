<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<title>Verify OTP</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
    body {
        background: linear-gradient(135deg, #b7e1d8, #d9f1ec);
        height: 100vh;
        display: flex;
        align-items: center;
        justify-content: center;
    }
    .card-box {
        width: 380px;
        background: rgba(255,255,255,0.75);
        padding: 40px;
        border-radius: 18px;
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
    <h3 class="text-success">Verify OTP</h3>
    <p class="text-muted">Please check your email for OTP</p>

    <p style="color: red">${msg}</p>

	<form action="/verifyOtp" method="post">
	    <input type="hidden" name="email" value="${email}" />
	    <input type="text" name="otp" class="form-control" placeholder="Enter OTP" required>
	    <button type="submit" class="btn-submit">Verify OTP</button>
	</form>

</div>

</body>
</html>