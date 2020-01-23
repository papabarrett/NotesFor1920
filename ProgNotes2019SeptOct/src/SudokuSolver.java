
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
        File f = new File("sudoku3.txt");
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
        print(possible);
        int i = 0;
        while (!done(possible)) {
            i++;
            System.out.println("Try " + i);
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
            ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
            for (int c = 0; c < 9; c++) {
                list.add(possible[r][c]);
            }
            simpleElimination(list);
        }
    }

    public static void simpleElimination(ArrayList<ArrayList<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).size() == 1) {
                Integer removePls = list.get(i).get(0);
                for (int j = 0; j < list.size(); j++) {
                    if (i != j) {
                        list.get(j).remove(removePls);
                    }

                }
            } //start complex removal
            else {
                levelTwoElim(list, i);
                levelThreeElim(list,i);
            }

        }
        levelFourElim(list);
    }

    public static void levelTwoElim(ArrayList<ArrayList<Integer>> list, int i) {
        ArrayList<ArrayList<Integer>> common = new ArrayList<ArrayList<Integer>>();
        common.add(list.get(i));
        for (int j = i + 1; j < list.size(); j++) {
            ArrayList<Integer> other = list.get(j);
            if (other.equals(list.get(i))) {
                common.add(other);
            }
            if (list.get(i).size() == common.size()) {
                for (int k = 0; k < list.size(); k++) {
                    ArrayList<Integer> target = list.get(k);
                    if (!common.contains(target)) {
                        for (Integer integer : common.get(0)) {
                            target.remove(integer);
                        }
                    }

                }
            }
        }
    }

    public static void levelThreeElim(ArrayList<ArrayList<Integer>> list, int i) {
        ArrayList<ArrayList<Integer>> common = new ArrayList<ArrayList<Integer>>();
        common.add(list.get(i));
        HashSet<Integer> set = new HashSet<Integer>(list.get(i));
        HashSet<Integer> jTried=new HashSet<Integer>();
        jTried.add(i);
        while(jTried.size()<list.size()) 
        {
            int j=(int)(Math.random()*list.size());
            if (jTried.contains(j)) {
                continue;
            }
            jTried.add(j);
            ArrayList<Integer> other = list.get(j);
            if (other.size() <= set.size()) {
                common.add(other);
                set.addAll(other);
                if (set.size() == common.size()) {
                    for (int k = 0; k < list.size(); k++) {
                        ArrayList<Integer> target = list.get(k);
                        if (!common.contains(target)) {
                            for (Integer integer : set) {
                                target.remove(integer);
                            }
                        }
                    }
                }
            }

        }
    }
    
    public static void levelFourElim(ArrayList<ArrayList<Integer>> list){
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<Integer,ArrayList<Integer>>();
        for (int i = 0; i < 10; i++) {
            map.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                map.get(list.get(i).get(j)).add(i);
            }            
        }
        for (Integer integer : map.keySet()) {
            ArrayList<Integer> solos=map.get(integer);
            if(solos.size()==1){
                if(list.get(solos.get(0)).size()==1) continue;
                System.out.println("Only "+integer+"   "+list);
                for (int i = 0; i < list.size(); i++) {
                    ArrayList<Integer> other = list.get(i);
                    other.remove(integer);
                }
                list.get(solos.get(0)).clear();
                list.get(solos.get(0)).add(integer);
                System.out.println("AFTER Only "+integer+"   "+list);
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
            ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
            for (int r = 0; r < 9; r++) {
                list.add(possible[r][c]);
            }
            simpleElimination(list);
        }
    }

    @SuppressWarnings("deprecation")
    public static void blockElimination(ArrayList<Integer>[][] possible) {
        for (int r = 0; r < 9; r += 3) {
            for (int c = 0; c < 9; c += 3) {
                ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
                for (int r1 = r; r1 < r + 3; r1++) {
                    for (int c1 = c; c1 < c + 3; c1++) {
                        list.add(possible[r1][c1]);
                    }
                }
                simpleElimination(list);
            }
        }
    }
}
