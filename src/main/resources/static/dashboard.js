// Assume we have a function getUserPets() that fetches the user's pets from the server
async function getUserPets(userId) {
    // Replace with actual fetch or AJAX call to your server
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve([
                { name: 'KoobCam', type: 'Monster', age: 5 },
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

        petElement.appendChild(detailsElement);

        container.appendChild(petElement);
    });
};
