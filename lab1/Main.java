package com.company;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.AffineTransform;


public class Main extends JPanel {

    //------- For drawing ONLY while paintComponent is being executed! --------

    private Graphics2D g2; // A copy of the graphics context from paintComponent.

    /**
     * Removes any transformations that have been applied to g2, so that
     * it is back to the standard default coordinate system.
     */
    private void resetTransform() {
        g2.setTransform(new AffineTransform());
    }


    void square() {
        g2.fillRect(-50,-50,100,100);
    }


    //-----------------------------------------------------------------------------------


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // TODO Draw the required image, using ONLY the four methods defined above,
        // along with g2.setColor, g1.scale, g2.translate, and g2.rotate.

        /* ----------------------------------------------------------------------- */

        // REMOVE THE FOLLOWING CODE, which draws a big red X in the upper right quadrant,
        // and insert your own code to draw the required pictures in the four quadrants.

        // The next two line scale the X to be twice the original size
        // and then moves the center of the X from (0,0) to (450,150).

        g2.translate(300,200);


        // Set the drawing color to red.

        g2.setColor(Color.RED);

        // The next three lines draw a tilted rectangle centered at (0,0).

        g2.rotate(Math.PI/1);
        g2.scale(2.25,0.15);
        square();

        resetTransform();
        g2.translate(300,300);
        g2.rotate(-Math.PI/4.5);
        g2.scale(2.9,0.15);
        square();

        resetTransform();
        g2.translate(300,400);
        g2.rotate(Math.PI/1);
        g2.scale(2.25,0.15);
        square();






        resetTransform();

        /* ----------------------------------------------------------------------- */

    } // end paintComponent()


    //--------------------------------------------------------------------------------------

    public Main() {
        setPreferredSize(new Dimension(600,600) );
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
    }

    public static void main(String[] args)  {
        JFrame window = new JFrame("Drawing With Transforms");
        window.setContentPane(new Main());
        window.pack();
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation( (screen.width - window.getWidth())/2, (screen.height - window.getHeight())/2 );
        window.setVisible(true);
    }

}
