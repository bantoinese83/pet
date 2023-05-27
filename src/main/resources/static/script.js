const pets = [
    { name: 'KoobCam', type: 'Monster', age: 5 },
];



window.onload = () => {
    const container = document.getElementById('availablePetsContainer');

    pets.forEach(pet => {
        const petElement = document.createElement('div');
        petElement.className = 'monster-container'; // create a container for each pet

        const monsterElement = document.createElement('div');
        monsterElement.className = 'monster';
        petElement.appendChild(monsterElement);

        const detailsElement = document.createElement('div'); // a container for the details
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

        const adoptButton = document.createElement('button');
        adoptButton.innerText = 'Adopt';
        detailsElement.appendChild(adoptButton);

        petElement.appendChild(detailsElement); // add the details div to the pet container
        container.appendChild(petElement);
    });
};
