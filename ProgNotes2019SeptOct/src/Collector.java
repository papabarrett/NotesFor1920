
/**
 *
 * @author NAME
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.ArrayList;

public class Collector implements ActionListener, KeyListener, MouseListener {

    javax.swing.Timer timer;
    JFrame frame;
    JPanel display;

    Rectangle pete;
    Point movePlace;
    boolean clicked;
    ArrayList<Rectangle> coins;

    public static void main(String[] args) throws Exception {
        new Collector();
    }

    public Collector() {
        frame = new JFrame("Insert Title Here");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.addMouseListener(this);
        display = new DisplayPanel();
        frame.add(display);
        //put constructor code here
        pete = new Rectangle(10, 10, 10, 30);
        movePlace = new Point(0, 0);
        clicked = false;
        coins = new ArrayList<Rectangle>();
        for (int i = 0; i < 10; i++) {
            int x1 = (int) (495 * Math.random());
            int y1 = (int) (490 * Math.random());
            coins.add(new Rectangle(x1, y1, 5, 10));
        }

        //end your constructor code
        timer = new javax.swing.Timer(10, this);
        timer.start();
        frame.addKeyListener(this);
        frame.setFocusable(true);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        //type what needs to be performed every time the timer ticks
        if(pete.getCenterX()<movePlace.x)
            pete.x++;
        if(pete.getCenterX()>movePlace.x)
            pete.x--;
if(pete.getCenterY()<movePlace.y)
            pete.y++;
        if(pete.getCenterY()>movePlace.y)
            pete.y--;
        //end your code for timer tick code
        display.repaint();
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
        System.exit(0);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("t");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("y");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("g");
        clicked=true;
        movePlace=e.getPoint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    class DisplayPanel extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //draw your graphics here
            setBackground(Color.ORANGE);
            g.setColor(Color.red);
            g.fillRect(pete.x, pete.y, pete.width, pete.height);

            for (int i = 0; i < coins.size(); i++) {
                g.setColor(Color.yellow);
                g.fillOval(coins.get(i).x, coins.get(i).y,
                        coins.get(i).width, coins.get(i).height);
                g.setColor(Color.black);
                g.drawOval(coins.get(i).x, coins.get(i).y,
                        coins.get(i).width, coins.get(i).height);
            }

        }
    }
}
