
/**
 *
 * @author J. Barrett
 */

import java.lang.*;
import java.util.Random;

public class IceBlock extends DrawableRectangle {

    public IceBlock() {
        super(0, 0, "ice.gif");
        Random randy = new Random();
        do {
            setR(randy.nextInt(20));
            setC(randy.nextInt(20));
        } while (getR() == 0 && getC() == 0);
    }

    @Override
    public char getSymbol() {
        return 'x';
    }

}
