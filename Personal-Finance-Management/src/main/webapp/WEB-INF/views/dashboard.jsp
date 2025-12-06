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

<!-- Logout Confirmation Modal (Cannot close without choice) -->
<div class="modal fade" id="logoutModal" tabindex="-1" aria-labelledby="logoutModalLabel" aria-hidden="true" data-bs-backdrop="static" data-bs-keyboard="false">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="logoutModalLabel">Confirm Logout</h5>
      </div>
      <div class="modal-body">
        You are already logged in. Do you want to logout before going to the login page?
      </div>
      <div class="modal-footer">
        <a href="${pageContext.request.contextPath}/logout" class="btn btn-danger">Yes, Logout</a>
        <button type="button" class="btn btn-secondary" id="stayHereBtn">No, Stay Here</button>
      </div>
    </div>
  </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<script>
// Your existing chart code remains same...
// ---------------- CATEGORY CHART ----------------
fetch("/api/chart/categorywise")
    .then(res => res.json())
    .then(data => {
        const labels = Object.keys(data);
        const values = Object.values(data);
        new Chart(document.getElementById("categoryChart"), {
            type: "pie",
            data: { labels: labels, datasets: [{ label: "Spending by Category", data: values, borderWidth: 1 }] },
            options: { responsive: true, scales: { y: { beginAtZero: true } } }
        });
    });

// ---------------- INCOME vs EXPENSE CHART ----------------
fetch("/api/chart/income-expense")
    .then(res => res.json())
    .then(data => {
        const labels = Object.keys(data);
        const values = Object.values(data);
        new Chart(document.getElementById("incomeExpenseChart"), {
            type: "bar",
            data: { labels: labels, datasets: [{ label: "Income vs Expense", data: values, borderWidth: 1 }] },
            options: { responsive: true }
        });
    });

// ---------------- DAYWISE EXPENSE CHART ----------------
fetch("/api/chart/daywise")
    .then(res => res.json())
    .then(data => {
        const labels = Object.keys(data);
        const values = Object.values(data);
        new Chart(document.getElementById("daywiseChart"), {
            type: "line",
            data: { labels: labels, datasets: [{ label: "Daily Expense Trend", data: values, borderWidth: 2, fill: true }] },
            options: { responsive: true, scales: { y: { beginAtZero: true } } }
        });
    });

//*** LOGOUT POPUP LOGIC - Shows ONLY on back navigation from dashboard ***
let modalShown = false;

window.onpageshow = function (event) {
    // Trigger only on back/forward navigation AND dashboard was visited before
    if ((event.persisted || (window.performance && window.performance.navigation.type === 2))
        && sessionStorage.getItem('dashboardVisited')) {
        
        showLogoutModal();
    }
};

function showLogoutModal() {
    if (!modalShown) {
        modalShown = true;
        var modalEl = document.getElementById('logoutModal');
        var logoutModal = new bootstrap.Modal(modalEl, {
            backdrop: 'static',
            keyboard: false
        });
        logoutModal.show();

        // Handle "No, Stay Here" button - close modal and reset flag
        document.getElementById('stayHereBtn').onclick = function() {
            logoutModal.hide();
            modalShown = false;
        };
    }
}

// Mark dashboard as visited (first login->dashboard: no popup)
sessionStorage.setItem('dashboardVisited', 'true');
// *** END NEW SECTION ***
</script>

</body>
</html>
