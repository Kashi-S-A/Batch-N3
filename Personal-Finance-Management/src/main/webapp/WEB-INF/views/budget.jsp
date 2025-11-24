<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Add Budget</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
      rel="stylesheet"
      crossorigin="anonymous">

</head>
<body>

<div class="container mt-4">

    <h1 class="mb-4">Add Budget</h1>

    <!-- Form -->
    <form>

        <div class="mb-3">
            <label class="form-label">Month</label>
            <select class="form-control" name="month">
                <option value="">--Select Month--</option>
                <option>January</option>
                <option>February</option>
                <option>March</option>
                <option>April</option>
                <option>May</option>
                <option>June</option>
                <option>July</option>
                <option>August</option>
                <option>September</option>
                <option>October</option>
                <option>November</option>
                <option>December</option>
            </select>
        </div>

        <div class="mb-3">
            <label class="form-label">Year</label>
            <input type="number" class="form-control" placeholder="Enter year">
        </div>

        <div class="mb-3">
            <label class="form-label">Category</label>
            <select class="form-control" name="category">
                <option value="">--Select Category--</option>
                <option>Food</option>
                <option>Travel</option>
                <option>Shopping</option>
                <option>Salary</option>
                <option>Other</option>
            </select>
        </div>

        <div class="mb-3">
            <label class="form-label">Amount</label>
            <input type="number" class="form-control" placeholder="Enter amount">
        </div>

        <button type="button" class="btn btn-primary">Save Budget</button>
    </form>

    <hr class="my-4">

    <h3>Existing Budget</h3>

    <!-- Dummy Table -->
    <table class="table table-bordered mt-3">
        <thead class="table-dark">
            <tr>
                <th>Month</th>
                <th>Year</th>
                <th>Category</th>
                <th>Amount</th>
            </tr>
        </thead>
        
        <tbody>
            <tr>
                <td>January</td>
                <td>2025</td>
                <td>Food</td>
                <td>5000</td>
            </tr>
            <tr>
                <td>February</td>
                <td>2025</td>
                <td>Travel</td>
                <td>3000</td>
            </tr>
            <tr>
                <td>March</td>
                <td>2025</td>
                <td>Shopping</td>
                <td>4500</td>
            </tr>
        </tbody>
    </table>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>

</body>
</html>
