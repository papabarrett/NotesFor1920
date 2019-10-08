
/**
 *
 * @author NAME
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;

public class CitySkyline implements ActionListener, KeyListener {

    javax.swing.Timer timer;
    JFrame frame;
    JPanel display;
    int a;

    public static void main(String[] args) throws Exception {
        new CitySkyline();
    }

    public CitySkyline() {
        a=0;
        frame = new JFrame("Insert Title Here");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display = new DisplayPanel();
        frame.add(display);
        //put constructor code here
        //end your constructor code
        System.out.println("b");
    //    timer = new javax.swing.Timer(10, this);
        System.out.println("c");
        // timer.start();
        frame.addKeyListener(this);
        System.out.println("d");
        frame.setFocusable(true);
        System.out.println("e");
        frame.setVisible(true);
        System.out.println("f");
    }

    public void actionPerformed(ActionEvent e) {
        //type what needs to be performed every time the timer ticks
        //end your code for timer tick code
System.out.println(a++);
        display.repaint();
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
        System.exit(0);
    }

    class DisplayPanel extends JPanel {

        final int STREET_LEVEL = 730;
        final int STREET_WIDTH = 20;

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //draw your graphics here
            int x = 50;
            setBackground(new Color(24, 21, 62));
            g.setColor(Color.white);
            g.fillOval(10, 10, 20, 20);
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(0, STREET_LEVEL, 5000, STREET_WIDTH);

            while (x < 400) {
                x = drawBuilding(g, x);
            }
            g.setColor(Color.red);
            g.drawRect(0, 0, 800, 800);
            g.drawImage(smiley, 5, 5, 50, 50, null);
        }
Image smiley=new ImageIcon("smiley.jpg").getImage();
        public int drawBuilding(Graphics g, int x) {
            int width = (int) (Math.random() * 101 + 50);//from 50 to 150
            int height = (int) (Math.random() * STREET_LEVEL * .5 + STREET_LEVEL * .25);
            Color buidling = new Color((int) (Math.random() * 255),
                    (int) (Math.random() * 255), (int) (Math.random() * 255));
            g.setColor(buidling);
            int yBuilding = STREET_LEVEL - height;
            g.fillRect(x, yBuilding, width, height);
            x += width;
            return x;
        }
    }
}
