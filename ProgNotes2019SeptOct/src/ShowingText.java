
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

public class ShowingText implements ActionListener, KeyListener {

    javax.swing.Timer timer;
    JFrame frame;
    JPanel display;

    public static void main(String[] args) throws Exception {
        new ShowingText();
    }

    public ShowingText() {
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
            Color boxColor = new Color(244, 235, 47);
            g.setColor(boxColor);
            g.fillRect(75, 75, 200, 300);
            Polygon box3D = new Polygon();
            box3D.addPoint(50, 50);
            box3D.addPoint(250, 50);
            box3D.addPoint(275, 75);
            box3D.addPoint(75, 75);
            box3D.addPoint(75, 375);
            box3D.addPoint(50, 350);
            Color backBox = new Color(186, 177, 10);
            g.setColor(backBox);
            g.fillPolygon(box3D);
            g.setColor(Color.black);
            g.drawRect(75, 75, 200, 300);
            g.drawPolygon(box3D);
            g.drawLine(50, 50, 75, 75);
            Color bowlOutside = new Color(164, 49, 32);
            g.setColor(bowlOutside);
            g.fillArc(100, 265, 150, 100, 180, 180);
            Color bowlInside = new Color(123, 36, 23);
            g.setColor(bowlInside);
            g.fillOval(100, 308, 150, 14);
            g.setColor(Color.black);
            g.drawOval(100, 308, 150, 14);
            g.drawArc(100, 265, 150, 100, 180, 180);
            Font titleFont = new Font("Hobo Std", Font.PLAIN, 37);
            g.setFont(titleFont);
            g.drawString("CrUnChY", 100, 150);
            Font secondFont = new Font("Jokerman", Font.PLAIN, 37);
            g.setFont(secondFont);
            g.drawString("BiTeS", 125, 190);
            try {
                //star work
                File file = new File("star.txt");
                file.createNewFile();
                Scanner scan=new Scanner(file);
                Polygon star=new Polygon();
                for (int i = 0; i < 20; i++) {                    
                    star.addPoint(scan.nextInt(), scan.nextInt());
                }
                star.translate(-20, -15);
                for (int i = 0; i < 13; i++) {
                    Color myRed=new Color(150+i*5,5*i,10*i);
                    g.setColor(myRed);
                    g.fillPolygon(star);
                    star.translate(3, 2);
                }
                star.translate(170, -180);
                g.setColor(Color.CYAN);
                g.fillPolygon(star);
            } catch (Exception e) {
            }

        }
    }
}
