<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Finance Manager - Transactions</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet">

<style>
:root {
	--primary: #0A7866;
	--primary-light: #15a089;
	--background: #E8EFF1;
}

body {
	background: linear-gradient(135deg, #b7e1d8, #d9f1ec);
	margin: 0;
	font-family: Arial, sans-serif;
	padding-top: 50px;
}

.card-container {
	width: 90%;
	max-width: 1100px;
	margin: auto;
	background: rgba(255, 255, 255, 0.75);
	border-radius: 18px;
	padding: 25px 35px;
	box-shadow: 0 15px 40px rgba(0, 0, 0, 0.15);
	backdrop-filter: blur(12px);
	animation: fadeIn 0.5s ease;
}

@
keyframes fadeIn {from { opacity:0;
	transform: translateY(10px);
}

to {
	opacity: 1;
	transform: translateY(0);
}

}
.title {
	font-size: 28px;
	font-weight: bold;
	color: var(--primary);
	margin-bottom: 20px;
	text-align: center;
}

.search-section {
	display: flex;
	gap: 12px;
	margin-bottom: 20px;
}

.btn-primary-custom {
	background: var(--primary);
	border: none;
	color: white;
	padding: 10px 18px;
	border-radius: 10px;
	transition: 0.25s;
	font-weight: bold;
}

.btn-primary-custom:hover {
	background: var(--primary-light);
	transform: translateY(-2px);
	box-shadow: 0 8px 18px rgba(10, 120, 102, 0.30);
}

.table {
	border-radius: 10px;
	overflow: hidden;
}

.table thead {
	background: var(--primary);
	color: white;
	font-size: 15px;
}

.table tbody tr:hover {
	background: rgba(10, 120, 102, 0.08);
	cursor: pointer;
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

	<%
	java.util.List<com.ksa.pfm.model.Transaction> txns = (java.util.List<com.ksa.pfm.model.Transaction>) request
			.getAttribute("txns");
	%>

	<div class="card-container">

		<div class="title">Your Transactions</div>

		<!-- Search / Filter Section -->
		<div class="search-section">
			<input class="form-control"
				placeholder="Search by description, category, type">
			<button class="btn-primary-custom">Search</button>
			<a href="/add-transaction"><button class="btn-primary-custom">Add Transaction</button></a>
		</div>

		<!-- Table -->
		<div class="table-responsive">
			<table class="table table-hover align-middle">
				<thead>
					<tr>
						<th>Date</th>
						<th>Description</th>
						<th>Category</th>
						<th>Type</th>
						<th>Amount</th>
						<th style="width: 150px;">Action</th>
					</tr>
				</thead>
				<tbody>
					<%
					if (txns != null && !txns.isEmpty()) {
						for (com.ksa.pfm.model.Transaction txn : txns) {
					%>
					<tr>
						<td><%=txn.getDate()%></td>
						<td><%=txn.getDescription()%></td>
						<td><%=txn.getCategory().getName()%></td>
						<td><%=txn.getType()%></td>
						<td><%=txn.getAmount()%></td>
						<td>
							<button class="btn-edit">Edit</button>
							<button class="btn-delete">Delete</button>
						</td>
					</tr>
					<%
					}
					} else {
					%>
					<tr>
						<td>No Transactions Found!!!!!!!!!</td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
