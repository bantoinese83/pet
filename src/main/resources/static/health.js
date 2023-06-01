// Fetch the status of a pet
async function getPetStatus(petId) {
    const response = await fetch(`/pets/${petId}/status`);
    if (response.ok) {
        const data = await response.json();
        const { health, hunger, happiness } = data;
        const overallStatus = Math.floor((health + hunger + happiness) / 3);
        updateStatusBar('statusBar', overallStatus);
    } else {
        console.error(`No status data for pet with ID ${petId}`);
    }
}

// Update status bar
function updateStatusBar(statusBarId, value) {
    const statusBar = document.getElementById(statusBarId);
    if (statusBar) {
        statusBar.style.width = `${value}%`;
        statusBar.textContent = `${value}%`;
    } else {
        console.error(`Status bar element with ID ${statusBarId} not found.`);
    }
}

// Bind event listeners
window.onload = () => {
    const feedButton = document.getElementById('feed');
    const playButton = document.getElementById('play');
    const groomButton = document.getElementById('groom');

    feedButton.addEventListener('click', async () => {
        const adoptedPets = JSON.parse(localStorage.getItem('ownedPets')) || [];
        if (adoptedPets.length > 0) {
            const petId = adoptedPets[0].id; // Assuming the first adopted pet is selected
            await getPetStatus(petId);
        }
    });

    playButton.addEventListener('click', async () => {
        const adoptedPets = JSON.parse(localStorage.getItem('ownedPets')) || [];
        if (adoptedPets.length > 0) {
            const petId = adoptedPets[0].id; // Assuming the first adopted pet is selected
            await getPetStatus(petId);
        }
    });

    groomButton.addEventListener('click', async () => {
        const adoptedPets = JSON.parse(localStorage.getItem('ownedPets')) || [];
        if (adoptedPets.length > 0) {
            const petId = adoptedPets[0].id; // Assuming the first adopted pet is selected
            await getPetStatus(petId);
        }
    });
};

// Initialize pet stats
let health = 100;
let hunger = 100;
let happiness = 100;

// Update the status bar every second
setInterval(() => {
    if (health > 0) health -= 0.1;
    if (hunger > 0) hunger -= 0.1;
    if (happiness > 0) happiness -= 0.1;

    updateStatusBar('statusBar', (health + hunger + happiness) / 3);

    if (health <= 20 || hunger <= 20 || happiness <= 20) {
        alert('Your pet needs attention!');
    }
}, 1000);

// Adding sound effects
const feedSound = new Audio('/sounds/feed.mp3');
const playSound = new Audio('/sounds/play.mp3');
const groomSound = new Audio('/sounds/groom.mp3');
