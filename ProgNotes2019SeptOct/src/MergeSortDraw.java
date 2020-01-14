
/**
 *
 * @author NAME
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.Random;

public class MergeSortDraw implements ActionListener, KeyListener {

    javax.swing.Timer timer;
    JFrame frame;
    JPanel display;
    final static int BOX_NUM = 800;
    final static int DELAY = 10;
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
        new MergeSortDraw();
    }

    public MergeSortDraw() {
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
                
                    

                sort(reds);
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
    public void sort(int inputArr[]) {
        doMergeSort(inputArr, 0, inputArr.length - 1);
    }
 
    private void doMergeSort(int inputArr[], int lowerIndex, int higherIndex) {
         
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(inputArr, lowerIndex, middle);
            try {
                        Thread.sleep(DELAY);
                    } catch (Exception e) {
                    }
            // Below step sorts the right side of the array
            doMergeSort(inputArr, middle + 1, higherIndex);
            try {
                        Thread.sleep(DELAY);
                    } catch (Exception e) {
                    }
            // Now merge both sides
            mergeParts(inputArr, lowerIndex, middle, higherIndex);
            try {
                        Thread.sleep(DELAY);
                    } catch (Exception e) {
                    }
        }
    }
 
    private void mergeParts(int array[], int lowerIndex, int middle, int higherIndex) {
            int[] tempMergArr=new int[array.length];
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
 
    }
}
