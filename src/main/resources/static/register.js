// Fetch elements from the DOM once instead of multiple times
let form = document.getElementById('registrationForm');
let usernameInput = document.getElementById('username');
let passwordInput = document.getElementById('password');

// Function for basic form validation
function validateForm(username, password) {
    if (username.trim().length < 5 || password.trim().length < 5) {
        alert('Username and password should be at least 5 characters long');
        return false;
    }

    if (password.trim() === '') {
        alert("Password cannot be empty");
        return false;
    }

    if (username.length > 20) {
        alert('Username should be less than 20 characters');
        return false;
    }

    if (username.trim() === '') {
        alert('Username cannot be empty');
        return false;
    }
    return true;
}

// Event listener for form submission
form.addEventListener('submit', function(event) {
    event.preventDefault();

    let username = usernameInput.value;
    let password = passwordInput.value;

    // Perform validation
    if (!validateForm(username, password)) return;

    let headers = new Headers();
    headers.append('Content-Type', 'application/json');

    let body = JSON.stringify({
        "name": username,
        "id": password
    });
    console.log(body);
    console.log(headers);
    console.log(username);
    console.log(password);


    fetch('/users', {
        method: 'POST',
        headers: headers,
        body: body
    })
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                // Read the response as text and when it's done, reject the promise
                return response.text().then(text => Promise.reject(text));
            }
        })
        .then(data => {
            console.log(data);
            // After successful registration, redirect user to the adoption page
            window.location.href = 'templates/adoption.html';
        })
        .catch(error => {
            // If registration failed, inform the user
            alert('Registration failed: ' + error);
            console.log(error);
        });
});
