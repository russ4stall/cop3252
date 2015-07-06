package hw6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * @author Russ Forstall
 */
public class GuessPanel extends JPanel {

    private JTextField guessTextField;

    public void paintComponent( Graphics g ) {
        Random random = new Random();
        super.paintComponent( g );

        Graphics2D g2d = ( Graphics2D ) g;

    }

    private class GuessTextFieldHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String s = "";
            // user pressed Enter in guessTextField
            if ( event.getSource() == guessTextField ) {
                s = String.format( "textField1: %s", event.getActionCommand() );
            }

            JOptionPane.showMessageDialog( null, s );
            //paintComponent(g);

        }
    }
}
