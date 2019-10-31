/**
 *
 * @author NAME
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.lang.*;
import java.util.Scanner;

public class MapDisplay implements ActionListener, KeyListener {

    javax.swing.Timer timer;
    JFrame frame;
    JPanel display;
    int tileWidth=1, tileHeight=1;

    public static void main(String[] args) throws Exception {
        new MapDisplay();
    }

    public MapDisplay() {
        frame = new JFrame("Insert Title Here");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
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
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
            System.exit(0);
    }

    class DisplayPanel extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //draw your graphics here
            try {
                Scanner scan=new Scanner(new File("map.txt"));
                int rows=0, cols=0;
                while(scan.hasNext()){
                    cols=scan.next().length();
                    rows++;
                }
                tileHeight=getHeight()/rows+1;
                tileWidth=getWidth()/cols+1;
                setBackground(new Color(239,211,136));
                scan=new Scanner(new File("map.txt"));
                int r=0;
                while(scan.hasNext()){
                    String line=scan.next();
                    for (int i = 0; i < line.length(); i++) {
                        if(line.charAt(i)=='t'){
                            g.setColor(new Color(82,64,10));
                            g.fillRect(i*tileWidth+3, r*tileHeight+7, tileWidth-6, tileHeight);
                            g.setColor(Color.GREEN);
                            g.fillOval(i*tileWidth, r*tileHeight, tileWidth, tileHeight);
                        }
                        if(line.charAt(i)=='r'){
                            g.setColor(new Color(244,233,11));
                            g.fillRect(i*tileWidth, r*tileHeight, tileWidth, tileHeight);
                            g.setColor(Color.gray);
                            g.drawRect(i*tileWidth, r*tileHeight, tileWidth, tileHeight);
                        }
                    }
                    r++;
                }
            } catch (Exception e) {
            }
            
            
        }
    }
}