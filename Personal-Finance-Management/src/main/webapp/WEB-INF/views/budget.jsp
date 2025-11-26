<%@include file="head.jsp" %>

	<%
	java.util.List<com.ksa.pfm.model.Category> categories=(java.util.List<com.ksa.pfm.model.Category>) request.getAttribute("categories");
	java.util.List<com.ksa.pfm.model.Budget> budgets=(java.util.List<com.ksa.pfm.model.Budget>) request.getAttribute("budgets");
	%>

<div class="form-container">
    <div class="glass-card">

        <div class="title">Add Monthly Budget</div>
        <p class="sub">Track and control your spending goals</p>
        <p style="color: green">${msg}</p>

        <form method="post" action="/budget">

            <div class="mb-3">
                <label class="form-label"><i class="fa-solid fa-calendar-days"></i> Month</label>
                <select class="form-select" name="month" required>
                    <option value="" selected disabled>Select Month</option>
                    <option value="1">January</option>
                    <option value="2">February</option>
                    <option value="3">March</option>
                    <option value="4">April</option>
                    <option value="5">May</option>
                    <option value="6">June</option>
                    <option value="7">July</option>
                    <option value="8">August</option>
                    <option value="9">September</option>
                    <option value="10">October</option>
                    <option value="11">November</option>
                    <option value="12">December</option>
                </select>
            </div>

            <div class="mb-3">
                <label class="form-label"><i class="fa-solid fa-calendar"></i> Year</label>
                 <select class="form-select" name="year" required>
                    <option value="" selected disabled>Select Year</option>
                    <%
                    	for(int year = 2000; year<=2050;year++)
                    	{
                    %>
                   			<option value=<%=year %>><%=year %></option>
                    <%
                    	}
                    %>
                </select>
            </div>

            <div class="mb-3">
                <label class="form-label"><i class="fa-solid fa-tag"></i> Category</label>
                <select class="form-select" name="catName" required>
                    <option value="" selected disabled>Select Category</option>
                    <%	
                    	if(categories!=null && !categories.isEmpty())
                    	{
                    	for(com.ksa.pfm.model.Category category : categories){
                    %>
                    	 <option value=<%=category.getName() %> ><%=category.getName() %></option>
                    <%
                    	}
                    	}else{
                    %>
                   		 <option value="Others">Others</option>
                   	<%
                   		 }
                   	%>
                </select>
            </div>

            <div class="mb-3">
                <label class="form-label"><i class="fa-solid fa-indian-rupee-sign"></i> Amount</label>
                <input type="number" class="form-control" name="amount" placeholder="Enter amount" required>
            </div>

            <button type="submit" class="btn-save">Save Budget</button>
        </form>
    </div>
</div>


<div class="table-wrap">
    <h4 class="mb-3"><i class="fa-solid fa-list"></i> Existing Budget</h4>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Month</th>
            <th>Year</th>
            <th>Category</th>
            <th>Amount</th>
        </tr>
        </thead>
        <tbody>
        <%
        if(budgets!=null&&!budgets.isEmpty())
        {
        	for(com.ksa.pfm.model.Budget budget : budgets)
        	{
        %>
        <tr>
        	<td><%=budget.getMonth() %></td>
        	<td><%=budget.getYear() %></td>
        	<td><%=budget.getCategory().getName() %></td>
        	<td><%=budget.getAmount() %></td>
        </tr>
        <%
        	}
        }else{
        %>
        	<tr>
        		<td>Budgets Does Not Exists</td>
        	</tr>
        <%
        }
        %>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
