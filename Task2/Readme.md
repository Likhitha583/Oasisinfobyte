Number Guessing Game 🎯

Description

A simple Java Swing-based Number Guessing Game where the player has to guess a randomly generated number between 1 and 100 within 5 attempts.

The game provides hints if the guess is too high, too low, or very close to the correct number. Players earn points based on the number of attempts remaining when they guess correctly.

---

Features

- Random number generation between 1 and 100
- Maximum of 5 attempts per game
- Score tracking system
- Games won counter
- "Too High" and "Too Low" hints
- "Very Close" hint when the guess is within 5 numbers of the target
- Restart game functionality
- Input validation for invalid entries
- User-friendly Java Swing GUI

---

Technologies Used

- Java
- Java Swing (GUI)
- AWT Components

---

How to Run

1. Clone or download the project.
2. Open the project in your preferred Java IDE (Eclipse, IntelliJ IDEA, VS Code, etc.).
3. Compile the file:

javac LikhithaBethu_Task2.java

4. Run the program:

java LikhithaBethu_Task2

---

Game Rules

1. The system generates a random number between 1 and 100.
2. The player gets 5 attempts to guess the number.
3. After each incorrect guess:
   - "Too High" is displayed if the guess is greater than the target.
   - "Too Low" is displayed if the guess is smaller than the target.
   - "Very Close" is displayed if the guess is within 5 numbers of the target.
4. If the player guesses correctly:
   - Points are awarded based on remaining attempts.
   - Games Won counter increases.
5. If all attempts are used:
   - The correct number is displayed.
6. Click the Restart button to start a new game.

---

Scoring System

Score = (Remaining Attempts + 1) × 10

Example:

- Correct guess with 4 attempts left → 50 points
- Correct guess with 2 attempts left → 30 points

---

Author
Likhitha Bethu
