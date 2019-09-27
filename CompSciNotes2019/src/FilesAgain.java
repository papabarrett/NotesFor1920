
/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class FilesAgain {

    public static void main(String[] args) throws Exception {
        new FilesAgain();

    }
    File file;
    char[][] map;
    int totalBlocks, usedBlocks;
    Random randy;
    

    public FilesAgain() {
        
        file = new File("map.txt");
        try {
            file.createNewFile();
        } catch (Exception e) {
        }

        map = new char[500][500];
        makeFreshMap();
        totalBlocks = map.length * map[0].length;
        usedBlocks = 0;
        randy = new Random();
        while (usedBlocks < totalBlocks*2 / 3) {
            if (usedBlocks == 0) {
                placeRandomBlock();
            }
            if(randy.nextInt(1000)<5)
                placeRandomBlock();
            else
                growABlock();
        }
        makeSand();
        writeMap();
    }

    public void makeFreshMap() {
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[r].length; c++) {
                map[r][c] = '.';
            }
        }
    }

    public void placeRandomBlock() {
        int row, col;
        do {
            row = randy.nextInt(map.length);
            col = randy.nextInt(map[row].length);
        } while (map[row][col] != '.');
        map[row][col] = 'x';

        usedBlocks++;
    }

    public void writeMap() {
        try {
            PrintWriter out = new PrintWriter(file);
            for (int r = 0; r < map.length; r++) {
                out.println(map[r]);
            }
            out.close();
        } catch (Exception e) {
            System.out.println("PROBLEM");
        }
    }
    public void growABlock(){
        int row, col;
        do {
            row = randy.nextInt(map.length);
            col = randy.nextInt(map[row].length);
        } while (map[row][col] != 'x');
        int right=col+1,left=col-1,up=row-1,down=row+1;
        if(right<map[row].length&&map[row][right]=='.'){
            usedBlocks++;
            map[row][right]='x';
        }
        if(left>0&&map[row][left]=='.'){
            usedBlocks++;
            map[row][left]='x';
        }
        if(up>0&&map[up][col]=='.'){
            usedBlocks++;
            map[up][col]='x';
        }
        if(down<map.length&&map[down][col]=='.'){
            usedBlocks++;
            map[down][col]='x';
        }
    }
    public void makeSand(){
        for (int r = 1; r < map.length; r++) {
            for (int c = 0; c < map[r].length; c++) {
                if(map[r][c]=='x'&&map[r-1][c]=='.')
                    map[r][c]='-';
            }
        }
    }
}
