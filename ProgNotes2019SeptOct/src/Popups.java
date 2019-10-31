/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class Popups {
    public static void main(String[] args) throws Exception {
        double num1, num2, sum, ans;
        //to show off something, will comment out eventually
       // System.out.println(((int)(Math.random()*10)+1));
        //let's make a program to practice adding 2 digit numbers
        num1=((int)(Math.random()*1000))/100.0;
        num2=((int)(Math.random()*1000))/100.0;
        sum=num1+num2;
        //DecimalFormal "0" means required, "#" means optional
        //standard dollar format "$#,##0.00"
        DecimalFormat df=new DecimalFormat("0.00"); 
        String question="   "+df.format(num1)+"\n"+
                        " + "+df.format(num2);
        
        String response=JOptionPane.showInputDialog(question);
        ans=new Double(response);
        String result="The sum was "+df.format(sum)+"\n"+
                "Your response was "+df.format(ans);
        JOptionPane.showMessageDialog(null, result);
        //hey barrett please accept this i want to be included. - shelby
    }

}
