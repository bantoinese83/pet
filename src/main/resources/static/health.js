// This function fetches the health of a pet with a given petId
// This function fetches the current pet data
async function getPetData() {
    try {
        const response = await fetch('/getPetData');

        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        } else {
            const petData = await response.json();
            // Assume petData includes a property 'id' with the pet's ID
            const petElement = document.getElementById('petData');
            petElement.dataset.petId = petData.id;
        }
    } catch (error) {
        console.error("Failed to fetch pet data: ", error);
    }
}

// Call getPetData when the page loads
document.addEventListener('DOMContentLoaded', getPetData);


// Call getPetData when the page loads
document.addEventListener('DOMContentLoaded', getPetData);


// This function updates the health bar
function updateHealthBar(health) {
    try {
        const healthBar = document.getElementById('healthBar');
        healthBar.style.width = `${health}%`;
    } catch (error) {
        console.error("Failed to update health bar: ", error);
    }
}

async function getPetHealth(petId) {



}

// Call getPetHealth when the page loads
document.addEventListener('DOMContentLoaded', async () => {
    try {
        await getPetData(); // ensure the pet data has been fetched before proceeding
        const petId = document.getElementById('petData').dataset.petId;
        const health = await getPetHealth(petId);
        updateHealthBar(health);
    } catch (error) {
        console.error("Failed to get petId or fetch pet health: ", error);
    }
});

