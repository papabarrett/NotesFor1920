/**
 *
 * @author NAME
 */ 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;

public class RunningForest extends JPanel implements ActionListener, KeyListener{

    javax.swing.Timer timer;

    public static void main(String[] args) throws Exception {
        JFrame frame=new JFrame("Insert Title Here");
        frame.setSize(850,650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        frame.add(new RunningForest());        
        frame.setVisible(true);        
    }
    public RunningForest(){
        //put constructor code here
        try{
            CreateFile.setupForest(forest);
            
            
        }catch(Exception e){}
        timer=new javax.swing.Timer(500,this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
    }
    public void actionPerformed(ActionEvent e){
        
        
        repaint();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //draw your graphics here
        for (int r = 0; r < forest.length; r++) {
            for (int c = 0; c < forest[r].length; c++) {
                if(forest[r][c]=='t')
                    drawTree(g,r,c);
                if(forest[r][c]=='h')
                    drawHunter(g,r,c);
                if(forest[r][c]=='r')
                    drawStone(g,r,c);
                if(forest[r][c]=='k')
                    drawTurkey(g,r,c);
            }
        }
    }
    public void keyPressed(KeyEvent e){
    }
    public void keyTyped(KeyEvent e){
    }
    public void keyReleased(KeyEvent e){
    }
    public void drawTree(Graphics g, int r, int c){
        g.setColor(Color.GREEN);
        int x=c*size;
        int y=r*size;
        g.drawImage(tree, x, y, size,size, null);
    }
    public void drawTurkey(Graphics g, int r, int c){
        g.setColor(Color.GREEN);
        int x=c*size;
        int y=r*size;
        g.drawImage(turkey, x, y,  size,size, null);
    }
    public void drawStone(Graphics g, int r, int c){
        g.setColor(Color.GREEN);
        int x=c*size;
        int y=r*size;
        g.drawImage(stone, x, y, size,size,  null);
    }
    public void drawHunter(Graphics g, int r, int c){
        g.setColor(Color.GREEN);
        int x=c*size;
        int y=r*size;
        g.drawImage(hunter, x, y, size,size,  null);
    }
    int size=50;
    Image tree=new ImageIcon("deciduous-tree.png").getImage();
    Image stone=new ImageIcon("Stone.png").getImage();
    Image turkey=new ImageIcon("turkey.gif").getImage();
    Image hunter=new ImageIcon("hunter.png").getImage();
    char[][] forest=new char[12][16];
}