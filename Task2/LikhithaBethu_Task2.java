import java.util.*;
import javax.swing.*;
import java.awt.*;

public class LikhithaBethu_Task2 {

    static int randomNumber = new Random().nextInt(100) + 1;
    static int attempts = 5;
    static int score = 0;
    static int gamesWon = 0;

    static JButton button;
    static JButton restartButton;

    static JTextField field;

    static JLabel resultLabel;
    static JLabel attemptsLabel;
    static JLabel scoreLabel;
    static JLabel gamesWonLabel;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Number Guessing Game");
        frame.setSize(450, 320);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("NUMBER GUESSING GAME");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBounds(90, 10, 300, 30);

        JLabel info = new JLabel("Guess a number between 1 and 100");
        info.setBounds(100, 40, 250, 20);

        resultLabel = new JLabel("You have 5 attempts.");
        resultLabel.setBounds(80, 65, 300, 25);

        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setBounds(50, 95, 100, 20);

        attemptsLabel = new JLabel("Attempts Left: 5");
        attemptsLabel.setBounds(170, 95, 150, 20);

        gamesWonLabel = new JLabel("Games Won: 0");
        gamesWonLabel.setBounds(320, 95, 120, 20);

        field = new JTextField();
        field.setBounds(150, 130, 120, 30);

        button = new JButton("Guess");
        button.setBounds(100, 180, 100, 35);

        restartButton = new JButton("Restart");
        restartButton.setBounds(230, 180, 100, 35);

        button.addActionListener(e -> guessNum());
        field.addActionListener(e -> guessNum());

        restartButton.addActionListener(e -> restartGame());

        frame.add(title);
        frame.add(info);
        frame.add(resultLabel);
        frame.add(scoreLabel);
        frame.add(attemptsLabel);
        frame.add(gamesWonLabel);
        frame.add(field);
        frame.add(button);
        frame.add(restartButton);

        frame.setVisible(true);
    }

    public static void guessNum() {

        int guess;

        try {
            guess = Integer.parseInt(field.getText().trim());
        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter a valid number.");
            clearInput();
            return;
        }

        if (guess < 1 || guess > 100) {
            resultLabel.setText("Enter a number between 1 and 100.");
            clearInput();
            return;
        }

        attempts--;
        attemptsLabel.setText("Attempts Left: " + attempts);

        if (guess == randomNumber) {

            score += (attempts + 1) * 10;
            gamesWon++;

            resultLabel.setText("Congratulations! You guessed correctly!");
            scoreLabel.setText("Score: " + score);
            gamesWonLabel.setText("Games Won: " + gamesWon);

            button.setEnabled(false);
            field.setEnabled(false);

        } else if (attempts == 0) {

            resultLabel.setText("Game Over! Number was " + randomNumber);

            button.setEnabled(false);
            field.setEnabled(false);

        } else if (guess < randomNumber) {

            if (Math.abs(guess - randomNumber) <= 5) {
                resultLabel.setText("Very close! Too low.");
            } else {
                resultLabel.setText("Too low!");
            }

        } else {

            if (Math.abs(guess - randomNumber) <= 5) {
                resultLabel.setText("Very close! Too high.");
            } else {
                resultLabel.setText("Too high!");
            }
        }

        clearInput();
    }

    public static void restartGame() {

        randomNumber = new Random().nextInt(100) + 1;
        attempts = 5;

        resultLabel.setText("You have 5 attempts.");
        attemptsLabel.setText("Attempts Left: 5");

        field.setEnabled(true);
        button.setEnabled(true);

        clearInput();
    }

    public static void clearInput() {
        field.setText("");
        field.requestFocus();
    }
}
