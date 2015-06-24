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
    public static void main( String args[] ) {
        JFrame frame = new JFrame("Screen Saver");
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        LineJPanel panel = new LineJPanel();
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}

class LineJPanel extends JPanel implements ActionListener
{
    private int delay = 1000;
    protected Timer timer;

    public LineJPanel() {
        timer = new Timer(delay, this);
        timer.start();		// start the timer
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Random random = new Random();

        for (int i = 0; i < 100; i++){
            g2d.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            g2d.setStroke(new BasicStroke(random.nextInt(20) + 1));
            int x1 = random.nextInt(getWidth());
            int x2 = random.nextInt(getWidth());
            int y1 = random.nextInt(getHeight());
            int y2 = random.nextInt(getHeight());
            Line2D.Double line = new Line2D.Double(x1, y1, x2, y2);
            g2d.draw(line);
        }
    }
}
