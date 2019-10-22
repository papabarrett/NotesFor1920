
/**
 *
 * @author J. Barrett
 */
import java.util.*;
import java.io.*;
import java.lang.*;
import java.text.DecimalFormat;

public class DoFiles {

    public static void main(String[] args) throws Exception {
        File f = new File("input.txt");
        f.createNewFile();

        Scanner scan = new Scanner(f);
        
        do{
        processText(scan);
        }while(scan.hasNext());
        

    }

    public static void processText(Scanner scan) {
        String shortWord, longWord, currentWord;
        double wordCount = 0, letterCount = 0;
        shortWord = longWord = currentWord = scan.next();
        do {
            currentWord = scan.next();
            if (!currentWord.startsWith("-")) {
                // System.out.println("+++Scanning " + currentWord);
                wordCount++;
                letterCount += currentWord.length();
                if (currentWord.length() > longWord.length()) {
                    longWord = currentWord;
                }
                if (currentWord.length() < shortWord.length()) {
                    shortWord = currentWord;
                }
            }
        } while (!currentWord.equals("---"));
        //do-while is only loop with semi-colon
        System.out.println("The longest word is " + longWord);
        System.out.println("The shortest word is " + shortWord);
        System.out.println("The average word length is "+
                new DecimalFormat("0.0").format((letterCount/wordCount)));
        System.out.println("-----------------------------------");
    }

}
