
/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class OrganizingNumbers {

    public static void main(String[] args) throws Exception {
        new File("numberList.dat").createNewFile();
        double[] array;
        Scanner scan = new Scanner(new File("numberList.dat"));
        int count = 0;
        while (scan.hasNext()) {  //algorithm to count lines
            count++;
            scan.nextLine();
        }
        array=new double[count];
        scan=new Scanner(new File("numberList.dat"));
        for (int i = 0; i < count; i++) {
            array[i]=scan.nextDouble();
        }
        System.out.println(Arrays.toString(array));
        //bubble sort
        for (int i = 0; i < array.length-1; i++) {
            System.out.println(i+")===================");
            for (int j = 0; j < array.length-1; j++) {
                System.out.println(j+") "+Arrays.toString(array));
                if(array[j]>array[j+1]){
                    //swap
                    double temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
    }

}
