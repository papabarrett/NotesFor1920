/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class JoeAndHaydenProject {
    
    final static int LOSE=0;
    final static int SMALL=1;
    final static int MEDIUM=2;
    final static int BIG=3;
    
    public static void main(String[] args) throws Exception {
        int[] plays=new int[4];
        for (int i = 0; i < 1000000; i++) {
            plays[play()]++;
        }
        System.out.println(Arrays.toString(plays));
    }
    
    public static int play(){
        Random dice=new Random();
        int n1=dice.nextInt(12);
        int n2=dice.nextInt(12);
        int n3=dice.nextInt(12);
        int n4=dice.nextInt(12);
       // int n5=dice.nextInt(6);
      //  System.out.println(n1+" "+n2+" "+n3+" "+n4+" ");
        int[] countu=new int[20];
        for (int i = 0; i < countu.length; i++) {
            countu[i]=0;
        }
        countu[n1]++;
        countu[n2]++;
        countu[n3]++;
        countu[n4]++;
       // countu[n5]++;
        
        int max=0;
        for (int i = 0; i < countu.length; i++) {
            max=Math.max(max,countu[i]);
        }
      //  System.out.println(Arrays.toString(countu));
        if(max==4){
           // System.out.println("BIG");
            return BIG;
        }
        if(max==3){
          // System.out.println("MEDIUM");
            return MEDIUM;
        }
        if(max==2){
          //  System.out.println("SMALL");
            return SMALL;
        }
      //  System.out.println("LOSE");
        return LOSE;
        
    }
    

}