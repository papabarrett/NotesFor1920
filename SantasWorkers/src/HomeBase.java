
/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class HomeBase extends DrawableRectangle {

    public HomeBase() {
        super(0, 0, "santa.jpg");
    }

    @Override
    public char getSymbol() {
        return 'h';
    }

}
