// This function fetches the health of a pet with a given petId
async function getPetHealth(petId) {
    const response = await fetch(`/pets/${petId}/health`);

    if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
    } else {
        const petHealth = await response.json();
        // Here, you can update the health bar with the fetched pet health.
        updateHealthBar(petHealth);
    }
}

// This function updates the health bar
function updateHealthBar(health) {
    const healthBar = document.getElementById('healthBar');
    healthBar.style.width = `${health}%`;
}

// Call getPetHealth when the page loads
document.addEventListener('DOMContentLoaded', (event) => {
    const petId = document.getElementById('petData').dataset.petId;
    getPetHealth(petId).then(r => console.log(r));

});
