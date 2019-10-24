
/**
 *
 * @author NAME
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.*;

public class ShapeCreator implements ActionListener, KeyListener, MouseListener {

    javax.swing.Timer timer;
    JFrame frame;
    JPanel display;
    PrintWriter out;

    public static void main(String[] args) throws Exception {
        new ShapeCreator();
    }

    public ShapeCreator() {
        frame = new JFrame("Insert Title Here");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display = new DisplayPanel();
        frame.add(display);
        //put constructor code here
        try {
            File file = new File("shape.txt");
            file.createNewFile();
            out=new PrintWriter(new FileWriter(file,true));

        } catch (Exception e) {
        }

        //end your constructor code
        timer = new javax.swing.Timer(10, this);
        timer.start();
        frame.addKeyListener(this);
        frame.addMouseListener(this);
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
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
            out.close();
            System.exit(0);
        }
        if(e.getKeyCode()==KeyEvent.VK_R){
            out.println("-1 1");
            out.flush();
        }
        if(e.getKeyCode()==KeyEvent.VK_G){
            out.println("-1 2");
            out.flush();
        }
        if(e.getKeyCode()==KeyEvent.VK_B){
            out.println("-1 3");
            out.flush();
        }
        if(e.getKeyCode()==KeyEvent.VK_W){
            out.println("-1 4");
            out.flush();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        out.println(e.getPoint().x+"    "+e.getPoint().y);
        out.flush();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
        out.println("-1     -1");
        out.flush();
    }

    class DisplayPanel extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //draw your graphics here

        }
    }
}
