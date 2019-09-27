/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class InputAndOutput {
    public static void main(String[] args) throws Exception {
        System.out.print("Please type your name:  ");
        Scanner kb=new Scanner(System.in);
        String name=kb.nextLine();
        System.out.println("Welcome to Computer Science, "+name);
        System.out.print("Please enter your birthday in MM-DD-YYYY: ");
        Scanner numberScanner=new Scanner(kb.nextLine().replaceAll("-", " "));
        int month=numberScanner.nextInt();
        int day=numberScanner.nextInt();
        int year=numberScanner.nextInt();
        int daysOld=(int)Math.round((2019-year)*365.25)-(month*30+day)+(8*30+26);
        System.out.println("You are about "+daysOld+" days old");
        Date date=new Date();
        
        
        
        
    }

}