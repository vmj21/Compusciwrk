// Define variables
let sequence = [];
let playerSequence = [];
let level = 0;
let gameStarted = false;
let interval = 1000;
let score = 0;
let highestScore = 0;
let responseTimer; // Timer for player response

// DOM elements
const startBtn = document.getElementById('start-btn');
const gameStatusIndicator = document.getElementById('game-status'); // Access the game status indicator
const scoreBtn = document.getElementById('score-btn');
const highestScoreBtn = document.getElementById('highest-score-btn');

// Function to start the game
function startGame() {
    if (!gameStarted) {
        gameStarted = true;
        startBtn.disabled = true;
        gameStatusIndicator.className = 'game-status-green'; // Change to GREEN
        setTimeout(playSequence, 3000); // Start the sequence after 3 seconds
    }
}

// Function to initiate the game sequence
function playSequence() {
    if(gameStarted) {
        level++; // Increase level
        sequence.push(getRandomColor()); // Add a new color to the sequence
        playerSequence = []; // Reset player's sequence for the new round
        showSequence(); // Display the sequence to the player
    }
}

// Function to reset the game status indicator
function resetGameStatusIndicator() {
    gameStatusIndicator.className = 'game-status-red'; // Change back to RED
}

// Modified function to show the sequence
function showSequence() {
    let i = 0;
    const intervalId = setInterval(() => {
        flashButton(sequence[i]);
        i++;
        if (i >= sequence.length) {
            clearInterval(intervalId);
            startResponseTimer(); // Start the timer for player response after showing the sequence
        }
    }, interval);
}

// Start the 5-second response timer
function startResponseTimer() {
    clearTimeout(responseTimer); // Clear existing timer to prevent duplicates
    responseTimer = setTimeout(() => {
        endGame(); // End the game if the player fails to respond in time
    }, 5000); // 5 seconds limit
}

// Function to flash a specific button
function flashButton(buttonId) {
    const button = document.getElementById(buttonId);
    if (button) {
        button.classList.add('active'); // Add a class that makes the button "flash"
        setTimeout(() => {
            button.classList.remove('active'); // Remove the class to end the "flash" effect
        }, 500); // Adjust the duration as needed
    }
}

// Function to generate a random color
function getRandomColor() {
    const colors = ['green', 'red', 'yellow', 'blue'];
    const randomIndex = Math.floor(Math.random() * colors.length);
    return colors[randomIndex];
}

// Function to check player's sequence
function checkSequence() {
    clearTimeout(responseTimer); // Stop the timer since the player has responded
    let currentMoveIndex = playerSequence.length - 1;
    if (sequence[currentMoveIndex] !== playerSequence[currentMoveIndex]) {
        endGame();
        return;
    }

    // Check if the player has completed the current sequence
    if (playerSequence.length === sequence.length) {
        score++;
        scoreBtn.innerHTML = "Score: " + score;

        if (score > highestScore) {
            highestScore = score;
            highestScoreBtn.innerHTML = "Highest Score: " + highestScore;
        }

        if (score === 5 || score === 9 || score === 13) {
            interval -= 100; // Increase difficulty by reducing interval time
        }

        setTimeout(playSequence, 1000); // Move to the next round after a short delay
    }
}

// Function to end the game
function endGame() {
    alert("Game Over! Your score was: " + score);
    resetGame(); // Reset the game state and update the UI accordingly
    flashAllButtons(); // Flash all buttons five times
}

// Function to reset the game state
function resetGame() {
    sequence = [];
    playerSequence = [];
    level = 0;
    gameStarted = false;
    score = 0;
    interval = 1000;
    startBtn.disabled = false; // Enable the START button for the next game
    resetGameStatusIndicator(); // Reset game status to RED
    scoreBtn.innerHTML = "Score: " + score; // Reset score display
    // Reset any other UI elements as needed
}

// Function to flash all buttons
function flashAllButtons() {
    const colors = ['green', 'red', 'yellow', 'blue']; // Assuming these are your color button IDs
    for (let i = 0; i < 5; i++) { // Flash 5 times
        setTimeout(() => {
            colors.forEach(color => {
                flashButton(color);
            });
        }, i * 1000); // Adjust timing as necessary
    }
}

// Event listener for the green button
document.getElementById('green').addEventListener('click', function() {
    if (gameStarted) {
        playerSequence.push('green'); // Add 'green' to the player's sequence
        checkSequence(); // Call to check if the player's sequence is correct
    }
});

// Event listener for the red button
document.getElementById('red').addEventListener('click', function() {
    if (gameStarted) {
        playerSequence.push('red'); // Add 'red' to the player's sequence
        checkSequence(); // Call to check if the player's sequence is correct
    }
});

// Event listener for the blue button
document.getElementById('blue').addEventListener('click', function() {
    if (gameStarted) {
        playerSequence.push('blue'); // Add 'blue' to the player's sequence
        checkSequence(); // Call to check if the player's sequence is correct
    }
});

// Event listener for the yellow button
document.getElementById('yellow').addEventListener('click', function() {
    if (gameStarted) {
        playerSequence.push('yellow'); // Add 'yellow' to the player's sequence
        checkSequence(); // Call to check if the player's sequence is correct
    }
});
