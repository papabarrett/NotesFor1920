/**
 *
 * @author J. Barrett
 */

import java.awt.Color;
import java.awt.Rectangle;

public class Ship extends Block{
    double xSpeed, ySpeed, xLoc, yLoc;
    public Ship(){
        super();
        setColor(Color.MAGENTA);
        this.setLocation(250, 250);
        this.setSize(50, 50); 
        this.setOval(false);
        xSpeed=ySpeed=0;
        xLoc=x;
        yLoc=y;
    }
    public void move(Rectangle bounds){
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
        this.setLocation((int)xLoc,(int)yLoc);
        
    }
    

}