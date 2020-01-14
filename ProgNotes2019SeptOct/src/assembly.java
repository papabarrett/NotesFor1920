/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class assembly {
    public static void main(String[] args) throws Exception {
        Scanner scan=new Scanner(new File("assembly.dat"));
        int data=scan.nextInt();
        for (int i = 0; i < data; i++) {
            processScrew(scan); 
        }
        
    }

    public static void processScrew(Scanner scan) {
        int num=scan.nextInt();scan.nextLine();
        int[] screws=new int[num];
        for (int i = 0; i < num; i++) {
            screws[i]=0;
            String[] input=scan.nextLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                if(input[j].equals(">")) screws[i]-=3;
                if(input[j].equals("<")) screws[i]-=1;
            }
        }
        for (int i = 0; i < num; i++) {
            int minIndex=0;
            for (int j = 1; j < num; j++) {
                if(screws[minIndex]>screws[j])
                    minIndex=j;
            }
            screws[minIndex]=scan.nextInt();
            
        }
        int key=scan.nextInt();
        for(int i=0;i<num;i++){
            if(key==screws[i]){
                char set=(char)('A'+i);
                System.out.println("SET "+set);
            }
        }
    }

}