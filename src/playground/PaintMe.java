package playground;

import javax.swing.*;
import java.awt.*;

/**
 * @author Russ Forstall
 */
public class PaintMe {

    public static void main(String[] args) {

        JFrame frame = new JFrame("My Title");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(100, 100));
        frame.setMaximumSize(new Dimension(600, 600));
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setSize(new Dimension(500, 500));

        /*frame.add(new Component() {
            this.
        });*/

        frame.setVisible(true);
    }
}
