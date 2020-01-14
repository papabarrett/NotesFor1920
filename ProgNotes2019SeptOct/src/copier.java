/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class copier {
    public static void main(String[] args) throws Exception {
        Scanner scan=new Scanner(new File("copier.dat"));
        
        int num=scan.nextInt();
        for (int i = 0; i < num; i++) {
            processLine(scan);
        }
    }

    public static void processLine(Scanner scan) {
        String word=scan.next().replaceAll("\\.", "1").replaceAll("-", "0");
        for (int i = 0; i < 5; i++) {
            System.out.print(Integer.parseInt(word.substring(i*3,i*3+3),2));
        }
        System.out.println("");
    }

}