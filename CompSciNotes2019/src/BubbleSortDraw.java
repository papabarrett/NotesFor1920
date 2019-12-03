
/**
 *
 * @author NAME
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.Random;

public class BubbleSortDraw implements ActionListener, KeyListener {

    javax.swing.Timer timer;
    JFrame frame;
    JPanel display;

    public void drawBlock(Graphics g) {
        for (int i = 0; i < reds.length; i++) {
            g.setColor(new Color(reds[i], 0, 0));
            g.fillRect((int) (i / Math.round(Math.sqrt(reds.length)) * 25), (int) (i % Math.round(Math.sqrt(reds.length)) * 25), 25, 25);
            g.setColor(new Color(255 - reds[i], 255 - reds[i], 0));
            g.drawString("" + reds[i], (int) (i / Math.round(Math.sqrt(reds.length)) * 25), (int) (i % Math.round(Math.sqrt(reds.length)) * 25 + 20));

        }
    }

    public static void main(String[] args) throws Exception {
        new BubbleSortDraw();
    }
    int[] reds;

    public BubbleSortDraw() {
        frame = new JFrame("Insert Title Here");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display = new DisplayPanel();
        frame.add(display);
        //put constructor code here
        reds = new int[250];
        Random r = new Random();
        for (int i = 0; i < reds.length; i++) {
            reds[i] = r.nextInt(250);
        }
        Runnable runnable = new Runnable() {
            public void run() {
                for (int j = 0; j < reds.length; j++) {
                    for (int i = 0; i < reds.length - j - 1; i++) {
                        if (reds[i] > reds[i + 1]) {
                            int temp = reds[i];
                            reds[i] = reds[i + 1];
                            reds[i + 1] = temp;
                        }
                        try {
                            Thread.sleep(10);
                        } catch (Exception e) {
                        }
                    }
                }
            }
        };
        Thread t=new Thread(runnable);
        t.start();

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

            drawBlock(g);

        }
    }
}
