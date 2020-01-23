/**
 *
 * @author J. Barrett
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.lang.*;
import java.util.Random;

public class SizeCircle extends Rectangle implements Comparable{

    @Override
    public int compareTo(Object arg0) {  //sorting based on size
        SizeCircle other=(SizeCircle)arg0;
        if(other.getWidth()>this.getWidth())
            return -1; //I am less
        else if(other.getWidth()==this.getWidth())
            return 0; //We are equal
        else
            return 1; //I am better
    }
    
    Color color;
    Color fillColor;

    public SizeCircle(int centerX, int centerY, int radius) {
        super(centerX-radius, centerY-radius, radius*2, radius*2);
        Random randy=new Random();
        color=new Color(randy.nextInt(256),randy.nextInt(256),randy.nextInt(256));
        fillColor=new Color(color.getRed(),color.getGreen(),color.getBlue(),180);
        
    }
    
    public void draw(Graphics g){
        g.setColor(color);
        g.drawOval(x,y,width,height);
        g.setColor(fillColor);
        g.fillOval(x, y, width, height);
        Polygon tri=new Polygon();
        tri.addPoint((int)getCenterX(),y);
        tri.addPoint(x,y+height);
        tri.addPoint(x+width, y+height);
        g.drawPolygon(tri);
    }
    
}