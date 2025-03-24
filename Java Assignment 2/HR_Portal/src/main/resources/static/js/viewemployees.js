document.addEventListener('DOMContentLoaded', function() {
    const email = sessionStorage.getItem("hrEmail");

    if (!email) {
        alert("You must be logged in to access this page.");
        window.location.href = "index.html";
    }
});

async function fetchEmployees() {
    try {
        const response = await fetch('http://localhost:8051/employees/allEmployees');
        const employees = await response.json();

        const tableBody = document.getElementById('employeetablebody');
        tableBody.innerHTML = '';

        employees.forEach(employee => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${employee.name}</td>
                <td>${employee.department}</td>
                <td>${employee.email}</td>
                <td>${employee.salary}</td>
                
               
                <td>
                    <button onclick="editEmployee(${employee.id})">Edit</button>
                    <button onclick="deleteEmployee(${employee.id})">Delete</button>
                </td>
            `;
            tableBody.appendChild(row);
        });
    } catch (error) {
        console.error('Error fetching employees:', error);
    }
}

window.onload = fetchEmployees;

// Edit employee Function
function editEmployee(employeeId) {
    window.location.href = `editEmployee.html?id=${employeeId}`;
}

// Delete employee Function
async function deleteEmployee(employeeId) {
    if (confirm("Are you sure you want to delete this employee?")) {
        try {
            const response = await fetch(`http://localhost:8051/employees/delete/${employeeId}`, {
                method: 'DELETE',
                credentials: 'include'
            });

            if (response.ok) {
                alert("Employee deleted successfully!");
                location.reload(); 
            } else if (response.status === 403) {
                alert("Access Denied! Please log in");
                window.location.href = "viewEmployee.html";
            } else {
                alert("Error in deleting employee.");
            }
        } catch (error) {
            console.error('Error:', error);
            alert("An error occurred. Please try again.");
        }
    }
}

document.getElementById("addemployeebtn").addEventListener("click", function() {
    window.location.href = "addEmployee.html";
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

