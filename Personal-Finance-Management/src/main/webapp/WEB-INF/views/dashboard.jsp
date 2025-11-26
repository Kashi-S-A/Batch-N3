<%@include file="head.jsp" %>

    <!-- Main Dashboard -->
    <div class="glass-panel">

        <div class="heading">Welcome, ${user}</div>
        <p class="subtext">Your financial health snapshot</p>

        <!-- Chart Grid -->
        <div class="row g-4 mt-3">
            <div class="col-lg-6 col-md-6">
                <div class="chart-box">Chart 1 (Spending Overview)</div>
            </div>
            <div class="col-lg-6 col-md-6">
                <div class="chart-box">Chart 2 (Income vs Expense)</div>
            </div>
            <div class="col-lg-6 col-md-6">
                <div class="chart-box">Chart 3 (Budget Distribution)</div>
            </div>
            <div class="col-lg-6 col-md-6">
                <div class="chart-box">Chart 4 (Category Breakdown)</div>
            </div>
        </div>

    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
