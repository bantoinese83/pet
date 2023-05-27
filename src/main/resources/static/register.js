document.getElementById('registrationForm').addEventListener('submit', function(event) {
    event.preventDefault();

    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;

    let headers = new Headers();
    headers.append('Content-Type', 'application/json');

    let body = JSON.stringify({
        "username": username,
        "password": password
    });

    fetch('/users', {
        method: 'POST',
        headers: headers,
        body: body
    }).then(response => {
        if (response.ok) {
            return response.json();
        } else {
            throw new Error('Error: ' + response.statusText);
        }
    }).then(data => {
        // handle response data
        console.log(data);

        // redirect user to the adoption page
        window.location.href = 'templates/adoption.html';

    }).catch(error => {
        // handle errors
        console.log(error);
    });
});
