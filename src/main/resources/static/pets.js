function adoptPet(petId) {
    let petRequest = {
        petId: petId,
        userId: this.userId
    };

    fetch(`http://127.0.0.1:8080/pets`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(petRequest),
    })
        .then(response => response.json())
        .then(data => {
            console.log('Pet adopted:', data);
            // Store adopted pet in local storage
            let adoptedPets = JSON.parse(localStorage.getItem('adoptedPets')) || [];
            adoptedPets.push(data);
            localStorage.setItem('adoptedPets', JSON.stringify(adoptedPets));
            // Redirect to the dashboard page
            window.location.href = 'http://localhost:8080/dashboard';
        })
        .catch((error) => console.error('Error:', error));
}

function listPets() {
    // Retrieve pets from local storage
    let pets = JSON.parse(localStorage.getItem('adoptedPets')) || [];
    console.log('Pets:', pets);
    displayPets(pets);
}


function displayPets(pets) {
    const container = document.getElementById("petsContainer");
    if (container) { // Check if the container exists
        container.innerHTML = "";
        pets.forEach(pet => {
            const petElement = document.createElement("div");
            petElement.textContent = `Pet name: ${pet.name}, Pet type: ${pet.type}`;
            const adoptButton = document.createElement("button");
            adoptButton.textContent = "Adopt";
            adoptButton.addEventListener("click", () => adoptPet(pet.id));
            petElement.appendChild(adoptButton);
            container.appendChild(petElement);
        });
    } else {
        console.error('Could not find the container with id "petsContainer"');
    }
}

window.addEventListener('load', (event) => {
    listPets();
});
