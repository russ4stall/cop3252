package hw5;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

/**
 * @author Russ Forstall
 */
public class Circles {
    public static void main( String args[] ) {
        JFrame frame = new JFrame( "Circles" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        float r = Float.parseFloat(JOptionPane.showInputDialog("Please input a radius"));
        int x = Integer.parseInt(JOptionPane.showInputDialog("Please input a x coordinate"));
        int y = Integer.parseInt(JOptionPane.showInputDialog("Please input a y coordinate"));

        CirclesJPanel panel = new CirclesJPanel(r, x, y);

        frame.add( panel );
        frame.setBackground( Color.WHITE );
        frame.setSize( 800, 600 );
        frame.setVisible( true );
    }
}

class CirclesJPanel extends JPanel {
    private float radius;
    private int x;
    private int y;

    private float diameter;
    private double circumference;
    private double area;

    public CirclesJPanel(float radius, int x, int y) {
        this.radius = radius;
        this.x = x;
        this.y = y;

        this.diameter = 2 * radius;
        this.circumference = 2 * Math.PI * radius;
        this.area = Math.PI * radius * radius;
    }

    public void paintComponent( Graphics g ) {
        Random random = new Random();
        super.paintComponent( g );

        Graphics2D g2d = ( Graphics2D ) g;
        Ellipse2D.Double circle = new Ellipse2D.Double(x - radius, y - radius, diameter, diameter);
        g2d.draw(circle);

        g2d.drawString(Float.toString(diameter), 10, getHeight() - 60);
        g2d.drawString(Double.toString(circumference), 10, getHeight() - 40);
        g2d.drawString(Double.toString(area), 10, getHeight() - 20);
    }
}
