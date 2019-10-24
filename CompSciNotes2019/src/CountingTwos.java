/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class CountingTwos {
    public static void main(String[] args) throws Exception {
        new CountingTwos();
    }
    public CountingTwos(){
        try {
            System.out.println(processNum(13));
        } catch (Exception e) {
        }
    
    }
    public int processNum(int num){
        String s=""; 
        for (int i = 0; i <= num; i++) {
            s+=i;
            s=s.replaceAll("0", "").replaceAll("3", "").replaceAll("1", "").replaceAll("4", "").replaceAll("5", "").replaceAll("6", "").replaceAll("7", "").replaceAll("8", "").replaceAll("9", "");
        }
        return (s.length());
    }

    

}