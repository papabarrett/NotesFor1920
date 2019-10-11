
/**
 *
 * @author J. Barrett
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Block extends Rectangle {

    private Color color;
    boolean oval;
    double xSpeed, ySpeed, xLoc, yLoc;

    public Block(int x, int y, int w, int h, int r, int g, int b, boolean o) {
        super(x, y, w, h);
        color = new Color(r, g, b);
        oval = o;
        xSpeed=ySpeed=0;
        xLoc=x;
        yLoc=y;
    }
    
    public void move(Rectangle bounds){
        if(bounds.width>10){
        yLoc+=ySpeed;
        xLoc+=xSpeed;
        if(yLoc<0)
            yLoc=bounds.height;
        if(yLoc>bounds.height)
            yLoc=0;
        if(xLoc<0)
            xLoc=bounds.width;
        if(xLoc>bounds.width)
            xLoc=0;
        x=(int)xLoc;
        y=(int)yLoc;
        }
        
    }

    public Block() {
        this(0, 0, 10, 10, 5, 5, 5, true);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isOval() {
        return oval;
    }

    public void setOval(boolean oval) {
        this.oval = oval;
    }
    
    public void draw(Graphics g){
        g.setColor(color);
        if(oval)
            g.fillOval(x, y, width, height);
        else
            g.fillRect(x, y, width, height);
    }

}
