/**
 *
 * @author NAME
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;

public class StarRunner implements ActionListener, KeyListener {

    javax.swing.Timer timer;
    JFrame frame;
    JPanel display;
    Ship picard;

    public static void main(String[] args) throws Exception {
        new StarRunner();
    }

    public StarRunner() {
        frame = new JFrame("Insert Title Here");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display = new DisplayPanel(); 
        frame.add(display);
        //put constructor code here
        picard=new Ship();
        
        
        
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
            picard.draw(g);
            
            
        }
    }
}