package hw6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Guess {
    private int number;
    private int previousGuess;
    private JFrame frame;
    private JLabel statusLabel;
    private JLabel guessLabel;
    private JPanel panel;
    private JTextField userGuessField;

    public Guess() {
        init();
    }

    public static void main(String[] args) {
        Guess guess = new Guess();
        guess.guess();
    }

    private void init() {
        number = new Random().nextInt(999) + 1;

        frame = new JFrame("Guess");
        frame.setSize(700, 100);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        statusLabel = new JLabel("", JLabel.CENTER);

        statusLabel.setSize(350, 100);

        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        frame.add(panel);
        //frame.add(statusLabel);
        frame.setVisible(true);
    }

    private void guess() {

        guessLabel = new JLabel("I have a number between 1 and 1000. Can you guess my number?");
        userGuessField = new JTextField(4);

        userGuessField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "Guess: " + userGuessField.getText();
                int guess = Integer.parseInt(userGuessField.getText());
                guessAction(guess);
            }
        });

        panel.add(guessLabel);
        panel.add(userGuessField);
        panel.add(statusLabel);
        frame.setVisible(true);
    }

    private void guessAction(int guess) {
        int currentDiff = Math.abs(guess - number);
        int previousDiff = Math.abs(previousGuess - number);

        if (guess == number) {
            statusLabel.setText("CORRECT!");
            winAction();
        } else {
            if (currentDiff > previousDiff) {
                frame.setBackground(Color.RED);
                panel.setBackground(Color.RED);
            } else if (currentDiff < previousDiff) {
                frame.setBackground(Color.BLUE);
                panel.setBackground(Color.BLUE);
            } else {
                frame.setBackground(Color.WHITE);
                panel.setBackground(Color.WHITE);
            }

            if (guess < number) {
                statusLabel.setText("Too Low");
            } else {
                statusLabel.setText("Too High");
            }
        }

        previousGuess = guess;
    }

    private void winAction() {
        userGuessField.setEditable(false);
        final JButton playAgainButton = new JButton("Play Again");
        guessLabel.setText("");
        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                userGuessField.setEditable(true);
                frame.setBackground(Color.WHITE);
                panel.setBackground(Color.WHITE);
                number = new Random().nextInt(999) + 1;
                panel.remove(playAgainButton);
                statusLabel.setText("");
                guessLabel.setText("I have a number between 1 and 1000. Can you guess my number?");
            }
        });
        panel.add(playAgainButton);
    }
}