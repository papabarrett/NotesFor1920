/**
 *
 * @author J. Barrett
 */

import java.awt.Rectangle;

public class Bullet extends Block implements DrawItem{

    private boolean out;
    public Bullet(int x, int y, double x1, double y1) {
        super(x, y, 3, 3, 255,255,255, true);
        this.setSpeed(x1, y1);
        out=false;
    }
    public void move(Rectangle bounds){
        if (bounds.width > 10) {
            yLoc += ySpeed;
            xLoc += xSpeed;
            if (yLoc < 0) {
                out=true;
            }
            if (yLoc > bounds.height) {
                out=true;
            }
            if (xLoc < 0) {
                out=true;
            }
            if (xLoc > bounds.width) {
                out=true;
            }
            x = (int) xLoc;
            y = (int) yLoc;
        }
        
    }
    public boolean outOfBounds(){
        return out;
    }
    

}