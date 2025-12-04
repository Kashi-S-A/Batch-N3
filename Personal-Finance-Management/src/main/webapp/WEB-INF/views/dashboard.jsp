<%@include file="head.jsp" %>

    <!-- Main Dashboard -->
    <div class="glass-panel">

        <div class="heading">Welcome, ${user}</div>
        <p class="subtext">Your financial health snapshot</p>

        <!-- Chart Grid -->
        <div class="row g-4 mt-3">
            <div class="col-lg-6 col-md-6">
                <div class="chart-box">
					<canvas id="categoryChart"></canvas>
				</div>
            </div>
            <div class="col-lg-6 col-md-6">
                <div class="chart-box">
					<canvas id="incomeExpenseChart"></canvas>
				</div>
            </div>
            <div class="col-lg-6 col-md-6">
                <div class="chart-box">
					<canvas id="daywiseChart"></canvas>
				</div>
            </div>
            
        </div>

    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<script>

// ---------------- CATEGORY CHART (API: /api/chart/categorywise) ----------------
fetch("/api/chart/categorywise")
    .then(res => res.json())
    .then(data => {

        const labels = Object.keys(data);
        const values = Object.values(data);

        new Chart(document.getElementById("categoryChart"), {
            type: "pie",
            data: {
                labels: labels,
                datasets: [{
                    label: "Spending by Category",
                    data: values,
                    borderWidth: 1
                }]
            },
            options: {
                responsive: true,
                scales: { y: { beginAtZero: true } }
            }
        });
    });


// ---------------- INCOME vs EXPENSE CHART (API: /api/chart/income-expense) ----------------
fetch("/api/chart/income-expense")
    .then(res => res.json())
    .then(data => {

        const labels = Object.keys(data);
        const values = Object.values(data);

        new Chart(document.getElementById("incomeExpenseChart"), {
            type: "bar",
            data: {
                labels: labels,
                datasets: [{
                    label: "Income vs Expense",
                    data: values,
                    borderWidth: 1
                }]
            },
            options: { responsive: true }
        });
    });


// ---------------- DAYWISE EXPENSE CHART (API: /api/chart/daywise) ----------------
fetch("/api/chart/daywise")
    .then(res => res.json())
    .then(data => {

        const labels = Object.keys(data);
        const values = Object.values(data);

        new Chart(document.getElementById("daywiseChart"), {
            type: "line",
            data: {
                labels: labels,
                datasets: [{
                    label: "Daily Expense Trend",
                    data: values,
                    borderWidth: 2,
                    fill: true
                }]
            },
            options: {
                responsive: true,
                scales: { y: { beginAtZero: true } }
            }
        });
    });
    

</script>

</body>
</html>
