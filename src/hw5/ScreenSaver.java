package hw5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.Random;

/**
 * @author Russ Forstall
 */
public class ScreenSaver {
    // execute application
    public static void main( String args[] ) {
        JFrame frame = new JFrame( "Screen Saver" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        LineJPanel panel = new LineJPanel();
        frame.add( panel );
        frame.setSize( 300, 300 ); // set frame size
        frame.setVisible( true ); // display frame
    }
}

class LineJPanel extends JPanel implements ActionListener
{
    private int delay = 10;
    protected Timer timer;

    public LineJPanel() {
        timer = new Timer(delay, this);
        timer.start();		// start the timer
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    // draw rectangles and arcs
    public void paintComponent( Graphics g ) {
        super.paintComponent( g ); // call superclass's paintComponent
        Graphics2D g2d = ( Graphics2D ) g;
        g2d.setColor(Color.red);
        g2d.setStroke(new BasicStroke(10));

        Random random = new Random();

        Line2D.Double line = new Line2D.Double(20, 22, 40, 42);
        g2d.draw(line);
    }


}
