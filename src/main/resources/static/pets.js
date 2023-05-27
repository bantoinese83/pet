// pet.js

async function fetchPetData() {
    const petId = 'PET_ID_HERE'; // replace with actual pet id
    const response = await fetch(`/pets/${petId}`);
    if (response.ok) {
        const petData = await response.json();
        petData.happiness =  Math.round(Math.random() * 100)
        petData.hunger =  Math.round(Math.random() * 100)
        petData.cleanliness =  Math.round(Math.random() * 100)
        document.getElementById('pet-status').innerHTML = `
            <p>Name: ${petData.name}</p>
            <p>Type: ${petData.type}</p>
            <p>Happiness: ${petData.happiness}</p>
            <p>Hunger: ${petData.hunger}</p>
            <p>Cleanliness: ${petData.cleanliness}</p>
        `;
    }
}

window.onload = fetchPetData;
