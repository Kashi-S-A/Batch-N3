<%
	java.util.List<com.ksa.pfm.model.Category> categories=(java.util.List<com.ksa.pfm.model.Category>) request.getAttribute("categories");
%>
<%@include file="head.jsp" %>


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