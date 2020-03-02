
/**
 *
 * @author Barrett Desktop
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class Spiral {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        int[][] mat = new int[num][num];

        for (int r = 0; r < num; r++) {
            for (int c = 0; c < num; c++) {
                mat[r][c] = 0;
            }
        }

        int n = 1;
        int r = 0, c = 0, dir = 0;
        while (n <= num * num) {
            mat[r][c] = n;
            if (dir == 0) {
                if (c + 1 < num && mat[r][c + 1] == 0) {
                    c++;
                } else {
                    r++;
                    dir = 1;
                }

            } else if (dir == 1) {
                if (r + 1 < num && mat[r + 1][c] == 0) {
                    r++;
                } else {
                    c--;
                    dir = 2;
                }
            } else if (dir == 2) {
                if (c - 1 >= 0 && mat[r][c - 1] == 0) {
                    c--;
                } else {
                    r--;
                    dir = 3;
                }

            } else if (dir == 3) {
                if (r - 1 >= 0 && mat[r - 1][c] == 0) {
                    r--;
                } else {
                    c++;
                    dir = 0;
                }
            }
            n++;
            printMat(mat);
            System.out.println("r: " + r + "  c: " + c + "  n:" + n + "  dir:" + dir);
            System.out.println("-------------------------------------");
        }
    }

    public static void printMat(int[][] mat) {
        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[0].length; c++) {
                System.out.print(mat[r][c] + "\t");
            }
            System.out.println("");
        }
    }

}
