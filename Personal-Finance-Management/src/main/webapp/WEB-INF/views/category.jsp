<%
	java.util.List<com.ksa.pfm.model.Category> categories=(java.util.List<com.ksa.pfm.model.Category>) request.getAttribute("categories");
%>
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


    <form class="row g-3 mb-4" action="/category" method="post">
        <div class="col-md-4">
            <label class="form-label">Category Name:</label>
            <input type="text" name="catName" class="form-control" placeholder="Enter category name" required>
        </div>

        <div class="col-md-3">
            <label class="form-label">Type:</label>
            <select class="form-select" name="type" required>
                <option>EXPENSE</option>
                <option>INCOME</option>
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
				<% 
				if(categories!=null && !categories.isEmpty())
				{
					for(com.ksa.pfm.model.Category category: categories)
					{
				%>
						<tr>
						    <td> <%=category.getName() %> </td>
						    <td> <%=category.getType() %> </td>
					   </tr>	
				<%			
					}
				}
				else
				{
				%>
					    <tr>
					        <td>Categories does not exists</td>
					   </tr>
				<%
				}
				%>
            </tbody>
        </table>
    </div>

</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>