package hw5;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.Random;
import javax.swing.*;

public class Triangles
{
    public static void main( String args[] ) {
        JFrame frame = new JFrame( "Triangles" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        TrianglesJPanel panel = new TrianglesJPanel();

        frame.add( panel );
        frame.setBackground( Color.WHITE );
        frame.setSize( 500, 500 );
        frame.setVisible( true );
    }
}

class TrianglesJPanel extends JPanel {
    public void paintComponent( Graphics g ) {
        Random random = new Random();
        super.paintComponent( g );

        Graphics2D g2d = ( Graphics2D ) g;
        Dimension dim = getSize();

        for (int i = 0; i < 5; i++) {
            GeneralPath triangle = new GeneralPath();
            triangle.moveTo(random.nextInt(dim.width), random.nextInt(dim.height));
            triangle.lineTo(random.nextInt(dim.width), random.nextInt(dim.height));
            triangle.lineTo(random.nextInt(dim.width), random.nextInt(dim.height));
            triangle.closePath();
            g2d.setColor(new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
            g2d.fill(triangle);
            g2d.draw(triangle);
        }
    }
}