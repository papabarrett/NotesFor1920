/**
 *
 * @author NAME
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;

public class LearningGraphics implements ActionListener, KeyListener {

    javax.swing.Timer timer;
    JFrame frame;
    JPanel display;

    public static void main(String[] args) throws Exception {
        new LearningGraphics();
    }

    public LearningGraphics() {
        frame = new JFrame("Insert Title Here");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display = new DisplayPanel();
        frame.add(display);
        //put constructor code here
        
        
        
        
        //end your constructor code
        timer = new javax.swing.Timer(10, this);
        timer.start();
        frame.addKeyListener(this);
        frame.setFocusable(true);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        //type what needs to be performed every time the timer ticks
        
        
        //end your code for timer tick code
        display.repaint();
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    class DisplayPanel extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //draw your graphics here
            setBackground(Color.BLACK);
            g.setColor(Color.pink);
            g.drawLine(0, 50, 100, 150);  //your notes here
            g.setColor(Color.CYAN);
            g.drawRect(200, 100, 75, 25);
            g.fillRect(400, 100, 50, 50);
            g.setColor(Color.MAGENTA);
            g.drawOval(200, 100, 75, 25);
            g.fillOval(400, 175, 50, 50);
            g.setColor(Color.orange); 
            g.drawArc(200, 200, 75, 25, 190, 160);
            g.fillArc(400, 275, 50, 50, 45, 75);
            Polygon triangle=new Polygon();
            triangle.addPoint(300, 25);
            triangle.addPoint(350, 75);
            triangle.addPoint(400, 25);
            g.drawPolygon(triangle);
            triangle.translate(-200, 250);
            g.fillPolygon(triangle);
            Color betterBlue=new Color(31,52,152);  //3 nums are RGB
            g.setColor(betterBlue);
            g.fillOval(325, 40, 30, 30);
            Color bloodRed=new Color(166,17,32,100); //4th is alpha
                    //alpha determines if its see through
                    //0 is transparent, 255 is opaque
            g.setColor(bloodRed);
            g.fillRect(50, 50, 300, 400);
        }
    }
}