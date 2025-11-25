
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Add Category</title>

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

/* Form Styling */
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

<!-- Centered Form -->
<div class="form-container">
    <div class="glass-card">

        <div class="title">Add Category</div>
        <p class="sub">Create and organize your spending or income classifications</p>

        <form>

            <div class="mb-3">
                <label class="form-label"><i class="fa-solid fa-tags"></i> Category Name</label>
                <input type="text" class="form-control" name="categoryName" placeholder="Enter category name" required>
            </div>

            <div class="mb-3">
                <label class="form-label"><i class="fa-solid fa-filter"></i> Type</label>
                <select class="form-select" name="type" required>
                    <option value="">Select Type</option>
                    <option>Expense</option>
                    <option>Income</option>
                </select>
            </div>

            <button type="submit" class="btn-save">Save Category</button>
        </form>
    </div>
</div>
<div class="table-wrap">
    <h4 class="mb-3"><i class="fa-solid fa-list"></i> All Categories</h4>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Category Name</th>
            <th>Type</th>
        </tr>
        </thead>
        <tbody>
        <tr><td>Food</td><td>Expense</td></tr>
        <tr><td>Salary</td><td>Income</td></tr>
        <tr><td>Shopping</td><td>Expense</td></tr>
        <tr><td>Investments</td><td>Income</td></tr>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
=======
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Category</title>

    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body class="bg-light">


<nav class="navbar navbar-expand-lg navbar-dark bg-dark px-4">
    <a class="navbar-brand text-white" href="#"></a>

    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ms-auto">
            <li class="nav-item"><a class="nav-link" href="#">Dashboard</a></li>
            <li class="nav-item"><a class="nav-link" href="#">Transactions</a></li>
            <li class="nav-item"><a class="nav-link" href="#">Add Transaction</a></li>
            <li class="nav-item"><a class="nav-link" href="#">Budgets</a></li>
            <li class="nav-item"><a class="nav-link active" href="#">Category</a></li>
            <li class="nav-item"><a class="nav-link" href="#">Logout</a></li>
        </ul>
    </div>
</nav>



<div class="container mt-5">

    <h3 class="fw-bold">Add Category</h3>


    <form class="row g-3 mb-4">
        <div class="col-md-4">
            <label class="form-label">Category Name:</label>
            <input type="text" class="form-control" placeholder="Enter category name">
        </div>

        <div class="col-md-3">
            <label class="form-label">Type:</label>
            <select class="form-select">
                <option>Expense</option>
                <option>Income</option>
            </select>
        </div>

        <div class="col-md-2 d-flex align-items-end">
            <button class="btn btn-primary w-100">Save</button>
        </div>
    </form>

    <h5 class="mb-3">All Categories</h5>

    <!-- TABLE -->
    <div class="table-responsive">
        <table class="table table-bordered table-striped text-center align-middle">
            <thead class="table-dark">
                <tr>
                    <th>Name</th>
                    <th>Type</th>
                </tr>
            </thead>

            <tbody>
                <tr>
                    <td>Salary</td>
                    <td>INCOME</td>
                </tr>
                <tr>
                    <td>Shopping</td>
                    <td>EXPENSE</td>
                </tr>
                <tr>
                    <td>Rent</td>
                    <td>EXPENSE</td>
                </tr>
                <tr>
                    <td>Petrol</td>
                    <td>EXPENSE</td>
                </tr>
                <tr>
                    <td>Grocery</td>
                    <td>EXPENSE</td>
                </tr>
            </tbody>
        </table>
    </div>

</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
