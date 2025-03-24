document.addEventListener("DOMContentLoaded", () => {
const hrEmail = sessionStorage.getItem("hrEmail");

           if (!hrEmail) {
               alert("Access Denied. Please log in first.");
               window.location.href = "index.html";
               return;
           }
		   });
document.getElementById("addEmployeeForm").addEventListener("submit", function(event) {
    event.preventDefault();

    const employee = {
        name: document.getElementById("name").value,
        department: document.getElementById("department").value,
        email: document.getElementById("email").value,
        salary: document.getElementById("salary").value
    };

    fetch("http://localhost:8051/employees/add", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(employee)
    })
    .then(response => response.json())
    .then(data => {
        alert("Employee added successfully.");
        window.location.href = "viewemployees.html";
    })
    .catch(error => alert("Error adding employee: " + error.message));
});

// Logout Button Event Listener
document.getElementById("logoutbtn").addEventListener("click", async function(event) {
    event.preventDefault();

    try {
        const response = await fetch("http://localhost:8051/hr/logout", {
            method: "POST",
            credentials: "include",
        });

        if (response.ok) {
        sessionStorage.clear();
            alert("Logged out successfully!");
            window.location.href = "index.html"; 
        } else {
            alert("Logout failed. Please try again.");
        }
    } catch (error) {
        console.error("Error during logout:", error);
        alert("An error occurred during logout.");
    }
});