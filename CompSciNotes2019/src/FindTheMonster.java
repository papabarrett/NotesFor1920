/**
 *
 * @author J. Barrett
 */

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

public class FindTheMonster {
    public static void main(String[] args) throws Exception {
        new FindTheMonster();
    }
    
    ArrayList<Point> monsterLocations; 
    Point player;
    Random randy;
    JFrame frame;
    JButton[][] buttons;
    final static int GRID_SIZE=20;
    
    public FindTheMonster(){
        buildWindow();
        randy=new Random();
        monsterLocations=new ArrayList<Point>();
        monsterLocations.add(randomMonsterPoint());
        while(monsterLocations.size()<GRID_SIZE){
            Point p=randomMonsterPoint();
            if(!monsterLocations.contains(p))
                monsterLocations.add(p);
        }
        do{
            player=randomMonsterPoint();
        }while(monsterLocations.contains(player));
        
        showPlayersWorld();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void buildWindow() throws HeadlessException {
        frame=new JFrame("Find the Monster");
        frame.setLayout(new GridLayout(0,GRID_SIZE));
        buttons=new JButton[GRID_SIZE][GRID_SIZE];
        for (int y = 0; y < buttons.length; y++) {
            for (int x = 0; x < buttons[y].length; x++) {
                buttons[y][x]=new JButton(" ");
                buttons[y][x].setActionCommand(x+" "+y);
           //     buttons[y][x].addActionListener(new MonsterListener());
                buttons[y][x].addKeyListener(new MonsterKeyListener());
                frame.add(buttons[y][x]);
            }
        }
    }
    class MonsterListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Scanner scan=new Scanner(e.getActionCommand());
            Point clicked=new Point(scan.nextInt(),scan.nextInt());
            if(monsterLocations.contains(clicked))
                buttons[clicked.y][clicked.x].setBackground(Color.red);
            else
                buttons[clicked.y][clicked.x].setBackground(Color.blue);
            System.out.println(monsterLocations);
        }
        
    }

    class MonsterKeyListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("aaa");
            int changeX=0,changeY=0;
            if(KeyEvent.VK_UP==e.getKeyCode())
                changeY--;
            if(KeyEvent.VK_DOWN==e.getKeyCode())
                changeY++;
            if(KeyEvent.VK_LEFT==e.getKeyCode())
                changeX--;
            if(KeyEvent.VK_RIGHT==e.getKeyCode())
                changeX++;
            Point desired=new Point(player.x+changeX, player.y+changeY);
            System.out.println(desired+" "+player);
            if(validMove(desired))
                player.setLocation(desired);
            System.out.println(desired+" "+player);
            showPlayersWorld();
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
        
    }
    public boolean validMove(Point p){
        System.out.println("ggg");
        if(monsterLocations.contains(p))
            return false;
        System.out.println("cccc");
        if(!(new Rectangle(0,0,GRID_SIZE,GRID_SIZE).contains(p)))
            return false;
        System.out.println("bbb");
        return true;
    }
    public Point randomMonsterPoint(){
        return new Point(randy.nextInt(GRID_SIZE),randy.nextInt(GRID_SIZE));
    }
    public void showPlayersWorld(){
        for (int y = 0; y < buttons.length; y++) {
            for (int x = 0; x < buttons[y].length; x++) {
                buttons[y][x].setBackground(Color.black);
                if(player.distance(x, y)<GRID_SIZE/3){
                    if(monsterLocations.contains(new Point(x,y)))
                        buttons[y][x].setBackground(Color.red);
                    else if(player.equals(new Point(x,y)))
                        buttons[y][x].setBackground(Color.blue);
                    else
                        buttons[y][x].setBackground(Color.green);
                }
            }
        }
    }
}