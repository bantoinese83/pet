// Assume we have a function getAdoptedPet() that fetches the pet information from the server
async function getAdoptedPet() {
    // Replace with actual fetch or AJAX call to your server
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve({
                name: 'Fluffy',
                type: 'Cat',
                age: 2,
                emoji: '🐱'
            });
        }, 1000);
    });
}

window.onload = async () => {
    const pet = await getAdoptedPet();

    document.getElementById('petName').value = pet.name;
    document.getElementById('petType').value = pet.type;
    document.getElementById('petAge').value = pet.age;
    document.getElementById('petEmoji').value = pet.emoji;

    const form = document.getElementById('adoptionForm');

    form.onsubmit = (e) => {
        e.preventDefault();

        // Retrieve the form data
        const formData = new FormData(form);

        // Do something with the form data
        console.log('Form data:', Object.fromEntries(formData));
    };
};
