
/**
 *
 * @author NAME
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.Arrays;
import java.util.Random;

public class SelectionSortDraw implements ActionListener, KeyListener {

    javax.swing.Timer timer;
    JFrame frame;
    final static int BOX_NUM = 1000;
    final static int DELAY = 70;
    JPanel display;
    int[] reds;

    public void drawBlock(Graphics g) {
        for (int i = 0; i < reds.length; i++) {
            g.setColor(new Color(reds[i], 0, 0));
            g.fillRect((int) (i / Math.round(Math.sqrt(reds.length)) * 25), (int) (i % Math.round(Math.sqrt(reds.length)) * 25), 25, 25);
            g.setColor(new Color(255 - reds[i], 255 - reds[i], 0));
            g.drawString("" + reds[i], (int) (i / Math.round(Math.sqrt(reds.length)) * 25), (int) (i % Math.round(Math.sqrt(reds.length)) * 25 + 20));

        }
    }

    public static void main(String[] args) throws Exception {
        new SelectionSortDraw();
    }

    public SelectionSortDraw() {
        frame = new JFrame("Insert Title Here");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display = new DisplayPanel();
        frame.add(display);
        //put constructor code here

        reds = new int[BOX_NUM];
        Random r = new Random();
        for (int i = 0; i < reds.length; i++) {
            reds[i] = r.nextInt(250);
        }
        Runnable runnable = new Runnable() {
            public void run() {
                for (int i = 0; i < reds.length; i++) {
                    int minIndex = i;
                    for (int j = i + 1; j < reds.length; j++) {
                        if (reds[j] < reds[minIndex]) {
                            minIndex = j;
                        }
                    }
                    int temp = reds[i];
                    reds[i] = reds[minIndex];
                    reds[minIndex] = temp;
                    try {
                        Thread.sleep(DELAY);
                    } catch (Exception e) {
                    }

                }
            }
        };
        Thread t = new Thread(runnable);
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
