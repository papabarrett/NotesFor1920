
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

    public Block(int x, int y, int w, int h, int r, int g, int b, boolean o) {
        super(x, y, w, h);
        color = new Color(r, g, b);
        oval = o;
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
