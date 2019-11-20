/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class ValueFinder {
    public static void main(String[] args) throws Exception {
        File file = new File("dataMap.txt");
        file.createNewFile();
        String[][] map;
        
        map=createBlankMap(file);
        
        readInFile(file, map);
        
        int highValue=-1, highR=-1, highC=-1;
        
        printHighLoc(map, highValue, highR, highC);
        
        System.out.println(map.length);
    }

    public static void printHighLoc(String[][] map, int highValue, int highR, int highC) throws NumberFormatException {
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[0].length; c++) {
                if(isANumber(map[r][c])){
                    if(Integer.parseInt(map[r][c])>highValue){
                        highValue=Integer.parseInt(map[r][c]);
                        highR=r;
                        highC=c;
                    }
                }
            }
        }
        System.out.println(highValue+" at "+highR+" "+highC);
    }

    public static void readInFile(File file, String[][] map) throws FileNotFoundException {
        Scanner scan=new Scanner(file);
        for (int r = 0; r < map.length; r++) {
            map[r]=scan.next().split("");
        }
    }

    public static String[][] createBlankMap(File file) throws FileNotFoundException {
        String[][] map;
        int rows=0, cols=0;
        Scanner scan=new Scanner(file);
        while(scan.hasNext()){
            rows++;
            cols=scan.next().length();
        }
        map=new String[rows][cols];
        return map;
    }

    public static boolean isANumber(String s){
        if(s.matches("[a-z]"))return false;
        if(s.matches("[A-Z\\.]"))return false;
        return true;
    }
}