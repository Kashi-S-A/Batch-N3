<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Add Budget</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" />

<style>
:root{
    --primary:#0A7866;
    --primary-light:#14a48b;
    --bg-a:#b7e1d8;
    --bg-b:#d9f1ec;
}

body{
    background:linear-gradient(135deg, var(--bg-a), var(--bg-b));
    font-family: Arial, sans-serif;
    min-height:100vh;
    display:flex;
    flex-direction:column;
    align-items:center;
}


.form-container{
    width:100%;
    display:flex;
    justify-content:center;
    margin-top:30px;
}


.glass-card{
    width: 420px;
    background:rgba(255,255,255,0.75);
    border-radius:20px;
    padding:36px;
    backdrop-filter:blur(12px);
    box-shadow:0 16px 40px rgba(0,0,0,0.12);
    text-align:center;
}

.title{
    font-size:26px;
    font-weight:800;
    color:var(--primary);
}

.sub{
    margin-bottom:20px;
    font-size:14px;
    color:#5a6263;
}

/* Form style */
.form-control, .form-select{
    border-radius:10px;
    padding:12px;
    border:1.4px solid #ccd8d6;
    transition:.2s;
}
.form-control:focus, .form-select:focus{
    border-color: var(--primary);
    box-shadow:0 0 0 4px rgba(10,120,102,0.15);
}

.btn-save{
    width:100%;
    background:var(--primary);
    padding:13px;
    font-weight:700;
    border-radius:12px;
    color:white;
    border:none;
    transition:.18s;
}

.btn-save:hover{
    background:var(--primary-light);
    transform:translateY(-3px);
    box-shadow:0 10px 25px rgba(10,121,104,.25);
}


.table-wrap{
    margin-top:40px;
    width:85%;
    background:rgba(255,255,255,0.60);
    padding:20px;
    border-radius:16px;
    backdrop-filter:blur(10px);
    box-shadow:0 12px 30px rgba(0,0,0,0.10);
}

.table thead{
    background:var(--primary);
    color:white;
}
</style>
</head>
<body>


<div class="form-container">
    <div class="glass-card">

        <div class="title">Add Monthly Budget</div>
        <p class="sub">Track and control your spending goals</p>

        <form>

            <div class="mb-3">
                <label class="form-label"><i class="fa-solid fa-calendar-days"></i> Month</label>
                <select class="form-select" name="month">
                    <option>Select Month</option>
                    <option>January</option><option>February</option><option>March</option>
                    <option>April</option><option>May</option><option>June</option>
                    <option>July</option><option>August</option><option>September</option>
                    <option>October</option><option>November</option><option>December</option>
                </select>
            </div>

            <div class="mb-3">
                <label class="form-label"><i class="fa-solid fa-calendar"></i> Year</label>
                <input type="number" name="year" class="form-control" placeholder="Enter year" required>
            </div>

            <div class="mb-3">
                <label class="form-label"><i class="fa-solid fa-tag"></i> Category</label>
                <select class="form-select" name="category" required>
                    <option value="">Select Category</option>
                    <option>Food</option>
                    <option>Travel</option>
                    <option>Shopping</option>
                    <option>Salary</option>
                    <option>Other</option>
                </select>
            </div>

            <div class="mb-3">
                <label class="form-label"><i class="fa-solid fa-indian-rupee-sign"></i> Amount</label>
                <input type="number" class="form-control" name="amount" placeholder="Enter amount" required>
            </div>

            <button type="submit" class="btn-save">Save Budget</button>
        </form>
    </div>
</div>


<div class="table-wrap">
    <h4 class="mb-3"><i class="fa-solid fa-list"></i> Existing Budget</h4>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Month</th>
            <th>Year</th>
            <th>Category</th>
            <th>Amount</th>
        </tr>
        </thead>
        <tbody>
        <tr><td>January</td><td>2025</td><td>Food</td><td>5000</td></tr>
        <tr><td>February</td><td>2025</td><td>Travel</td><td>3000</td></tr>
        <tr><td>March</td><td>2025</td><td>Shopping</td><td>4500</td></tr>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
