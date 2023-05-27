// Assume we have a function getUserPets() that fetches the user's pets from the server
async function getUserPets(userId) {
    // Replace with actual fetch or AJAX call to your server
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve([
                { name: 'Fluffy', type: 'Cat', age: 2, emoji: '🐱' },
                // the user's pets go here
            ]);
        }, 1000);
    });
}

window.onload = async () => {
    const pets = await getUserPets('userIdGoesHere');

    const container = document.getElementById('petsContainer');

    pets.forEach(pet => {
        const petElement = document.createElement('div');
        petElement.className = 'pet';

        const petName = document.createElement('h3');
        petName.innerText = pet.name;
        petElement.appendChild(petName);

        const petType = document.createElement('p');
        petType.innerText = `Type: ${pet.type}`;
        petElement.appendChild(petType);

        const petAge = document.createElement('p');
        petAge.innerText = `Age: ${pet.age}`;
        petElement.appendChild(petAge);

        const petEmoji = document.createElement('p');
        petEmoji.innerText = pet.emoji;
        petEmoji.className = 'petEmoji';
        petElement.appendChild(petEmoji);

        container.appendChild(petElement);
    });
};
