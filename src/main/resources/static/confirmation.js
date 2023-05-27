form.onsubmit = (e) => {
    e.preventDefault();

    // Retrieve the form data
    const formData = new FormData(form);

    // Send form data to server
    fetch('/api/sendAdoptionForm', {
        method: 'POST',
        body: JSON.stringify(Object.fromEntries(formData)),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(response => response.json()).then(data => {
        if(data.success) {
            alert('Adoption form sent successfully!');
        } else {
            alert('Something went wrong, please try again.');
        }
    });
};
