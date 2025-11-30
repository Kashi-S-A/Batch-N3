<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Finance Dashboard</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" />

<style>
:root{
    --primary: #0A7866;
    --primary-light: #14a48b;
    --light-a: #b7e1d8;
    --light-b: #d9f1ec;
}

body{
    background: linear-gradient(135deg, var(--light-a), var(--light-b));
    font-family: Arial, sans-serif;
    padding: 28px;
}

/* Navbar */
.navbar{
    background: var(--primary);
    border-radius: 16px;
    padding: 12px 22px;
    box-shadow: 0 10px 28px rgba(0,0,0,0.14);
}
.nav-link, .navbar-brand{
    color: white !important;
    font-weight: 600;
}
.logout-btn{
    background: #05ff7e;
    color: #000000 !important;
    padding: 7px 18px;
    border-radius: 15px;
    font-weight: bold;
}

/* Card Container */
.glass-panel{
    background: rgba(255,255,255,0.78);
    border-radius: 20px;
    padding: 35px;
    margin-top: 15px;
    box-shadow: 0 16px 40px rgba(0,0,0,0.12);
    backdrop-filter: blur(14px);
}

.heading{
    text-align: center;
    font-size: 26px;
    font-weight: 800;
    color: var(--primary);
}
.subtext{
    text-align: center;
    color: #5d6466;
    margin-bottom: 25px;
}

/* Chart Boxes */
.chart-box{
    height: 340px;
    padding: 5px;
    background: rgba(255,255,255,0.58);
    backdrop-filter: blur(12px);
    border: 1.5px solid #bcded4;
    border-radius: 18px;
    box-shadow: 0 8px 24px rgba(0,0,0,0.08);
    display:flex;
    align-items:center;
    justify-content:center;
    font-size: 15px;
    color:#6c7072;
}

/* CSS for budget.jsp  */

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

/*
add=trnascatiom
*/
.brand {
      text-align:center;
      font-weight:700;
      font-size:20px;
      color:var(--primary);
      margin-bottom:6px;
      letter-spacing:0.6px;
    }
    .lead {
      text-align:center;
      color:#575b5f;
      font-size:13px;
      margin-bottom:20px;
    }
	.btn-primary-custom{
	     width:100%;
	     background:var(--primary);
	     color:#fff;
	     border:none;
	     padding:12px;
	     border-radius:12px;
	     font-weight:700;
	     font-size:15px;
	     transition: transform .16s, box-shadow .16s;
	   }
	   .btn-primary-custom:hover{
	     background:var(--primary-light);
	     transform: translateY(-3px);
	     box-shadow: 0 10px 26px rgba(10,120,102,0.26);
	   }
 /*
	style for transcartion	   
 */
 

 /* ---- SIDEBAR + TABLE LAYOUT ---- */
 .layout-container {
 	display: flex;
 	gap: 25px;
 	margin-top: 30px;
 }

 /* Sidebar Card */
 .filter-sidebar {
 	width: 230px;
 	background: rgba(255, 255, 255, 0.75);
 	border-radius: 18px;
 	padding: 20px;
 	box-shadow: 0 12px 30px rgba(0,0,0,0.15);
 	backdrop-filter: blur(10px);
 	height: fit-content;
 }

 .filter-sidebar h5 {
 	color: var(--primary);
 	font-weight: bold;
 	text-align: center;
 	margin-bottom: 15px;
 	font-size: 20px;
 }

 .filter-sidebar label {
 	font-size: 14px;
 	font-weight: bold;
 	color: var(--primary);
 	margin-top: 12px;
 	display: block;
 }

 .filter-sidebar input,
 .filter-sidebar select {
 	border-radius: 10px;
 	margin-top: 5px;
 	padding: 8px;
 	border: 1px solid #cfd9d8;
 }

 /* Full width button inside sidebar */
 .filter-sidebar button {
 	width: 100%;
 	margin-top: 15px;
 	border-radius: 10px;
 }

 /* Main content card beside sidebar */
 .main-content {
 	flex-grow: 1;
 	background: rgba(255, 255, 255, 0.75);
 	border-radius: 18px;
 	padding: 25px;
 	box-shadow: 0 15px 40px rgba(0, 0, 0, 0.15);
 	backdrop-filter: blur(15px);
 }

 /* Title inside content (same style as your existing title) */
 .page-title {
 	font-size: 26px;
 	font-weight: bold;
 	color: var(--primary);
 	text-align: center;
 	margin-bottom: 20px;
 }

 /* Search Row Style */
 .search-row {
 	display: flex;
 	gap: 12px;
 	margin-bottom: 15px;
 }
 .btn-edit {
 	background: #0b6bd6;
 	border: none;
 	padding: 6px 12px;
 	color: white;
 	border-radius: 8px;
 	font-size: 13px;
 	transition: 0.25s;
 }

 .btn-edit:hover {
 	background: #0a56ad;
 	transform: scale(1.05);
 }

 .btn-delete {
 	background: #c62828;
 	border: none;
 	padding: 6px 12px;
 	color: white;
 	border-radius: 8px;
 	font-size: 13px;
 	transition: 0.25s;
 }

 .btn-delete:hover {
 	background: #a01e1e;
 	transform: scale(1.05);
 }
</style>
</head>
<body>

<div class="container">

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg">
        <a class="navbar-brand" href="/dashboard">Finance Dashboard</a>
        <button class="navbar-toggler bg-light" type="button" data-bs-toggle="collapse" data-bs-target="#nav">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="nav">
            <div class="navbar-nav gap-3">
                <a class="nav-link" href="/transactions">Transactions</a>
                <a class="nav-link" href="/add-transaction">Add Transaction</a>
                <a class="nav-link" href="/budget">Budget</a>
                <a class="nav-link" href="/category">Category</a>

                <a class="nav-link" href="/report">Report</a>

                <a class="nav-link logout-btn" href="/logout">Logout</a>
            </div>
        </div>
    </nav>