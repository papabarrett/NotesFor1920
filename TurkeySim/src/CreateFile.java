/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class CreateFile {
    public static void main(String[] args) throws Exception {
        System.out.println("running");
        new File("forest.txt").delete();
        char[][] forest=new char[12][16];
        
        setupForest(forest);
        
        
        putItems(forest, 't', 25);
        putItems(forest, 'r', 25);
        putItems(forest, 'k', 10);
        putItems(forest, 'h', 3);
        
        writeForest(forest);
    }

    public static void putItems(char[][] forest, char what, int num) {
        while(count(forest, what)<num) {
            Random randy=new Random();
            int r=randy.nextInt(forest.length);
            int c=randy.nextInt(forest[0].length);
            while(forest[r][c]!='.'){
                r=randy.nextInt(forest.length);
                c=randy.nextInt(forest[0].length);
            }
            forest[r][c]=what;            
        }
    }

    public static int count(char[][] forest, char what) {
        int treeCount;
        treeCount=0;
        for (int r = 0; r < forest.length; r++) {
            for (int c = 0; c < forest[r].length; c++) {
                if(forest[r][c]==what)
                    treeCount++;
            }
        }
        return treeCount;
    }

    public static void writeForest(char[][] forest) throws FileNotFoundException {
        PrintWriter out=new PrintWriter(new File("forest.txt"));
        for (int r = 0; r < forest.length; r++) {
            out.println(forest[r]);
        }
        out.close();
    }

    public static void setupForest(char[][] forest) throws FileNotFoundException {
        File f=new File("forest.txt");
        if(!f.exists()){
            for (int r = 0; r < forest.length; r++) {
                for (int c = 0; c < forest[r].length; c++) {
                    forest[r][c]='.';
                }                
            }
        }
        else{
            Scanner scan=new Scanner(f);
            for (int r = 0; r < forest.length; r++) {
                forest[r]=scan.next().toCharArray();
            }            
        }
    }

}