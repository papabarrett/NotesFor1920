/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class ArrayOfArrays {
    public static void main(String[] args) throws Exception {
        int[] items;
        items=new int[4];
        items[0]=6; items[1]=7; items[2]=8; items[3]=9;
        int[] stuff={3,2,1,4,5,6,3,2};
        
        int[][] blockOfItems;
        blockOfItems=new int[3][];
        blockOfItems[0]=items;
        blockOfItems[1]=stuff;
        blockOfItems[2]=new int[3];
        blockOfItems[2][0]=2;
        blockOfItems[2][1]=8;
        blockOfItems[2][2]=7;
        
        
        int[][] map=new int[5][8];      //5 lists of size 8
    }

}