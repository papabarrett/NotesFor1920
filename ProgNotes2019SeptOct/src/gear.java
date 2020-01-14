/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class gear {
    public static void main(String[] args) throws Exception {
        Scanner scan=new Scanner(new File("gear.dat"));
        int num=scan.nextInt(); scan.nextLine();
        
        for (int i = 0; i < num; i++) {
        processGears(scan);
            
        }
        
    }

    public static void processGears(Scanner scan) {
        String gears=scan.nextLine();
        String pos=scan.nextLine();
        String notPos=pos.contains("U")?"CLOCKWISE":"COUNTER-CLOCKWISE";
        int one=gears.indexOf("1")/2;
        int nine=gears.indexOf("9")/2;
        int distance=Math.abs(one-nine);
        
        if(distance%2==0)
            System.out.println(pos);
        else
            System.out.println(notPos);
    }

}