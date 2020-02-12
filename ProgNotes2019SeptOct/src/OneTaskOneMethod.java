/**
 *
 * @author Barrett Desktop
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class OneTaskOneMethod {
    public static void main(String[] args) throws Exception {
        //Example of static vs non static
//        System.out.println("4");
//        Scanner scan=new Scanner(System.in);
//        int num=scan.nextInt();
//      Using getRoll()
//        System.out.println(getRoll()+" "+getRoll());
//        System.out.println(getRoll());
//        getRoll();
//        getRoll();
//        getRoll();
//        System.out.println(getGrade(2,3));
//        System.out.println(getGrade(3,4));
//        System.out.println(getGrade2(2,3));
//        System.out.println(getGrade2(3,4));
//        System.out.println(getLetterGrade(95));
//        System.out.println(getLetterGrade(85));
//        System.out.println(getLetterGrade(75));
//        System.out.println(getLetterGrade(55));
//        System.out.println("------------------");
//        System.out.println(getDetailedLetterGrade(getGrade(25,28)));
//        System.out.println(getGrade(25,28));
         for (int i = 0; i <= 50; i++) {
            printReport(i);
        }
    }
    public static int getRoll(){
        int num=(int)(6*Math.random()+1);
        System.out.println("Rolling");
        return num;        
    }
    public static int getGrade(int correct, int questions){
        double percentCorrect=((double)correct)/questions;
        int grade=(int)(100*percentCorrect+.5); //or (int)Math.ceil()
        return grade;
    }    
    public static int getGrade2(int correct, int questions){
        return (int)(1.0*correct*100/questions+.5);
    }
    public static char getLetterGrade(int grade){
//        System.out.println("------------------");
//        System.out.println("Looking at "+grade);
        if(grade>=90)
            return 'A';
//        System.out.println("Looking for a B");
        if(grade>=80)
            return 'B';
//        System.out.println("Looking for a C");
        if(grade>=70)
            return 'C';
        return 'F';
    }
    public static String getDetailedLetterGrade(int grade){
        if(grade<70) return getLetterGrade(grade)+"";
        if(grade==100) return "A++"; //could return getLetterGrade(grade)+"++";
        if(grade%10>6) return getLetterGrade(grade)+"+";
        if(grade%10<4) return getLetterGrade(grade)+"-";
        return getLetterGrade(grade)+"";
    }
    
    public static void printReport(int questions){ //void means no return, get it done
        if(questions<1) return;
        System.out.println("Report for Test of "+questions+" Questions");
        for (int correct = questions; correct >=0 ; correct--) {
            System.out.println(correct+"\t|\t"+getGrade(correct,questions)+"\t|\t"+
                    getDetailedLetterGrade(getGrade(correct,questions)));
        }
        System.out.println("-----------------------------------------------");
    }
}
/*
Method Task:
a)(int)countVowels: Create a method that counts the number of vowels in a String
b)(double)averageVowels: Create a method that averages the number of vowels in an array of Strings (use a)
c)(String[])toStringArray: Create a method that puts all the words from a file into an array of Strings
d)(double)fileVowels: Create a method that returns the average number of vowels in a file
e)(double)averageLength: Create a method that averages the length of the Strings in an array of Strings
f)(void)FileReport: Create a method that prints the name of a file, the number of words, the average length of the words, and the average number of vowels
*/