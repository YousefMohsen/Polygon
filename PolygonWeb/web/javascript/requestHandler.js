var deletionRequest = function () {
    var r = confirm("Please confirm the deletion of the building!");
    if (r == true) {
        document.getElementById("deletionForm").submit();
        alert("Deletion request sent to Polygon.");
    }
};


var healthCheck = function () {
    alert("Health check request sent!");
    document.getElementById("HealthCheckForm").submit();
};


