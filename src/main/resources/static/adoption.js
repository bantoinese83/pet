document.addEventListener('DOMContentLoaded', async () => {
    const userId = localStorage.getItem('userId');
    // Display the pets in the available pets container
    const pets = await getUserPets(userId);
    displayPets(pets, 'availablePetsContainer', true);
});
