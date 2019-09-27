/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class AdvancedStringHandling {
    public static void main(String[] args) throws Exception {
        File file=new File("difficult.txt");
        file.createNewFile();
        Scanner scan=new Scanner(file);
        String line=scan.nextLine();
        
        String[] pieces=line.split(",");
        String name=pieces[0];
        double[] numbers=new double[pieces.length-1]; //the first one was the name
        for (int i = 0; i < numbers.length; i++) {
            numbers[i]=new Double(pieces[i+1]);
        }
        
        //if you don't want to use split
        Scanner lineScanner=new Scanner(line);
        lineScanner.useDelimiter(",");
        String nameForList=lineScanner.next();
        ArrayList<Double> list=new ArrayList<Double>();
        while(lineScanner.hasNextDouble()){
            list.add(lineScanner.nextDouble());
        }
        System.out.println("hello TO THE woRLD my Friend".replaceAll("[A-Z]{2,}", ""));
        System.out.println("ABCDEFGHIJ".substring(3,5)); //what will print?
        System.out.println("The cat wants to sit with the ants all day.".lastIndexOf("ants"));
        
        ArrayList<String> list2=new ArrayList<String>();
        list2.add(removeThe("The Lion King"));
        list2.add(removeThe("Toy Story"));
        list2.add(removeThe("The Incredibles"));
        list2.add(removeThe("Batman"));
        
        System.out.println(list2);
        
        Collections.sort(list2);
        
        for (String string : list2) {
            System.out.println(printMovie(string));
        }
        
        
        
    }
    
    public static String printMovie(String s){
        if(s.endsWith("f43edj"))
            return ("The "+s.substring(0,s.length()-6));
        else
            return s;
    }
    public static String removeThe(String s){
        if(s.startsWith("The "))
            return s.substring(4)+"f43edj";
        else
            return s;
    }

}