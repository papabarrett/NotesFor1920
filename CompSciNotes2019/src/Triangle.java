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

public class Triangle extends Rectangle implements Comparable{

    Color color;
    public Triangle(){
        Random randy=new Random();
        width=height=randy.nextInt(400)+25;
        x=randy.nextInt(500-width);
        y=randy.nextInt(500-height);
        color=new Color(randy.nextInt(255),randy.nextInt(255),randy.nextInt(255));
    }
    @Override
    public int compareTo(Object o) {
        Triangle other=(Triangle)o;
        if(y<other.y)
            return -1;
        if(y>other.y)
            return 1;
        return 0;
    }
    public int getColorTotal(){
        return color.getRed()+color.getBlue()+color.getGreen();
    }
    public void draw(Graphics g){
        g.setColor(color);
        Polygon p=new Polygon();
        p.addPoint(x, y);
        p.addPoint(x,y+height);
        p.addPoint(x+width,y);
        g.fillPolygon(p);
    }

}