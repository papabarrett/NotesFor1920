/**
 *
 * @author NAME
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;

public class JungleScene implements ActionListener, KeyListener {

    javax.swing.Timer timer;
    JFrame frame;
    JPanel display;

    public static void main(String[] args) throws Exception {
        new JungleScene();
    }

    public JungleScene() {
        frame = new JFrame("Insert Title Here");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display = new DisplayPanel();
        frame.add(display);
        //put constructor code here
        
        
        
        
        //end your constructor code
        timer = new javax.swing.Timer(10, this);
      //  timer.start();
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
            setBackground(new Color(50,20,150));
            for (int i = 0; i < 10; i++) {
                
            randomTree(g);
            }
            
        }
        public void randomTree(Graphics g){
            int x=(int)(500*Math.random())-50;
            int width=(int)(100*Math.random()+50);
            g.setColor(new Color(141,73,22));
            g.fillRect(x+25, 75, width-50, 500);
            g.setColor(Color.black);
            g.drawRect(x+25, 75, width-50, 500);
            g.setColor(Color.green);
            g.fillOval(x,-5,width,200);
            g.setColor(Color.black);
            g.drawOval(x,-5,width,200);
            
        }
        
    }
}