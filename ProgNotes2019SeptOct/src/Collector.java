
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
    int num=0;

    Rectangle pete;
    Point movePlace;
    boolean clicked;
    ArrayList<Rectangle> coins;
    int difficulty = 10;

    public static void main(String[] args) throws Exception {
        new Collector();
    }

    public Collector() {
        frame = new JFrame("");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.addMouseListener(this);
        display = new DisplayPanel();
        frame.add(display);
        //put constructor code here
        pete = new Rectangle(10, 10, 10, 30);
        movePlace = new Point(15, 25);
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
        num++;
        if(num==4)num=0;
        double xComp = Math.abs(pete.getCenterX() - movePlace.x);
        double yComp = Math.abs(pete.getCenterY() - movePlace.y);
        double totalComp = xComp + yComp;
        clicked = Math.hypot(xComp, yComp) > 2;
        if (clicked) {
            if (Math.random() * totalComp < xComp) {
                if (pete.getCenterX() < movePlace.x) {
                    pete.x++;
                }
                if (pete.getCenterX() > movePlace.x) {
                    pete.x--;
                }
            } else {
                if (pete.getCenterY() < movePlace.y) {
                    pete.y++;
                }
                if (pete.getCenterY() > movePlace.y) {
                    pete.y--;
                }
            }
        }
        for (int i = 0; i < coins.size(); i++) {
            if (pete.intersects(coins.get(i))) {
                coins.remove(i);
                i = 0;
            }
        }
        if (Math.random() < .0002) {
            difficulty--;
            System.out.println(difficulty);

        }
        while (coins.size() < difficulty) {
            int x1 = (int) ((display.getWidth() - 5) * Math.random());
            int y1 = (int) ((display.getHeight() - 10) * Math.random());
            coins.add(new Rectangle(x1, y1, 5, 10));
        }
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
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        clicked = true;
        movePlace = e.getPoint();
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
            g.setColor(Color.black);
            g.drawString("Num:"+num, pete.x+5, pete.y-5);

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
