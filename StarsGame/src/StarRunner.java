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
    boolean inc, dec;

    public static void main(String[] args) throws Exception {
        new StarRunner();
    }

    public StarRunner() {
        frame = new JFrame("Insert Title Here");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display = new DisplayPanel(); 
        frame.add(display);
        //put constructor code here
        picard=new Ship();
        inc=dec=false;
        
        
        //end your constructor code
        timer = new javax.swing.Timer(10, this);
        timer.start();
        frame.addKeyListener(this);
        frame.setFocusable(true);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        //type what needs to be performed every time the timer ticks
        if(inc)
            picard.increaseAngle();
        if(dec)
            picard.decreaseAngle();
        picard.move(display.getBounds());
        
        //end your code for timer tick code
        display.repaint();
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_A)
            inc=true;
        if(e.getKeyCode()==KeyEvent.VK_D)
            dec=true;
        if(e.getKeyCode()==KeyEvent.VK_W)
            picard.calculateSpeeds();
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
            System.exit(0);
        if(e.getKeyCode()==KeyEvent.VK_A)
            inc=false;
        if(e.getKeyCode()==KeyEvent.VK_D)
            dec=false;
    }

    class DisplayPanel extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //draw your graphics here
            setBackground(Color.BLACK);
            drawStars(g);
            picard.draw(g);
            
        }
        public void drawStars(Graphics g){
            if(getBounds().getWidth()<10) return;
            for (int i = 0; i < 100; i++) {
                
            g.setColor(Color.white);
            g.fillOval((int)(Math.random()*getBounds().getWidth()), 
                    (int)(Math.random()*getBounds().getWidth()), 3, 3);
            }
            
            
        }
    }
}