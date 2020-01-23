/**
 *
 * @author NAME
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main implements ActionListener, KeyListener {

    javax.swing.Timer timer;
    JFrame frame;
    JPanel display;
    ArrayList<SizeCircle> list;

    public static void main(String[] args) throws Exception {
        new Main();
    }

    public Main() {
        frame = new JFrame("Insert Title Here");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display = new DisplayPanel();
        frame.add(display);
        //put constructor code here
        list=new ArrayList<SizeCircle>();
        Random randy=new Random();
        for (int i = 0; i < 10; i++) {
            list.add(new SizeCircle(randy.nextInt(500),randy.nextInt(500),randy.nextInt(100)));
        }
        Collections.sort(list); //Only works because I wrote compareTo in SizeCircle
        
        
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
            for (int i = 0; i < list.size(); i++) {
                SizeCircle circle = list.get(i);
                circle.draw(g);                
            }
            
            
        }
    }
}