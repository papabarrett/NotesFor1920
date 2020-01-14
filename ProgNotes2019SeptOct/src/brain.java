
/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class brain {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("brain.dat"));
        int num = scan.nextInt();
        for (int i = 0; i < num; i++) {
            processLine(scan);
        }
    }

    public static void processLine(Scanner scan) {
        String word = scan.next();
        String word2 = scan.next();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == word2.charAt(i)) {
                System.out.print(word.charAt(i));
            } else {
                System.out.print("*");
            }
        }
        System.out.println("");
    }

}
