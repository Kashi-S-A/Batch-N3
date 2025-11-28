<%@include file="head.jsp" %>

<%
	com.ksa.pfm.model.Transaction txns = (com.ksa.pfm.model.Transaction) request.getAttribute("txn");
	java.util.List<com.ksa.pfm.model.Category> categories=(java.util.List<com.ksa.pfm.model.Category>) request.getAttribute("categories");
%>
  <div style="margin-top:30px;display:flex;align-item:center;justify-content:center">
	<div class="glass-card">
	    <div class="brand">Update Transaction</div>
	    <div class="lead">Add a new transaction to track your spending</div>

	    <form action="/update-transcation" method="post">
	      <div class="mb-3">
	        <label class="form-label" for="amount">Amount</label>
	        <input id="amount" name="amount" type="number" step="0.01" class="form-control" value="<%= txns.getAmount() %>" placeholder="<%= txns.getAmount() %>" required>
	      </div>

	      <div class="mb-3">
	        <label class="form-label" for="description">Description</label>
	        <input id="description" name="description" type="text" class="form-control" value="<%= txns.getDescription() %>" placeholder="<%= txns.getDescription() %>" required>
	      </div>

	      <div class="mb-3">
	        <label class="form-label" for="date">Date</label>
	        <input id="date" name="date" type="date" class="form-control"value="<%= txns.getDate() %>" placeholder="<%= txns.getDate() %>"  required>
	      </div>

	      <div class="d-flex row-gap mb-3">
	        <div style="flex:1">
	          <label class="form-label" for="type">Type</label>
	          <select id="type" name="type" class="form-select" required>
	            <option value="<%= txns.getType() %>"  hidden><%= txns.getType() %> </option>
	            <option value="INCOME">INCOME</option>
	            <option value="EXPENSE">EXPENSE</option>
	          </select>
	        </div>

	        <div style="flex:1">
	          <label class="form-label" for="category">Category</label>
	          <select id="category" name="category" class="form-select" required>
	            <option value="<%= txns.getCategory().getName() %>" hidden><%= txns.getCategory().getName() %></option>
	          			<%	
	                    	if(categories!=null && !categories.isEmpty())
	                    	{
	                    	for(com.ksa.pfm.model.Category category : categories){
	                    %>
	                    	 <option value=<%=category.getName() %> ><%=category.getName() %></option>
	                    <%
	                    	}
	                    	}
	                    %>
	          </select>
	        </div>
	      </div>

	      <div class="helper">Password/encoding safe: page uses only ISO-compatible characters.</div>

	      <button type="submit" class="btn-primary-custom mt-3">Update Transaction</button>
	    </form>
	  </div>
  </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
