// This script will run once the DOM is fully loaded
document.addEventListener('DOMContentLoaded', (event) => {

    // Fetch form elements from the DOM
    let registerForm = document.getElementById('registrationForm');
    let loginForm = document.getElementById('loginForm');

    // Basic form validation function
    // Ensures username and password are at least 5 characters long and less than 20 characters
    function validateForm(username, password) {
        if (username.trim().length < 5 || password.trim().length < 5) {
            alert('Username and password should be at least 5 characters long');
            return false;
        }
        if (username.trim() === '' || password.trim() === '') {
            alert("Username and password cannot be empty");
            return false;
        }
        if (username.length > 20) {
            alert('Username should be less than 20 characters');
            return false;
        }
        return true;
    }

    // Register Form Submission
    if(registerForm) {
        let registerUsernameInput = document.getElementById('usernameInput');
        let registerPasswordInput = document.getElementById('passwordInput');

        // Attach event listener for form submission
        registerForm.addEventListener('submit', function (event) {
            // Prevent default form submission action
            event.preventDefault();

            let username = registerUsernameInput.value;
            let password = registerPasswordInput.value;

            // Validate the form data
            if (!validateForm(username, password)) return;

            // Prepare the headers for the fetch request
            let headers = new Headers();
            headers.append('Content-Type', 'application/json');

            // Prepare the body for the fetch request
            let body = JSON.stringify({
                "email": username,
                "password": password
            });

            // Send the fetch request to the register endpoint
            fetch('http://127.0.0.1:8080/User/register', {
                method: 'POST',
                headers: headers,
                body: body,
            })
                // Handle the response from the fetch request
                .then(response => {
                    if (!response.ok) {
                        throw new Error('User registration failed with status ' + response.status);
                    }
                    console.log('User registration succeeded');
                    // Redirect to login page after successful registration
                    window.location.href = 'http://localhost:8080/login';
                })
                // Catch any errors from the fetch request
                .catch((error) => console.error('Error:', error));
        });
    }

    // Login Form Submission
    if(loginForm){
        let loginUsernameInput = document.getElementById('loginUsernameInput');
        let loginPasswordInput = document.getElementById('loginPasswordInput');

        // Attach event listener for form submission
        loginForm.addEventListener('submit', function(event) {
            // Prevent default form submission action
            event.preventDefault();

            let username = loginUsernameInput.value;
            let password = loginPasswordInput.value;

            // Validate the form data
            if (!validateForm(username, password)) return;

            // Prepare the headers for the fetch request
            let headers = new Headers();
            headers.append('Content-Type', 'application/json');

            // Prepare the body for the fetch request
            let body = JSON.stringify({
                "email": username,
                "password": password
            });

            // Send the fetch request to the login endpoint
            fetch('http://127.0.0.1:8080/User/login', {
                method: 'POST',
                headers: headers,
                body: body
            })
                // Handle the response from the fetch request
                .then(response => {
                    if (response.ok) {
                        return response.text();
                    } else {
                        return response.text().then(text => Promise.reject(text));
                    }
                })
                .then(data => {
                    console.log(data);
                    // After successful login, redirect user to the adoption page
                    window.location.href = 'http://localhost:8080/adoption';
                })
                // Catch any errors from the fetch request
                .catch(error => {
                    alert('Login failed: ' + error);
                    console.log(error);
                });
        });
    }
});
