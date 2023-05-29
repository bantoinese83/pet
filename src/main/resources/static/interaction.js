// Play with a pet
function playWithPet(petId) {
    fetch(`http://127.0.0.1:8080/pets/${petId}/play`, {
        method: 'POST',
    })
        .then(response => response.json())
        .then(data => console.log('Pet played:', data))
        .catch((error) => console.error('Error:', error));
}

// Feed a pet
function feedPet(petId) {
    fetch(`http://127.0.0.1:8080/pets/${petId}/feed`, {
        method: 'POST',
    })
        .then(response => response.json())
        .then(data => console.log('Pet fed:', data))
        .catch((error) => console.error('Error:', error));
}

// Groom a pet
function groomPet(petId) {
    fetch(`http://127.0.0.1:8080/pets/${petId}/groom`, {
        method: 'POST',
    })
        .then(response => response.json())
        .then(data => console.log('Pet groomed:', data))
        .catch((error) => console.error('Error:', error));
}
