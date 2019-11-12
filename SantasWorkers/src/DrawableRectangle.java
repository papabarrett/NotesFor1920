
/**
 *
 * @author J. Barrett
 */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.lang.*;
import javax.swing.ImageIcon;

public abstract class DrawableRectangle extends Rectangle {

    final static int SQUARE_SIZE = 25;
    private int r, c;
    Image image;

    public DrawableRectangle(int rt, int ct, String s) {
        super(0, 0, SQUARE_SIZE, SQUARE_SIZE);
        image = new ImageIcon(s).getImage();
        r = rt;
        c = ct;
        updatePosition();
    }

    public final void updatePosition() {
        x = c * SQUARE_SIZE;
        y = r * SQUARE_SIZE;
    }

    public void draw(Graphics g) {
        updatePosition();
        g.drawImage(image, x, y, SQUARE_SIZE, SQUARE_SIZE, null);
    }

    
    public abstract char getSymbol();

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
        updatePosition();
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
        updatePosition();
    }

}