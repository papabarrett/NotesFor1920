/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class MoreVariables {
    public static void main(String[] args) throws Exception {
        //make a program to trade names in a sentence
        int num; double decimal; long number; short numb; //basic data types
        char letter; boolean condition;                   //no actions
        Scanner scan=new Scanner(System.in);   //Scanner is a class
              //scan is an object. Objects can have actions and their own variables
        System.out.println("Please type a sentence below: ");
        String sentence = scan.nextLine();
        System.out.println("What name would you like replaced? ");
        String nameToReplace = scan.nextLine();
        System.out.println("What would you like to put in the place of \""+
                    nameToReplace+"\"?");
        String replacingWord=scan.nextLine();
        String anotherSentence;
        System.out.println(anotherSentence=sentence.replaceAll(nameToReplace, replacingWord));
        System.out.println(sentence + "\n\n\tvs.\n\n"+anotherSentence);
        System.out.println("Yelling: "+sentence.toUpperCase());
        System.out.println("Sentence length: "+sentence.length());
        System.out.println("First half: "+sentence.substring(0, sentence.length()/2));
        System.out.println("Last half: "+sentence.substring(sentence.length()/2));
        JOptionPane.showMessageDialog(null, anotherSentence);
    }

}