document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("feed").addEventListener("click", function() {
        fetch("/feed", {
            method: "POST",
            // ...add any other necessary options here
        })
            .then(response => response.json())
            .then(data => {
                // Update the pet's status on the page using the response data
                document.getElementById("pet-status").innerText = data.status;
            });
    });

    document.getElementById("play").addEventListener("click", function() {
        fetch("/play", {
            method: "POST",
            // ...add any other necessary options here
        })
            .then(response => response.json())
            .then(data => {
                // Update the pet's status on the page using the response data
                document.getElementById("pet-status").innerText = data.status;
            });
    });

    document.getElementById("groom").addEventListener("click", function() {
        fetch("/groom", {
            method: "POST",
            // ...add any other necessary options here
        })
            .then(response => response.json())
            .then(data => {
                // Update the pet's status on the page using the response data
                document.getElementById("pet-status").innerText = data.status;
            });
    });

    // Add event listeners for any other actions here
});
