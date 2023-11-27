Name - Sameep Singh
STUDENT ID - 1213365

Resources used - Lecture Slides, Youtube video tutorial on swing - https://www.youtube.com/live/6zm8c6QFmjo?si=CKVOcnnjKABSlftZ 

# Mancala Game Project

This project implements a Java-based version of the Mancala game, utilizing Object-Oriented Programming principles and the Swing framework for the graphical user interface (GUI). The project consists of several key components, each residing in its own Java file, contributing to the functionality of the game.

## Project Structure

- `MancalaGame.java`: The core class that handles the game logic. It manages the game state, including the current positions of stones in pits and stores, as well as player turns.

- `AyoRules.java` & `KalahRules.java`: These classes extend the game rules specific to different variations of Mancala, such as "Ayo" and "Kalah". They define the rules and movements unique to each game variant.

- `MancalaDataStructure.java`: This class is responsible for the data structure used in the game, managing the layout of pits and stores, and tracking the number of stones in each.

- `Player.java`: Represents a player in the game, holding information such as the player's score and current status in the game.

- `InvalidMoveException.java`: A custom exception class used to handle invalid moves within the game.

- `TextUI.java`: The main class for the user interface. It extends `JFrame` and sets up the GUI for the Mancala game. This class includes methods to display the initial game options and render the game board.

## GUI Aspect

The GUI is built using Swing and is primarily managed in the `TextUI.java` file. The interface includes:

- **Initial Options Panel**: Upon launching the application, a panel with four options ("Ayo", "Kalah", "Load Game", "Quit") is displayed. This allows the user to select the game type or load a previous game.

- **Game Board**: Once a game type is selected, the panel transitions to display the Mancala game board. This includes a series of buttons representing pits on both sides of the game board and larger buttons at each end representing the stores.

- **Interactive Pits**: Each pit is represented by a button that players can interact with to make their moves during the game.

- **Dynamic Updates**: The game board updates dynamically based on player actions, reflecting the current state of the game.

## Running the Project

To run the project:

1. Ensure Java is installed on your system.
2. Compile the Java files in the project directory.
3. Run the `TextUI.java` file to start the game.




