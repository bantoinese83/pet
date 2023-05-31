function generateRandomId() {
    return Math.floor(Math.random() * 1000) + 1; // Generate a random number between 1 and 1000
}

const pets = [
    { id: generateRandomId(), name: 'KoobCam', type: 'Monster', age: 5 },
];

async function getUserPets(userId) {
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve(pets);
        }, 1000);
    });
}

function displayPets(pets, containerId, shouldAddAdoptButton = false) {
    const container = document.getElementById(containerId);

    if (container) {
        // Clear out the existing content in the container
        container.innerHTML = '';

        pets.forEach((pet) => {
            const petElement = document.createElement('div');
            petElement.className = 'monster-container';

            const monsterElement = document.createElement('div');
            monsterElement.className = 'monster';
            petElement.appendChild(monsterElement);

            const detailsElement = document.createElement('div');
            detailsElement.className = 'details';

            const petName = document.createElement('h3');
            petName.innerText = pet.name;
            detailsElement.appendChild(petName);

            const petType = document.createElement('p');
            petType.innerText = `Type: ${pet.type}`;
            detailsElement.appendChild(petType);

            const petAge = document.createElement('p');
            petAge.innerText = `Age: ${pet.age}`;
            detailsElement.appendChild(petAge);

            if (shouldAddAdoptButton) {
                const adoptButton = document.createElement('button');
                adoptButton.innerText = 'Adopt';
                adoptButton.addEventListener('click', async () => {
                    await adoptPet(pet.id, pet.name, pet.type, pet.age);
                    window.location.href = 'http://localhost:8080/dashboard';
                });
                detailsElement.appendChild(adoptButton);
            }

            petElement.appendChild(detailsElement);
            container.appendChild(petElement);
        });
    } else {
        console.error(`No element found with id ${containerId}`);
    }
}

async function adoptPet(petId, name, type, age) {
    const userId = localStorage.getItem('userId');

    try {
        const data = { id: petId, name, type, age, health: 100, hunger: 100, happiness: 100 };
        console.log('Pet adopted:', data);
        let ownedPets = JSON.parse(localStorage.getItem('ownedPets')) || [];
        ownedPets.push(data);
        localStorage.setItem('ownedPets', JSON.stringify(ownedPets));
    } catch (error) {
        console.error('Error:', error);
    }
}


function listUserPets() {
    const userId = localStorage.getItem('userId');
    // Retrieve adopted pets for this user from local storage
    const ownedPets = JSON.parse(localStorage.getItem('ownedPets')) || [];
    // Display owned pets on dashboard
    displayPets(ownedPets, 'petsContainer');
}

document.addEventListener('DOMContentLoaded', listUserPets);
