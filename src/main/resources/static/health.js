// Fetch the random event for a pet
async function triggerRandomEventForPet(petId) {
    const response = await fetch(`http://127.0.0.1:8080/pets/${petId}/randomEvent`);
    const data = await response.text();

    if (data) {
        alert(`Random event for pet: ${data}`);
        updateStatusBar('randomEvent', data);
    } else {
        console.error(`No random event for pet with ID ${petId}`);
    }
}

// Fetch the health of a pet
async function getPetHealth(petId) {
    const response = await fetch(`http://127.0.0.1:8080/pets/${petId}/health`);
    const data = await response.json();

    if (data) {
        updateStatusBar('health', data);
    } else {
        console.error(`No health data for pet with ID ${petId}`);
    }
}

// Update status bar
function updateStatusBar(statusBarId, value) {
    const statusBar = document.getElementById(statusBarId);

    statusBar.style.width = `${value}%`;
    statusBar.textContent = `${value}%`;
}

// Bind event listeners
window.onload = () => {
    const feedButton = document.getElementById('feed');
    const playButton = document.getElementById('play');
    const groomButton = document.getElementById('groom');

    feedButton.addEventListener('click', () => {
        // Assuming feeding increases health by 20 and decreases hunger by 10
        getPetHealth('1234').then((currentHealth) => {
            updateStatusBar('health', Math.min(currentHealth + 20, 100));
            updateStatusBar('hunger', Math.max(currentHealth - 10, 0));
        });
    });

    playButton.addEventListener('click', () => {
        // Assuming playing increases happiness by 20 but decreases health by 10
        getPetHealth('1234').then((currentHealth) => {
            updateStatusBar('happiness', Math.min(currentHealth + 20, 100));
            updateStatusBar('health', Math.max(currentHealth - 10, 0));
        });
    });

    groomButton.addEventListener('click', () => {
        // Assuming grooming increases health by 10
        getPetHealth('1234').then((currentHealth) => {
            updateStatusBar('health', Math.min(currentHealth + 10, 100));
        });
    });
};
// Initialize pet stats
let health = 100;
let hunger = 100;
let happiness = 100;

// Update the status bars every minute
setInterval(() => {
    if (health > 0) health -= 10;
    if (hunger > 0) hunger -= 10;
    if (happiness > 0) happiness -= 10;

    updateStatusBar('healthBar', health);
    updateStatusBar('hungerBar', hunger);
    updateStatusBar('happinessBar', happiness);

    if (health <= 20 || hunger <= 20 || happiness <= 20) {
        alert("Your pet needs attention!");
    }
}, 60000);

// Adding sound effects
const feedSound = new Audio('/sounds/feed.mp3');
const playSound = new Audio('/sounds/play.mp3');
const groomSound = new Audio('/sounds/groom.mp3');





// Bind event listeners
window.onload = () => {
    const feedButton = document.getElementById('feed');
    const playButton = document.getElementById('play');
    const groomButton = document.getElementById('groom');

    feedButton.addEventListener('click', () => {
        feedSound.play();
        health = Math.min(health + 20, 100);
        hunger = Math.max(hunger - 10, 0);
        updateStatusBar('healthBar', health);
        updateStatusBar('hungerBar', hunger);
    });

    playButton.addEventListener('click', () => {
        playSound.play();
        happiness = Math.min(happiness + 20, 100);
        health = Math.max(health - 10, 0);
        updateStatusBar('happinessBar', happiness);
        updateStatusBar('healthBar', health);
    });

    groomButton.addEventListener('click', () => {
        groomSound.play();
        health = Math.min(health + 10, 100);
        updateStatusBar('healthBar', health);
    });
};
