/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class juggle {
    public static void main(String[] args) throws Exception {
        Scanner scan=new Scanner(new File("juggle.dat"));
        int num=scan.nextInt();scan.nextLine();
        
        for (int i = 0; i < num; i++) {
            processJuggle(scan);
        }
    }

    public static void processJuggle(Scanner scan) throws NumberFormatException {
        String[] tosses=scan.nextLine().split("");
        int[] catches=new int[100];
        Arrays.fill(catches, 0);
        for (int j = 0; j < tosses.length; j++) {
            if(Integer.parseInt(tosses[j])>0)
                catches[j+Integer.parseInt(tosses[j])]++;
        }
        int i;
        for (i = 0; i < catches.length; i++) {
            if(catches[i]>1){
                System.out.println("DROPPED "+(catches[i]-1)+" on step "+(i+1));
                i=catches.length+2;
            }
        }
        if(i==catches.length)
            System.out.println("VALID");
    }

}