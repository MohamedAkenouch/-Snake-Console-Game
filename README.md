Snake Console Game
This project aims to recreate the classic game "Snake" in console mode. The game is divided into 11 classes, each serving a specific purpose in achieving this objective. Below is a detailed description of each class and its contents.

Classes Overview
1. Gamescreen
The Gamescreen class prepares the game board where the snake will move. It reserves a limited empty space surrounded by walls. The game board is represented using static arrays with fixed dimensions (length and width). Empty spaces are denoted by the character ' '. The method ClearScreenLocation(int x, int y) is used to clear the previous position whenever the fruit changes location.

2. Snake
The Snake class defines the snake entity, inheriting from the GameObject class. It has a single constructor to position the snake on the game board. It contains methods (moveLeft, moveRight, moveUp, moveDown) for moving the snake within the game board and the isDie method to check if the snake has collided with the walls or itself. The movement logic involves shifting the positions of the snake segments in the direction of movement.

3. Fruit
Fruit is an extension of the GameObject class responsible for generating new fruit locations each time the snake consumes a fruit. Random coordinates are generated using Java's Random class for placing the fruit at random locations on the game board.

4. Mur
Mur is another extension of GameObject used to display the enclosing walls of the game screen.

Multithreading
Multithreading plays a crucial role in the project, allowing simultaneous execution of different components. Five thread classes are created:

Four threads handle movement in each direction. They also manage the snake's growth by one unit if it consumes a fruit using the add method of ArrayList and display a new fruit on the screen using the addRandomFruit method of the Fruit class.
The fifth thread enables player input. It ensures that the player can re-enter the input if an incorrect value is entered.
Game Operation
During gameplay, the thread responsible for receiving player inputs runs continuously. Based on the input character provided by the player (to move the snake), the corresponding thread execution begins. For instance, if the player enters 'd' to move the snake right, the thread responsible for moving the snake in that direction will execute until the player enters another character ('g' for left, 'h' for up, 'b' for down).
