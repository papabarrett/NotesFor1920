
/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class SudokuSolver {

    public static void main(String[] args) throws Exception {
        File f = new File("sudoku1.txt");
        f.createNewFile();
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[][] possible = new ArrayList[9][9];
        Scanner scan = new Scanner(f);
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                int num = scan.nextInt();
                possible[r][c] = new ArrayList<>();
                if (num == 0) {
                    for (int i = 1; i < 10; i++) {
                        possible[r][c].add(i);
                    }
                } else {
                    possible[r][c].add(num);
                }
            }
        }
        int i=0;
        while(!done(possible)) {
            i++;
            System.out.println("Try "+i);
            rowElimination(possible);
        print(possible);
            System.out.println("^Rows---------------------------");
            colElimination(possible);
        print(possible);
            System.out.println("^Cols---------------------------");
            blockElimination(possible);
        print(possible);
            System.out.println("^Blocks---------------------------");
        }

    }

    public static boolean done(ArrayList<Integer>[][] possible) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (possible[r][c].size() > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void rowElimination(ArrayList<Integer>[][] possible) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (possible[r][c].size() == 1) {
                    Integer removePls = possible[r][c].get(0);
                    for (int c1 = 0; c1 < 9; c1++) {
                        if (c != c1) {
                            possible[r][c1].remove(removePls);
                        }
                    }
                }
            }
        }
    }

    public static void print(ArrayList<Integer>[][] possible) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                System.out.print(possible[r][c] + "\t");
            }
            System.out.println("");
        }
    }

    public static void colElimination(ArrayList<Integer>[][] possible) {
        for (int c = 0; c < 9; c++) {
            for (int r = 0; r < 9; r++) {
                if (possible[r][c].size() == 1) {
                    Integer removePls = possible[r][c].get(0);
                    for (int r1 = 0; r1 < 9; r1++) {
                        if (r != r1) {
                            possible[r1][c].remove(removePls);
                        }
                    }
                }
            }
        }
    }

    @SuppressWarnings("deprecation")
    public static void blockElimination(ArrayList<Integer>[][] possible) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (possible[r][c].size() == 1) {
                    Integer removePls = possible[r][c].get(0);
                    for (int r1 = r / 3 * 3; r1 < r / 3 * 3 + 3; r1++) {
                        for (int c1 = c / 3 * 3; c1 < c / 3 * 3 + 3; c1++) {
                            possible[r1][c1].remove(removePls);
                                if(possible[r1][c1].isEmpty())
                                    possible[r1][c1].add(removePls);
                        }
                    }
                }
            }
        }
    }
}
