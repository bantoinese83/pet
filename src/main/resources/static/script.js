const pets = [
    { name: 'Fluffy', type: 'Cat', age: 2, emoji: '🐱' },
    { name: 'Fido', type: 'Dog', age: 3, emoji: '🐶' },
    { name: 'Buddy', type: 'Dog', age: 1, emoji: '🐶' },
    { name: 'Spike', type: 'Dragon', age: 4, emoji: '🐉' },
    { name: 'Tiny', type: 'T-Rex', age: 5, emoji: '🦖' },
    { name: 'Slithers', type: 'Snake', age: 2, emoji: '🐍' },
    { name: 'Rex', type: 'Alien', age: 3, emoji: '👽' },
    { name: 'Ghosty', type: 'Ghost', age: 1, emoji: '👻' },
    { name: 'Robo', type: 'Robot', age: 4, emoji: '🤖' },
    { name: 'Yeti', type: 'Yeti', age: 5, emoji: '🐻‍❄️' },
];


window.onload = () => {
    const container = document.getElementById('availablePetsContainer');

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
        petEmoji.style.fontSize = '50px';
        petEmoji.innerText = pet.emoji;
        petElement.appendChild(petEmoji);

        const adoptButton = document.createElement('button');
        adoptButton.innerText = 'Adopt';
        petElement.appendChild(adoptButton);

        container.appendChild(petElement);
    });
}
