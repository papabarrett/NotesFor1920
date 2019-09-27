/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class AddNumbers {
    public static void main(String[] args) throws Exception {
        //Solution 1
//        Scanner scan=new Scanner(System.in);
//        System.out.print("Enter your list of numbers:  ");
//        Scanner numScan=new Scanner(scan.nextLine().replaceAll(" 0",""));
//        int total=0;
//        while(numScan.hasNextInt()){
//            int num=numScan.nextInt();
//            total+=num;
//            System.out.print(num+" + ");
//            
//        }
//        System.out.println("\b\b= "+total);

        System.out.println("Enter your list of numbers: ");
        String line=new Scanner(System.in).nextLine();
        String[] input=line.split(" ");
        int total=0;
        for (int i = 0; i < input.length; i++) {
            total+=new Integer(input[i]);
        }
        for (int i = 0; i < input.length-1; i++) {
            System.out.print(input[i]+" + ");
        }
        System.out.println("\b\b = "+total);
    }

}