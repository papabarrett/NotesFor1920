
/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class Conditionals {

    public static void main(String[] args) throws Exception {
        boolean flag;
        double jumpHeight, barHeight = 6;
        jumpHeight = Math.random() * 2.5 + 5;//random number from 5 ft to 7.5 ft
        flag = jumpHeight > barHeight;
        System.out.println(flag);
        DecimalFormat feet = new DecimalFormat("0.00 ft");
        System.out.println(feet.format(jumpHeight));
        if (jumpHeight < 5.5) {
            System.out.println("We need to cut you from the high jump team.");
        }

        double fortyDashSpeed, fortyDashGoal = 5;
        fortyDashSpeed = Math.random() * 0.9 + 4.5;//random number from 4.5 to 5.2
        DecimalFormat speed = new DecimalFormat("0.0 s");
        if (fortyDashSpeed < fortyDashGoal) {
            System.out.println("You hit your goal at " + speed.format(fortyDashSpeed));
        } else if (fortyDashSpeed < (fortyDashGoal + .2)) {
            System.out.println(speed.format(fortyDashSpeed) + " is .2 or less from your"
                    + " goal.");
        } else {
            System.out.println("Keep working please: " + speed.format(fortyDashSpeed));
        }
    }
}
