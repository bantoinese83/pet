// const pets = [
//     { name: 'KoobCam', type: 'Monster', age: 5 },
// ];
//
// async function getUserPets(userId) {
//     return new Promise((resolve) => {
//         setTimeout(() => {
//             resolve(pets);
//         }, 1000);
//     });
// }
//
// function displayPets(pets, containerId) {
//     const container = document.getElementById(containerId);
//
//     // Check if the container exists before proceeding
//     if (container) {
//         pets.forEach(pet => {
//             const petElement = document.createElement('div');
//             petElement.className = 'monster-container';
//
//             const monsterElement = document.createElement('div');
//             monsterElement.className = 'monster';
//             petElement.appendChild(monsterElement);
//
//             const detailsElement = document.createElement('div');
//             detailsElement.className = 'details';
//
//             const petName = document.createElement('h3');
//             petName.innerText = pet.name;
//             detailsElement.appendChild(petName);
//
//             const petType = document.createElement('p');
//             petType.innerText = `Type: ${pet.type}`;
//             detailsElement.appendChild(petType);
//
//             const petAge = document.createElement('p');
//             petAge.innerText = `Age: ${pet.age}`;
//             detailsElement.appendChild(petAge);
//
//             petElement.appendChild(detailsElement);
//
//             container.appendChild(petElement);
//         });
//     }
// }
//
// function addAdoptButton(containerId) {
//     const container = document.getElementById(containerId);
//
//     // Check if the container exists before proceeding
//     if (container) {
//         container.querySelectorAll('.monster-container').forEach((petElement, index) => {
//             const detailsElement = petElement.querySelector('.details');
//
//             const adoptButton = document.createElement('button');
//             adoptButton.innerText = 'Adopt';
//             adoptButton.addEventListener('click', async () => {
//
//                 window.location.href = 'http://localhost:8080/dashboard';
//             });
//             detailsElement.appendChild(adoptButton);
//         });
//     }
// }const pets = [
//     { name: 'KoobCam', type: 'Monster', age: 5 },
// ];
//
// async function getUserPets(userId) {
//     return new Promise((resolve) => {
//         setTimeout(() => {
//             resolve(pets);
//         }, 1000);
//     });
// }
//
// function displayPets(pets, containerId) {
//     const container = document.getElementById(containerId);
//
//     // Check if the container exists before proceeding
//     if (container) {
//         pets.forEach(pet => {
//             const petElement = document.createElement('div');
//             petElement.className = 'monster-container';
//
//             const monsterElement = document.createElement('div');
//             monsterElement.className = 'monster';
//             petElement.appendChild(monsterElement);
//
//             const detailsElement = document.createElement('div');
//             detailsElement.className = 'details';
//
//             const petName = document.createElement('h3');
//             petName.innerText = pet.name;
//             detailsElement.appendChild(petName);
//
//             const petType = document.createElement('p');
//             petType.innerText = `Type: ${pet.type}`;
//             detailsElement.appendChild(petType);
//
//             const petAge = document.createElement('p');
//             petAge.innerText = `Age: ${pet.age}`;
//             detailsElement.appendChild(petAge);
//
//             petElement.appendChild(detailsElement);
//
//             container.appendChild(petElement);
//         });
//     }
// }
//
// function addAdoptButton(containerId) {
//     const container = document.getElementById(containerId);
//
//     // Check if the container exists before proceeding
//     if (container) {
//         container.querySelectorAll('.monster-container').forEach((petElement, index) => {
//             const detailsElement = petElement.querySelector('.details');
//
//             const adoptButton = document.createElement('button');
//             adoptButton.innerText = 'Adopt';
//             adoptButton.addEventListener('click', async () => {
//
//                 window.location.href = 'http://localhost:8080/dashboard';
//             });
//             detailsElement.appendChild(adoptButton);
//         });
//     }
// }
//
//
// document.addEventListener('DOMContentLoaded', async () => {
//     const pets = await getUserPets('userIdGoesHere');
//
//     // Display the pets in the available pets container
//     displayPets(pets, 'availablePetsContainer');
//     addAdoptButton('availablePetsContainer'); // Only add the adopt button to the available pets container
//
//     // Display the pets in the user's pets container (no adopt button)
//     displayPets(pets, 'petsContainer');
//     // Removed addAdoptButton('petsContainer'); because pets in this container are already adopted
// });
//
//
//
// document.addEventListener('DOMContentLoaded', async () => {
//     const pets = await getUserPets('userIdGoesHere');
//
//     // Display the pets in the available pets container
//     displayPets(pets, 'availablePetsContainer');
//     addAdoptButton('availablePetsContainer'); // Only add the adopt button to the available pets container
//
//     // Display the pets in the user's pets container (no adopt button)
//     displayPets(pets, 'petsContainer');
//     // Removed addAdoptButton('petsContainer'); because pets in this container are already adopted
// });
