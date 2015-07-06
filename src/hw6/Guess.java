package hw6;

import hw2.IntegerSet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Guess {
    private int number;
    private JFrame frame;
    private JLabel statusLabel;
    private JPanel panel;

    public Guess(){
        init();
    }

    public static void main(String[] args){
        Guess guess = new Guess();
        guess.guess();
    }

    private void init(){
        number = new Random().nextInt(999) + 1;

        frame = new JFrame("Guess");
        frame.setSize(400,400);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        statusLabel = new JLabel("",JLabel.CENTER);

        statusLabel.setSize(350,100);

        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        frame.add(panel);
        frame.add(statusLabel);
        frame.setVisible(true);
    }

    private void guess(){

        JLabel guessLabel= new JLabel("Guess: ", JLabel.RIGHT);
        final JTextField userGuessField = new JTextField(4);

        userGuessField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "Guess: " + userGuessField.getText();
                int guess = Integer.parseInt( userGuessField.getText());
                int guessResult = guessAction(guess);
                if (  guessResult > 0 ) {
                    // warmer
                } else if( )

                statusLabel.setText(data);
                frame.setBackground(Color.RED);
            }
        });

        panel.add(guessLabel);
        panel.add(userGuessField);
        frame.setVisible(true);
    }

    private int guessAction(int guess) {


        return 1;
    }
}