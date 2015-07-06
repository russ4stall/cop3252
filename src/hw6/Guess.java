package hw6;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

/**
 * @author Russ Forstall
 */
public class Guess {
    public static void main( String args[] ) {
        Random random = new Random();
        int num = random.nextInt(999) + 1;

        JFrame frame = new JFrame("Guess");
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 100); // set frame size
        frame.setBackground(Color.WHITE);

        GuessPanel guessPanel = new GuessPanel();
        frame.add(guessPanel);

        frame.setVisible(true); // display frame

    }
}

