<%@include file="head.jsp" %>



<div class="card-container">

		<div class="layout-container">

			<!-- Sidebar -->
			<!-- Sidebar -->
			<form action="#" method="post" class="filter-sidebar">

			    <h5>Filters</h5>
				
				<label class="form-label">Month</label>
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
				  <label class="form-label">Year</label>
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
								


			    <!-- Type -->
				<button type="submit" value="INCOME" class="btn-primary-custom mt-3 w-100">
							        INCOME
							    </button>
				<button type="submit" value="EXPENSE" class="btn-primary-custom mt-3 w-100">
							        EXPENSE
				</button>


			</form>
			
			<div class="main-content"
			     style="display:flex; flex-direction:column; padding-bottom:20px;">

			    <div class="page-title">Monthly Transactions</div>

			    <!-- Table -->
			    <div class="table-responsive" style="flex-grow:1;">
			        <table class="table table-hover align-middle">
			            <thead>
			                <tr>
			                    <th>Date</th>
			                    <th>Description</th>
			                    <th>Category</th>
			                    <th>Type</th>
			                    <th>Amount</th>
			                </tr>
			            </thead>
			            <tbody>
			                <tr></tr>
			            </tbody>
			        </table>
			    </div>

			    <!-- Download Button -->
			    <button type="submit"
			            class="btn-primary-custom mt-3 w-100"
			            style="margin-top:auto;">
			        Download
			    </button>

			</div>