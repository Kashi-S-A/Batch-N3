<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Add-Transaction</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">

		<h1>Register Here</h1>
		<form action="">
			<div class="mb-3">
  				<label for="exampleFormControlInput2" class="form-label">Amount </label>
  				<input type="number" class="form-control" id="exampleFormControlInput2" placeholder="enter amount">
			</div>
			<div class="mb-3">
  				<label for="exampleFormControlInput1" class="form-label">Description</label>
  				<input type="text" class="form-control" id="exampleFormControlInput1" placeholder="enter description">
			</div>
			<div class="mb-3">
  				<label for="exampleFormControlInput3" class="form-label">Date</label>
  				<input type="date" class="form-control" id="exampleFormControlInput3" placeholder="enter date">
			</div>
			<div class="mb-3">
  				<label for="exampleFormControlInput4" class="form-label">Type</label>
  				<select name="type">
  					<option value="INCOME">INCOME</option>
  					<option value="EXPENSE">EXPENSE</option>
  				</select>
			</div>
			
			<div class="mb-3">
  				<label for="exampleFormControlInput5" class="form-label">Category</label>
  				<select name="categort">
  					<option value="INCOME">--Category--</option>
  					<option value="dummy">Dummy</option>
  				</select>
			</div>
		
			<button type="button" class="btn btn-secondary">Save</button>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
		crossorigin="anonymous"></script>
</body>
</html>