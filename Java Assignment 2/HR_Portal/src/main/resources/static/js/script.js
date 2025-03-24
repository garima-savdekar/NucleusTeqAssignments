document.getElementById("loginform").addEventListener("submit", async function(event) {
           event.preventDefault();

           const email = document.getElementById("email").value;
           const password = document.getElementById("password").value;

           const response = await fetch("http://localhost:8051/hr/login", {
               method: "POST",
               headers: { "Content-Type": "application/json" },
               body: JSON.stringify({ email, password })
           });

           if (response.ok) {
               alert("Login Successful");
               sessionStorage.setItem("hrEmail", email); 
               window.location.href = "viewEmployees.html"; 
           } else {
               alert("Invalid Login Credentials");
           }
       });