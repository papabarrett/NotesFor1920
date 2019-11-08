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
        ArrayList<Point> moved=new ArrayList<Point>();
        for (int r = 0; r < forest.length; r++) {
            for (int c = 0; c < forest[r].length; c++) {
                if(forest[r][c]=='k')
                    moved.add(moveRanTurkey(forest,r,c,moved));
            }
        }
        
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
    
    public Point moveRanTurkey(char[][] forest, int r, int c, ArrayList<Point> moved){
        Random randy=new Random();
        if(moved.contains(new Point(r,c)))
            return new Point(-1,-1);
        if(randy.nextInt(2)==0){   //left-right
            if(randy.nextInt(2)==0){  //left
                if(c-1>=0 && forest[r][c-1]=='.'){
                    forest[r][c-1]='k';
                    forest[r][c]='.';
                    return new Point(r,c-1);
                }
            }
            else{
                if(c+1<forest[r].length && forest[r][c+1]=='.'){
                    forest[r][c+1]='k';
                    forest[r][c]='.';
                    return new Point(r,c+1);
                }
            }
        }
        else{
            if(randy.nextInt(2)==0){  //left
                if(r-1>=0 && forest[r-1][c]=='.'){
                    forest[r-1][c]='k';
                    forest[r][c]='.';
                    return new Point(r-1, c);
                }
            }
            else{
                if(r+1<forest.length && forest[r+1][c]=='.'){
                    forest[r+1][c]='k';
                    forest[r][c]='.';
                    return new Point(r+1,c);
                }
            }
        }
        System.out.println("NEVER");  //should say wasn't valid move... bad BARRETT
        return null;
    }
}