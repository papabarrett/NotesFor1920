
/**
 *
 * @author J. Barrett
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
import java.text.DecimalFormat;

public class Ship extends Block {

    int angle;

    public Ship() {
        super();
        setColor(Color.MAGENTA);
        this.setLocation(250, 250);
        this.setSize(50, 50);
        this.setOval(false);
        angle = 0;
    }

    public void setLocation(int x1, int y1) {
        super.setLocation(x1, y1);
        xLoc = x1;
        yLoc = y1;

    }

    public void calculateSpeeds() {
        xSpeed = Math.cos(angle / 360.0 * 2 * Math.PI);
        ySpeed = Math.sin(angle / 360.0 * 2 * Math.PI);
        System.out.println(xSpeed + ":" + ySpeed);
    }

    public void increaseAngle() {
        angle += 1;
        angle %= 360;
    }

    public void decreaseAngle() {
        angle -= 1;
        angle %= 360;
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
//        DecimalFormat df = new DecimalFormat(".00");
//        g.drawString("Angle: " + angle, x, y + 15);
//        g.drawString("xSpeed: " + xSpeed, x, y + 25);
//        g.drawString("ySpeed: " + ySpeed, x, y + 35);
        Polygon triangle = new Polygon();
        triangle.addPoint(x, y);
        triangle.addPoint((int) getMaxX(), (int) getCenterY());
        triangle.addPoint((int) x, (int) getMaxY());
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform backup = g2d.getTransform();
        AffineTransform trans = new AffineTransform();
        trans.rotate(angle/ 360.0 * 2 * Math.PI, getCenterX(), getCenterY());
        
        g2d.transform(trans);
        g2d.drawPolygon(triangle);
        g2d.fillOval((int) getMaxX(), (int) getCenterY(), 3, 3);
        g2d.setTransform(backup); // restore previous transform

    }

}
