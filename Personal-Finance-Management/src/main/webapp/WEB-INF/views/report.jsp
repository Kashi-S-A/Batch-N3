<%@include file="head.jsp" %>

<%@ page import="java.util.List" %>
<%@ page import="com.ksa.pfm.model.Transaction" %>
<%@ page import="java.text.DecimalFormat" %>

<%-- 
    Retrieve the selected type from the model. 
    This is what your Controller adds: model.addAttribute("selectedType", reportType);
--%>
<%
    String selectedType = (String) request.getAttribute("selectedType");
    if (selectedType == null) {
        selectedType = ""; // Default to empty if not yet filtered
    }
%>

<div class="card-container">

    <div class="layout-container">

        <form action="/reports/filter" method="post" class="filter-sidebar">

            <h5>Filters</h5>
            
            <label class="form-label">Month</label>
            <select class="form-select" name="month" required>
                <option value="" selected disabled>Select Month</option>
                <option value="1" <%= "1".equals(request.getAttribute("selectedMonth") + "") ? "selected" : "" %>>January</option>
                <option value="2" <%= "2".equals(request.getAttribute("selectedMonth") + "") ? "selected" : "" %>>February</option>
                <option value="3" <%= "3".equals(request.getAttribute("selectedMonth") + "") ? "selected" : "" %>>March</option>
                <option value="4" <%= "4".equals(request.getAttribute("selectedMonth") + "") ? "selected" : "" %>>April</option>
                <option value="5" <%= "5".equals(request.getAttribute("selectedMonth") + "") ? "selected" : "" %>>May</option>
                <option value="6" <%= "6".equals(request.getAttribute("selectedMonth") + "") ? "selected" : "" %>>June</option>
                <option value="7" <%= "7".equals(request.getAttribute("selectedMonth") + "") ? "selected" : "" %>>July</option>
                <option value="8" <%= "8".equals(request.getAttribute("selectedMonth") + "") ? "selected" : "" %>>August</option>
                <option value="9" <%= "9".equals(request.getAttribute("selectedMonth") + "") ? "selected" : "" %>>September</option>
                <option value="10" <%= "10".equals(request.getAttribute("selectedMonth") + "") ? "selected" : "" %>>October</option>
                <option value="11" <%= "11".equals(request.getAttribute("selectedMonth") + "") ? "selected" : "" %>>November</option>
                <option value="12" <%= "12".equals(request.getAttribute("selectedMonth") + "") ? "selected" : "" %>>December</option>
            </select>
            
            <label class="form-label">Year</label>
            <select class="form-select" name="year" required>
                <option value="" selected disabled>Select Year</option>
                <%
                    String selectedYear = request.getAttribute("selectedYear") + "";
                    for(int year = 2000; year <= 2050; year++) {
                %>
                        <option value="<%=year %>" <%= String.valueOf(year).equals(selectedYear) ? "selected" : "" %>>
                            <%=year %>
                        </option>
                <%
                    }
                %>
            </select>
            
            <input type="hidden" id="selectedTypeHidden" value="<%= selectedType %>">

            <button type="submit" name="reportType" value="INCOME" 
                    class="btn-primary-custom mt-3 w-100" 
                    onclick="updateSelectedType('INCOME')">
                INCOME
            </button>
            <button type="submit" name="reportType" value="EXPENSE" 
                    class="btn-primary-custom mt-3 w-100"
                    onclick="updateSelectedType('EXPENSE')">
                EXPENSE
            </button>
        </form>
        
        <div class="main-content"
             style="display:flex; flex-direction:column; padding-bottom:20px;">

            <div class="page-title">Monthly Transactions</div>

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
                        <% 
                            List<com.ksa.pfm.model.Transaction> transactions = 
                                (List<com.ksa.pfm.model.Transaction>) request.getAttribute("transactions");
                            
                            // Re-retrieve the type for the empty/no-data message
                            String currentReportType = (String) request.getAttribute("selectedType");
                            if (currentReportType == null) {
                                currentReportType = "TRANSACTIONS";
                            }
                            
                            DecimalFormat df = new DecimalFormat("0.00");
                            
                            if (transactions != null && !transactions.isEmpty()) {
                                for (com.ksa.pfm.model.Transaction txn : transactions) {
                        %>
                                    <tr>
                                        <td><%= txn.getDate() %></td>
                                        <td><%= txn.getDescription() %></td>
                                        <td><%= txn.getCategory().getName() %></td> 
                                        <td><%= txn.getType().toString() %></td>
                                        <td><%= df.format(txn.getAmount()) %></td>
                                    </tr>
                        <% 
                                }
                                
                            // *** TOTAL ROW HAS BEEN REMOVED HERE ***

                            } else if (!currentReportType.equals("TRANSACTIONS")) {
                        %>
                                <tr>
                                    <td colspan="5" class="text-center text-muted">
                                        No <%= currentReportType %> transactions found for the selected period.
                                    </td>
                                </tr>
                        <%
                            } else {
                        %>
                                <tr>
                                    <td colspan="5" class="text-center text-muted">
                                        Please select a Month, Year, and Type to view the report.
                                    </td>
                                </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>

            <button type="button"
                    class="btn-primary-custom mt-3 w-100"
                    style="margin-top:auto;"
                    onclick="downloadReport();">
                Download PDF
            </button>

        </div>
    </div>
</div>

<script>
// Function to ensure the hidden type field is updated before form submission/download
function updateSelectedType(type) {
    document.getElementById('selectedTypeHidden').value = type;
}

function downloadReport() {
    var monthSelect = document.querySelector('select[name="month"]');
    var yearSelect = document.querySelector('select[name="year"]');
    var typeHidden = document.getElementById('selectedTypeHidden');

    var month = monthSelect.value;
    var year = yearSelect.value;
    var type = typeHidden.value; 

    if (!month || !year || !type) {
        alert("Please select a Month and Year, and click either INCOME or EXPENSE first to filter the report before downloading.");
        return;
    }

    // Construct the download URL to hit the @GetMapping("/reports/download") endpoint
    var url = '/reports/download?month=' + month + '&year=' + year + '&reportType=' + type;
    window.location.href = url;
}
</script>
