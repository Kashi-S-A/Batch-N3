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

		<h1>Login Here</h1>
		<form action="">
			<div class="mb-3">
  				<label for="exampleFormControlInput1" class="form-label">Email</label>
  				<input type="email" class="form-control" id="exampleFormControlInput1" placeholder="enter email">
			</div>
			<div class="mb-3">
				<label for="inputPassword5" class="form-label">Password</label>
				<input type="password" id="inputPassword5" class="form-control" aria-describedby="passwordHelpBlock">
			</div>
			<div id="passwordHelpBlock" class="form-text">
 				 Your password must be 8-20 characters long, contain letters and numbers, and must not contain spaces, special characters, or emoji.
			</div>
		
			<button type="button" class="btn btn-secondary">Login</button>
		</form>
		<a href="#">New User ? Register Here</a>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
		crossorigin="anonymous"></script>
</body>
</html>