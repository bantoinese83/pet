document.addEventListener("DOMContentLoaded", function() {
    const petId = localStorage.getItem('petId');

    document.getElementById("feed").addEventListener("click", function() {
        fetch("/pets/" + petId + "/feed", {
            method: "PUT",
        })
            .then(response => response.json())
            .then(data => {
                document.getElementById("pet-status").innerText = data.status;
                // Show the pet's response
                document.getElementById("pet-response").innerText = JSON.stringify(data.petResponse);
            });
    });

    document.getElementById("play").addEventListener("click", function() {
        fetch("/pets/" + petId + "/play", {
            method: "PUT",
        })
            .then(response => response.json())
            .then(data => {
                document.getElementById("pet-status").innerText = data.status;
                // Show the pet's response
                document.getElementById("pet-response").innerText = JSON.stringify(data.petResponse);
            });
    });

    document.getElementById("groom").addEventListener("click", function() {
        fetch("/pets/" + petId + "/groom", {
            method: "PUT",
        })
            .then(response => response.json())
            .then(data => {
                document.getElementById("pet-status").innerText = data.status;
                // Show the pet's response
                document.getElementById("pet-response").innerText = JSON.stringify(data.petResponse);
            });
    });
});
