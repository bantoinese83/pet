// pets.js
async function fetchPetData() {
    const petId = 'PET_ID_HERE'; // replace with actual pet id
    const response = await fetch(`/pets/${petId}`);
    if (response.ok) {
        const petData = await response.json();
        petData.happiness =  Math.round(Math.random() * 100);
        petData.hunger =  Math.round(Math.random() * 100);
        petData.health = Math.round(Math.random() * 100);
        document.getElementById('pet-status').innerHTML = `
            <p>Name: ${petData.name}</p>
            <p>Type: ${petData.type}</p>
        `;
        updateStatusBar('healthBar', petData.health);
        updateStatusBar('happinessBar', petData.happiness);
        updateStatusBar('hungerBar', petData.hunger);
    }
}

// dashboard.js
function updateStatusBar(id, percentage) {
    const statusBar = document.getElementById(id);
    statusBar.style.width = `${percentage}%`;
}

// interaction.js
const interactionButtons = document.querySelectorAll('#actions button');
interactionButtons.forEach(button => {
    button.addEventListener('click', function(event) {
        interactWithPet(event.target.id);
    });
});

async function interactWithPet(interactionType) {
    const petId = document.getElementById('petData').dataset.petId;
    const response = await fetch(`/pets/${petId}/${interactionType}`, { method: 'PUT' });
    if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
    } else {
        const petData = await response.json();
        updateStatusBar(`${interactionType}Bar`, petData[interactionType]);
    }
}

// on page load
document.addEventListener('DOMContentLoaded', fetchPetData);
