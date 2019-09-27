
/**
 *
 * @author J. Barrett
 */
import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class IfStatementFun {

    public static void main(String[] args) throws Exception {
        new IfStatementFun();
    }

    String time;
    int mins, hrs;

    public IfStatementFun() {
        time = "";
        do {
            time = JOptionPane.showInputDialog("What time will the train arrive? [Format: 09:05 am]");
            time = time.trim();
        } while (!time.matches("[0-1]?[0-9]:[0-5][0-9] [ap]m"));
        String[] timePieces=time.substring(0, time.length()-3).split(":");
        hrs=new Integer(timePieces[0])%12;
        mins=new Integer(timePieces[1]);
        if(time.contains("p"))
            hrs+=12;
        printTime();
        if(hrs<8)
            System.out.println("It is before working hours");
        else if(hrs>16)
            System.out.println("It is after working hours");
        else if(hrs==12)
            System.out.println("Enjoy your lunch");
        else
            System.out.println("Get to work");
        //attendance is the first and last 5 mins of each hour
        if(mins>54 || mins<6)
            System.out.println("Attendance Window");
        switch(hrs){
            case 8: System.out.println("Start of the day");
            case 9:  System.out.println("It's the first quarter of the day.");
            break;
            case 10:
            case 11: System.out.println("It's the second quarter of the day.");
            break;
            default: System.out.println("It's not morning-work time.");
        }
        int rate=(hrs>16)?15:13;  //condition?true:false;
        System.out.println("The rate is "+rate);
    }

    public void printTime() {
        System.out.println(time);
        System.out.println(hrs + " hours and "+mins+" mins");
    }

}
