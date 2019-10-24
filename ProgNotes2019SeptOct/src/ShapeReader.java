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

public class ShapeReader implements ActionListener, KeyListener {

    javax.swing.Timer timer;
    JFrame frame;
    JPanel display;

    public static void main(String[] args) throws Exception {
        new ShapeReader();
    }

    public ShapeReader() {
        frame = new JFrame("Insert Title Here");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display = new DisplayPanel();
        frame.add(display);
        //put constructor code here
        
        
        
        
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
            try {
                Scanner scan=new Scanner(new File("shape.txt"));
                Polygon p=new Polygon();
                while(scan.hasNext()){
                    int x1=scan.nextInt(), y1=scan.nextInt();   
                    if(x1>0){
                        p.addPoint(x1, y1);
                    }
                    else{
                        g.setColor(Color.black);
                        if(y1==1)
                            g.setColor(Color.red);
                        if(y1==2)
                            g.setColor(Color.green);
                        if(y1==3)
                            g.setColor(Color.blue);
                        if(y1==4)
                            g.setColor(Color.white);
                        g.drawPolygon(p);
                        p=new Polygon();
                    }
                }
            } catch (Exception e) {
            }   
        }
    }
}