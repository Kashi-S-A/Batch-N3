<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Read Data</h1>
		<form action="read" method="post">
				<div class="mb-2">
  					<label for="exampleFormControlInput2" class="form-label">Name </label>
  					<input type="text" class="form-control" name="name" id="exampleFormControlInput2" placeholder="name" required>
				</div>
				<div class="mb-3">
  					<label for="exampleFormControlInput1" class="form-label">Email address</label>
  					<input type="email" class="form-control" name="email" id="exampleFormControlInput1" placeholder="name@example.com" required>
				</div>
				<div class="mb-3">
  					<label for="exampleFormControlInput3" class="form-label">Password</label>
  					<input type="password" class="form-control" name="pwd" id="exampleFormControlInput3" placeholder="name@123" required>
				</div>
				
				<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
		crossorigin="anonymous"></script>
</body>
</html>