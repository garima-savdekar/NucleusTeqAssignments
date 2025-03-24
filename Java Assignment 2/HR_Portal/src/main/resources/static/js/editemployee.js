document.addEventListener('DOMContentLoaded', function() {
    const email = sessionStorage.getItem("hrEmail");

    if (!email) {
        alert("You must be logged in to access this page.");
        window.location.href = "index.html";
    }
});
document.addEventListener('DOMContentLoaded', function () {
    const employeeId = new URLSearchParams(window.location.search).get('id');

    fetch(`http://localhost:8051/employees/${employeeId}`, { credentials: 'include' })
        .then(response => response.json())
        .then(employee => {
            document.getElementById('name').value = employee.name;
            document.getElementById('department').value = employee.department;
            document.getElementById('email').value = employee.email;
            document.getElementById('salary').value = employee.salary;
           
        })
        .catch(error => console.error('Error fetching employee:', error));

    // Submit the edited form
    document.getElementById("editEmployeeForm").addEventListener("submit", async function(event) {
        event.preventDefault();

        const updatedEmployee = {
            name: document.getElementById('name').value,
            department: document.getElementById('department').value,
            email: document.getElementById('email').value,
            salary: document.getElementById('salary').value,
            
        };

        try {
            const response = await fetch(`http://localhost:8051/employees/update/${employeeId}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(updatedEmployee),
                credentials: 'include'
            });

            if (response.ok) {
                alert("Employee updated successfully!");
                window.location.href = "/viewEmployees.html";
            } else if (response.status === 403) {
                alert("Access Denied. Please log in first.");
                window.location.href = "index.html";
            } else {
                alert("Error updating employee.");
            }
        } catch (error) {
            console.error('Error:', error);
            alert("An error occurred while updating the employee.");
        }
    });
});
