# Number Guessing Game 🎯

## Description

A Java Swing-based Number Guessing Game where players attempt to guess a randomly generated number between **1 and 100** within **5 attempts**.

The game provides helpful hints such as **Too High**, **Too Low**, and **Very Close**, while tracking the player's score and total games won.

---

## Features

- 🎲 Random number generation between 1 and 100
- 🔢 Maximum of 5 attempts per game
- 🏆 Score tracking system
- 🎯 Games Won counter
- 📈 "Too High" and "Too Low" hints
- 🔥 "Very Close" hint when the guess is within 5 numbers of the target
- 🔄 Restart Game functionality
- ✅ Input validation for invalid entries
- 🖥️ User-friendly Java Swing GUI

---

## Technologies Used

- Java
- Java Swing
- AWT Components
- Event Handling

---

## Project Structure

```text
NumberGuessingGame/
│
├── LikhithaBethu_Task2.java
└── README.md
```

---

## How to Run

### 1. Clone the Repository

```bash
git clone <repository-url>
```

### 2. Compile the Program

```bash
javac LikhithaBethu_Task2.java
```

### 3. Run the Program

```bash
java LikhithaBethu_Task2
```

---

## Game Rules

1. The system generates a random number between **1 and 100**.
2. The player gets **5 attempts** to guess the number.
3. After each incorrect guess:
   - 📉 **Too Low** if the guess is smaller than the target number.
   - 📈 **Too High** if the guess is greater than the target number.
   - 🔥 **Very Close** if the guess is within 5 numbers of the target.
4. If the player guesses correctly:
   - Score is awarded based on remaining attempts.
   - Games Won counter increases.
5. If all attempts are exhausted:
   - The correct number is revealed.
6. Click the **Restart** button to begin a new game.

---

## Scoring System

```text
Score = (Remaining Attempts + 1) × 10
```

### Examples

| Attempts Left | Score Earned |
|--------------|-------------|
| 4 | 50 |
| 3 | 40 |
| 2 | 30 |
| 1 | 20 |
| 0 | 10 |

---

## Learning Outcomes

This project helped me learn:

- Java Swing GUI development
- Event-driven programming
- Input validation and exception handling
- Random number generation
- GUI component handling using JFrame, JButton, JLabel, and JTextField
- Building interactive desktop applications in Java

---

## Author

* Likhitha Bethu 

---

⭐ If you like this project, consider giving it a star!
