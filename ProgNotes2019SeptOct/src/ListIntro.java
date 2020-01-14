/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class ListIntro {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list=new ArrayList<String>();  //make an ArrayList of 
                                //Strings called list that is empty
        list.add("Joel");
        list.add("Kindall");
        list.add("Tylar");
        System.out.println(list);
        list.add(1, "Chelbi");
        System.out.println(list);
        list.set(2, "Chace");
        System.out.println("1: "+list);
        ArrayList<String> list2=new ArrayList<String>(list);
        list2.remove("Joel");
        list2.add("Kindall");
        list2.add("Branden");
        printLists(list, list2);
        list.addAll(list2);
        printLists(list,list2);        
        list.retainAll(list2);
        printLists(list,list2);
        System.out.println(list.contains("Tylar"));
        //2 loops
        for (int i = 0; i < list.size(); i++) {  //forl tab
            String get = list.get(i);
            System.out.println(get);
        }
        System.out.println("---------");
        for (String word : list2) {   //fore tab
            //for each loop. Each String in list2 will get a turn to be the word.           
            
            System.out.println(word.charAt(1));
            
        }
        
    }

    public static void printLists(ArrayList<String> list, ArrayList<String> list2) {
        System.out.println("-------------------------------------");
        System.out.println("1: "+list);
        System.out.println("2: "+list2);
    }

}