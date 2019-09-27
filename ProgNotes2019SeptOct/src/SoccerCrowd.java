
/**
 *
 * @author NAME
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;

public class SoccerCrowd implements ActionListener, KeyListener {

    javax.swing.Timer timer;
    JFrame frame;
    JPanel display;

    public static void main(String[] args) throws Exception {
        new SoccerCrowd();
    }

    public SoccerCrowd() {
        frame = new JFrame("Insert Title Here");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display = new DisplayPanel();
        frame.add(display);
        //put constructor code here

        //end your constructor code
        timer = new javax.swing.Timer(10, this);
        // timer.start();
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

        int down = 14;

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //draw your graphics here
            for (int i = 0; i < 1000; i++) {
                drawPerson(g);
            }
        }

        public void drawPerson(Graphics g) {
            g.setColor(new Color((int) (255 * Math.random()),
                    (int) (255 * Math.random()), (int) (255 * Math.random())));
            int xBody = (int) (Math.random() * 75) + 100;
            g.fillRect(xBody, down, 10, 25);
            g.setColor(new Color((int) (55 * Math.random()) + 200,
                    (int) (30 * Math.random()) + 180, 128));
            g.fillOval(xBody, down - 10, 10, 10);
            if (Math.random() < .25) {
                down++;
            }
        }

    }
}
