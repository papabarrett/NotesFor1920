/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class WritingFiles {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf=new SimpleDateFormat("MMMddyy");
//        System.out.println(sdf.format(new Date()));
        String fileName=sdf.format(new Date())+"nums.txt";
        File f=new File(fileName);
        PrintWriter out;
        if(!f.exists()) //create PrintWriter for fresh file
            out=new PrintWriter(f);
        else    //create PrintWriter to add to end of file
            out=new PrintWriter(new FileWriter(f,true));  
        JSpinner spin=new JSpinner();
        JOptionPane.showMessageDialog(null, spin);
        int num=(int)(spin.getValue());
        out.println(num);
        out.close(); //PrintWriter flushes when it closes (if only toilets did that)
        
        //close PrintWriters before you scan the file they are writing
        Scanner scan=new Scanner(f);
        int total=0, count=0;
        while(scan.hasNext()){
            total+=scan.nextInt();
            count++;
        }
        String message="You have run the program "+count+" times and have a total"+
                " of "+total;
        JOptionPane.showMessageDialog(null, message);
        
        
    }

}