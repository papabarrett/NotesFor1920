/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class BrandonProject {
    
    final static int LOSE=0;
    final static int SMALL=1;
    final static int MEDIUM=2;
    final static int BIG=3;
    
    public static void main(String[] args) throws Exception {
        int[] plays=new int[4];
        for (int i = 0; i < 10000000; i++) {
            plays[play()]++;
        }
        System.out.println(Arrays.toString(plays));
    }
    
    public static int play(){
        Random dice=new Random();
        int n1=dice.nextInt(5)+2;
       // System.out.println(n1);
        ArrayList<Integer> list=new ArrayList<Integer>();
        for (int i = 0; i < n1; i++) {
            list.add(new Integer(dice.nextInt(13)));
        }
      //  System.out.println(list);
        int[] countu=new int[20];
        for (int i = 0; i < countu.length; i++) {
            countu[i]=0;
        }
        for (int i = 0; i < list.size(); i++) {
            countu[list.get(i)]++;
        }
      //  System.out.println(Arrays.toString(countu));
        for(int i=0; i<countu.length; i++){
            countu[i]/=2;
        }
        
     //   System.out.println(Arrays.toString(countu));
        int sum=0;
        for (int i = 0; i < countu.length; i++) {
            sum+=countu[i];
        }
     //   System.out.println(Arrays.toString(countu));
        if(sum==3){
     //       System.out.println("BIG");
            return BIG;
        }
        if(sum==2){
      //     System.out.println("MEDIUM");
            return MEDIUM;
        }
        if(sum==1){
       //     System.out.println("SMALL");
            return SMALL;
        }
     //   System.out.println("LOSE");
        return LOSE;
        
    }
    

}