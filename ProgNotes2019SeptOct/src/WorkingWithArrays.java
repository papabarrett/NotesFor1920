/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class WorkingWithArrays {
    public static void main(String[] args) throws Exception {
        File file=new File("info.txt");
        file.createNewFile();
        //What can we do with a list of numbers?
        //Add them, find the average, multiply them, scale them (conversions), find qualities, find rarity
        int[] list=readInArray(file);
        
        
        double total=addArray(list);        
        
        double average=findAverage(list);
        
        int product=findProduct(list);
        
        double[] daysList=convertHoursToDays(list);
        
        int evenNums=countEvens(list);
        
        int  currentCount=1, highCount=1, highValue=list[0];

        for (int i = 1; i < list.length; i++) {
            int j = list[i];
            if(list[i]==list[i-1])
                currentCount++;
            else
                currentCount=1;
            if(currentCount>highCount){
                highCount=currentCount;
                highValue=j;
            }
            
        }
        
        System.out.println(highValue);
        
        
    }

    public static int countEvens(int[] list) {
        int evenNums=0;
        for (int i = 0; i < list.length; i++) {
            int j = list[i];
            if(j%2==0) evenNums++;
            
        }
        return evenNums;
    }

    public static double[] convertHoursToDays(int[] list) {
        double[] daysList=new double[list.length];
        for (int i = 0; i < daysList.length; i++) {
            daysList[i]=list[i]/24.0;
        }
        return daysList;
    }

    public static int findProduct(int[] list) {
        int product=1;
        for (int i = 0; i < list.length; i++) {
            int j = list[i];
            product*=j;
        }
        return product;
    }

    public static double findAverage(int[] list) {
        //2. Average
        double average=addArray(list)/list.length;  // find total, then divide by count
        return average;
    }

    public static double addArray(int[] list) {
        //1. Add them
        double total=0;
        for (int i = 0; i < list.length; i++) {
            int j = list[i];
            total+=j;
        }
        return total;
    }

    public static int[] readInArray(File file) throws FileNotFoundException {
        //0. Read them in
        Scanner scan=new Scanner(file);
        int[] list=new int[scan.nextInt()];
        for (int i = 0; i < list.length; i++) {
            list[i]=scan.nextInt();
        }
        return list;
    }

}