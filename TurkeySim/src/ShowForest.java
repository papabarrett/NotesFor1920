/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.applet.*;

public class ShowForest extends Applet {
    int size=50;
    Image tree=new ImageIcon("deciduous-tree.png").getImage();
    Image stone=new ImageIcon("Stone.png").getImage();
    Image turkey=new ImageIcon("turkey.gif").getImage();
    Image hunter=new ImageIcon("hunter.png").getImage();
    public void init() {
        resize(800,600);
    }

    
    public void paint(Graphics g){
        char[][] forest=new char[12][16];
        try{
            CreateFile.setupForest(forest);
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
            
        }catch(Exception e){}
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
}