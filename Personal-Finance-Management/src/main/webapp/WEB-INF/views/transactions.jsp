<%@include file="head.jsp" %>


	<%
		java.util.List<com.ksa.pfm.model.Category> categories=(java.util.List<com.ksa.pfm.model.Category>) request.getAttribute("categories");
		java.util.List<com.ksa.pfm.model.Transaction> txns = (java.util.List<com.ksa.pfm.model.Transaction>) request
			.getAttribute("txns");
	%>

	<div class="card-container">

		<div class="layout-container">

			<!-- Sidebar -->
			<!-- Sidebar -->
			<form action="/filter-transactions" method="post" class="filter-sidebar">

			    <h5>Filters</h5>

			    <!-- Type -->
			    <label class="form-label" for="type">Type</label>
			    <select id="type" name="type" class="form-select">
			        <option value="" selected disabled>Select type</option>
			        <option value="INCOME">INCOME</option>
			        <option value="EXPENSE">EXPENSE</option>
			    </select>

			    <!-- Category -->
				<label class="form-label" for="category">Category</label>
				<select id="category" name="category" class="form-select">
				<option value="">Select category</option>
					<%	
					  	if(categories!=null && !categories.isEmpty())
					    {
					    	for(com.ksa.pfm.model.Category category : categories){
					 %>
					     <option value=<%=category.getId() %> ><%=category.getName() %></option>
					      <%
					      	}
					       	}
					     %>
				</select>
				
			    <!-- Date Filters -->
			    <label class="form-label mt-2">From Date</label>
			    <input type="date" name="fromDate" class="form-control">

			    <label class="form-label mt-2">To Date</label>
			    <input type="date" name="toDate" class="form-control">

			    <!-- Button -->
			    <button type="submit" class="btn-primary-custom mt-3 w-100">
			        Apply Filters
			    </button>

			</form>


			<!-- Main Content -->
			<div class="main-content">

				<div class="page-title">Your Transactions</div>


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
							<% if (txns != null && !txns.isEmpty()) { 
								for (com.ksa.pfm.model.Transaction txn : txns) { %>
							<tr>
								<td><%=txn.getDate()%></td>
								<td><%=txn.getDescription()%></td>
								<td><%=txn.getCategory().getName()%></td>
								<td><%=txn.getType()%></td>
								<td><%=txn.getAmount()%></td>
								<td>
									<form action="/update-transaction" method="get" style="display:inline;">
									<button type="submit" name="txn" class="btn-edit" value="<%= txn.getId() %>" }>Edit</button>
									</form>
									<button class="btn-delete">Delete</button>
								</td>
							</tr>
							<% } } else { %>
							<tr>
								<td colspan="6" class="text-center text-danger">No Transactions</td>
							</tr>
							<% } %>
						</tbody>
					</table>
				</div>

			</div>
		</div>


	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
