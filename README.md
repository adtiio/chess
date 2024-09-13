
# Multiplayer Chess Game

This is a real-time multiplayer chess game built with **Java Spring Boot** and **WebSockets**. The project allows multiple users to play chess against each other in real time, handling all the game logic, piece movements, and user sessions efficiently using Spring Boot's WebSocket capabilities.

![Screenshot 2024-09-13 213105](https://github.com/user-attachments/assets/8f88fc33-e6fe-4c9c-b4dc-3aec544b8581)
![Screenshot 2024-09-13 213917](https://github.com/user-attachments/assets/08e1ed70-b1d6-4025-95da-5eb738d686a0)

## Technologies Used

- **Java 17+**: For writing the backend logic.
- **Spring Boot**: Used for building the web application and handling RESTful APIs.
- **WebSockets**: For establishing real-time communication between clients (players).
- **Maven**: For dependency management and project build lifecycle.
- **HTML5, CSS3, JavaScript**: Frontend technologies for creating the user interface of the chess game.
- **Thymeleaf**: Template engine for rendering dynamic HTML pages.
- **Stomp.js**: JavaScript library used on the client-side for WebSocket communication.

## Features

- **Real-time Multiplayer Chess**: Players can play against each other in real time.
- **Session Management**: Tracks players’ sessions and allows them to join, leave, and reconnect to the game.
- **Turn-based system**: The game enforces turn-based rules for chess.
- **Move Validation**: The system checks the validity of each player's move before executing it.
- **Visual Chessboard**: A dynamic chessboard UI that updates in real-time based on player moves.
- **Endgame detection**: The system detects check, checkmate, stalemate, and other endgame scenarios.

## Prerequisites

Before running this project, make sure you have the following installed:

- **Java 17 or later**
- **Maven**

## Installation

1. **Clone the repository:**

   ```bash
       git clone https://github.com/adtiio/chess.git

2. **Navigate to the project directory:**
   ```bash
       cd chess
3. **Build the project using Maven:**
   ```bash
       mvn clean install
4. **Run the application:**
   ```bash
       mvn spring-boot:run
5. **Open the game in your browser:**
    ```bash
      http://localhost:8081/
