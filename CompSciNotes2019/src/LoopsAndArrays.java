/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class LoopsAndArrays {
    public static void main(String[] args) throws Exception {
        int x=0;
        int b[]=new int[10];
        while(x<10){
            b[x]=x*3;
            x+=3;
        }
        System.out.println(x);
        System.out.println(Arrays.toString(b));
        //important about while loops:
        //may or may not execute (like a repeatable if statement)
        //variables should persist (exist before and after)
        double budget=400;
        Scanner scan=new Scanner(System.in);
        DecimalFormat df=new DecimalFormat("$0.00");
        do {            
            System.out.println("Budget Left "+df.format(budget)+":");
            System.out.print("Money spent: ");
            budget-=scan.nextDouble();
        } while (budget>0);
        if(budget<0)
        System.out.println("Over budget!!! : "+df.format(-1*budget));
        //do while loops always check afterwards
        //do while loops always run at least once
        String[] alphabet=new String[26];
        for (int i = 0; i < 26; i++) {
            if(i==0)
                alphabet[0]="a";
            else
                alphabet[i]=alphabet[i-1]+(char)((int)('a')+i);
        }
        for (int i = 0; i < 26; i+=7) {
            System.out.println(alphabet[i]);
        }
        
        
        
        
    }

}