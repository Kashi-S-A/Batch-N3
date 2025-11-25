<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Finance Manager - Add Transaction</title>

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

  <style>
    :root{
      --primary: #0A7866;
      --primary-light: #15a089;
      --bg-a: #b7e1d8;
      --bg-b: #d9f1ec;
      --card-w: 420px;
    }

    html,body{height:100%}
    body{
      margin:0;
      font-family: Arial, sans-serif;
      background: linear-gradient(135deg, var(--bg-a), var(--bg-b));
      display:flex;
      align-items:center;
      justify-content:center;
      padding: 32px;
    }

    .glass-card{
      width: var(--card-w);
      background: rgba(255,255,255,0.78);
      border-radius: 16px;
      padding: 34px;
      box-shadow: 0 14px 40px rgba(0,0,0,0.12);
      backdrop-filter: blur(12px);
      animation: popIn .45s ease;
    }
    @keyframes popIn{from{opacity:0; transform: translateY(12px)} to{opacity:1; transform:none}}

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

    .form-label { font-weight:600; color:#333; }
    .form-control, .form-select {
      border-radius:10px;
      padding:11px 12px;
      border:1.4px solid #d0d6d9;
      transition:box-shadow .18s, border-color .18s, transform .12s;
    }
    .form-control:focus, .form-select:focus{
      border-color: var(--primary);
      box-shadow: 0 0 0 5px rgba(10,121,104,0.08);
      outline: none;
    }

    .row-gap { gap:12px; }

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

    .helper {
      font-size:13px;
      color:#6b6f73;
      margin-top:8px;
    }

   
    @media (max-width:480px){
      .glass-card{ width: 92%; padding:20px }
    }
  </style>
</head>
<body>

  <div class="glass-card">
    <div class="brand">Add Transaction</div>
    <div class="lead">Add a new transaction to track your spending</div>

    <form>
      <div class="mb-3">
        <label class="form-label" for="amount">Amount</label>
        <input id="amount" name="amount" type="number" step="0.01" class="form-control" placeholder="Enter amount" required>
      </div>

      <div class="mb-3">
        <label class="form-label" for="description">Description</label>
        <input id="description" name="description" type="text" class="form-control" placeholder="e.g. Groceries" required>
      </div>

      <div class="mb-3">
        <label class="form-label" for="date">Date</label>
        <input id="date" name="date" type="date" class="form-control" required>
      </div>

      <div class="d-flex row-gap mb-3">
        <div style="flex:1">
          <label class="form-label" for="type">Type</label>
          <select id="type" name="type" class="form-select" required>
            <option value="">Select type</option>
            <option value="INCOME">Income</option>
            <option value="EXPENSE">Expense</option>
          </select>
        </div>

        <div style="flex:1">
          <label class="form-label" for="category">Category</label>
          <select id="category" name="category" class="form-select" required>
            <option value="">Select category</option>
            <option value="Food">Food</option>
            <option value="Salary">Salary</option>
            <option value="Utilities">Utilities</option>
            <option value="Shopping">Shopping</option>
            <option value="Other">Other</option>
          </select>
        </div>
      </div>

      <div class="helper">Password/encoding safe: page uses only ISO-compatible characters.</div>

      <button type="submit" class="btn-primary-custom mt-3">Save Transaction</button>
    </form>
  </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
