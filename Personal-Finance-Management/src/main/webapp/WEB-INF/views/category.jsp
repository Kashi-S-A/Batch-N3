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
