
/**
 *
 * @author J. Barrett
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.lang.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FindTheMonster {

    public static void main(String[] args) throws Exception {
        new FindTheMonster();
    }

    ArrayList<Point> monsterLocations;
    Point player;
    Point exit;
    javax.swing.Timer timer;
    Random randy;
    JFrame frame;
    JPanel buttonPanel;
    JLabel label;
    JButton[][] buttons;
    int level=0;
    final static int GRID_SIZE = 25;

    public FindTheMonster() {
        buildWindow();
        randy = new Random();
        monsterLocations = new ArrayList<Point>();
        resetPoints();
        
        timer = new javax.swing.Timer(10, new TimerListener());
        timer.start();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(new KeyMoveListener());
        frame.pack();
        frame.setVisible(true);
    }

    public void resetPoints() {
        while (monsterLocations.size() > 0) {
            monsterLocations.remove(0);
        }
        monsterLocations.add(randomMonsterPoint());
        while (monsterLocations.size() < GRID_SIZE+level) {
            Point p = randomMonsterPoint();
            if (!monsterLocations.contains(p)) {
                monsterLocations.add(p);
            }
        }
        player=randomMonsterPoint();
        while(monsterLocations.contains(player)){
            player=randomMonsterPoint();
        }
        exit=randomMonsterPoint();
        while(monsterLocations.contains(exit)||player.distance(exit)<GRID_SIZE/2){
            exit=randomMonsterPoint();
        }
    }

    public void buildWindow() throws HeadlessException {
        frame = new JFrame("Find the Monster");
        frame.setLayout(new BorderLayout());
        buttonPanel=new JPanel(new GridLayout(0,GRID_SIZE));
        label=new JLabel("Level "+level);
        frame.add(label,BorderLayout.NORTH);
        frame.add(buttonPanel,BorderLayout.CENTER);
        frame.addKeyListener(new KeyMoveListener());
        buttons = new JButton[GRID_SIZE][GRID_SIZE];
        for (int y = 0; y < buttons.length; y++) {
            for (int x = 0; x < buttons[y].length; x++) {
                buttons[y][x] = new JButton(" ");
                buttons[y][x].setActionCommand(x + " " + y);
                buttons[y][x].addActionListener(new MonsterListener());
        buttons[y][x].addKeyListener(new KeyMoveListener());
                buttonPanel.add(buttons[y][x]);
            }
        }
    }

    class MonsterListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Scanner scan = new Scanner(e.getActionCommand());
            Point clicked = new Point(scan.nextInt(), scan.nextInt());
            if(clicked.distance(player)>1) return;
            player.setLocation(clicked);
        }

    }

    class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            moveAMonster();
            calculateDeath();
            showSomeSpace();
        }

    }

    public Point randomMonsterPoint() {
        return new Point(randy.nextInt(GRID_SIZE), randy.nextInt(GRID_SIZE));
    }

    public void showAllSpace() {
        for (int y = 0; y < buttons.length; y++) {
            for (int x = 0; x < buttons[y].length; x++) {
                if (monsterLocations.contains(new Point(x, y))) {
                    buttons[y][x].setBackground(Color.red);
                } else if( player.equals(new Point(x,y))){
               // buttons[y][x].setBackground(Color.MAGENTA);
                }else if( exit.equals(new Point(x,y))){
             //   buttons[y][x].setBackground(Color.WHITE);
                }
                else {
                    buttons[y][x].setBackground(Color.blue);
                }
            }
        }
    }

    public void showSomeSpace(){
        for (int y = 0; y < buttons.length; y++) {
            for (int x = 0; x < buttons[y].length; x++) {
                buttons[y][x].setBackground(Color.black);
                if(new Point(x,y).distance(player)<(GRID_SIZE/2-level))
                if (monsterLocations.contains(new Point(x, y))) {
                    buttons[y][x].setBackground(Color.red);
                } else if( player.equals(new Point(x,y))){
                buttons[y][x].setBackground(Color.yellow);
                }else if( exit.equals(new Point(x,y))){
                buttons[y][x].setBackground(Color.WHITE);
                }
                else {
                    buttons[y][x].setBackground(Color.gray);
                }
            }
        }
        label.setText("Level: "+level);
    }
    public void moveAMonster() {
        int selected = randy.nextInt(monsterLocations.size());
        int move = randy.nextInt(2) * 2 - 1;
        Point possible;
        if(randy.nextInt(2)>0){
            possible=new Point(monsterLocations.get(selected).x + move, monsterLocations.get(selected).y);
        }
        else{
            
            possible=new Point(monsterLocations.get(selected).x , monsterLocations.get(selected).y+ move);
        }
        if(safeMove(possible))
            monsterLocations.get(selected).setLocation(possible);
    }
    public boolean safeMove(Point p){
        if(monsterLocations.contains(p))
            return false;
        Rectangle rec=new Rectangle(0,0,GRID_SIZE,GRID_SIZE);
        if(!rec.contains(p))
            return false;
        if(exit.equals(p))
            return false;
        return true;
    }
    public boolean safeMovePlayer(Point p){
        if(monsterLocations.contains(p))
            return false;
        Rectangle rec=new Rectangle(0,0,GRID_SIZE,GRID_SIZE);
        if(!rec.contains(p))
            return false;
        return true;
    }
    public void calculateDeath(){
        if(monsterLocations.contains(player)){
            JOptionPane.showMessageDialog(frame, "You died at level "+level+". Back to start.");
            level=0;
            resetPoints();
        }
        if(player.equals(exit)){
            level++;
            resetPoints();
        }
    }
    public class KeyMoveListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int changeX=0, changeY=0;
            if(e.getKeyCode()==KeyEvent.VK_UP)
                changeY--;
            if(e.getKeyCode()==KeyEvent.VK_DOWN)
                changeY++;
            if(e.getKeyCode()==KeyEvent.VK_RIGHT)
                changeX++;
            if(e.getKeyCode()==KeyEvent.VK_LEFT)
                changeX--;
            Point possible=new Point(player.x+changeX,player.y+changeY);
            if(safeMovePlayer(possible))
                player.setLocation(possible);
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
        
    }
}
