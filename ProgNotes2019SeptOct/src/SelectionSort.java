/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class SelectionSort {
    public static void main(String[] args) throws Exception {
        int[] nums=new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=(int)(Math.random()*5000);
        }
        for (int i = 0; i < nums.length; i++) {
            int minIndex=i;
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j]<nums[minIndex]){
                    minIndex=j;
                }
            }
            System.out.println("Min index "+minIndex);
            System.out.println(Arrays.toString(nums));
            int temp=nums[i];
            nums[i]=nums[minIndex];
            nums[minIndex]=temp;
        }
        System.out.println(Arrays.toString(nums));
    }

}