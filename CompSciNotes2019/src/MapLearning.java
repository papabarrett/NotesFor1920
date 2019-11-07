/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class MapLearning {
    public static void main(String[] args) throws Exception {
        File f=new File("charges.txt");
        f.createNewFile();
        HashMap <String, ArrayList<Double>> map=new HashMap<String,ArrayList<Double>>();
        Scanner scan=new Scanner(f);
        while(scan.hasNext()){
            String name=scan.next();
            if(map.containsKey(name))
                map.get(name).add(scan.nextDouble());
            else{
                map.put(name, new ArrayList<Double>());
                map.get(name).add(scan.nextDouble());
            }
           // System.out.println(map);
        
        }
        ArrayList<String> list=new ArrayList<String>();
        list.addAll(map.keySet());
        
        Collections.sort(list);
        for (String string : list) {
            System.out.println("Receipt for "+string);
            DecimalFormat df=new DecimalFormat("$#,##0.00");
            double total=0;
            for (int i = 0; i < map.get(string).size(); i++) {
                
            System.out.println(df.format(map.get(string).get(i)));
            total+=map.get(string).get(i);
            }
            System.out.println("Total:");
            System.out.println(df.format(total));
            System.out.println("------------------------------------------");
        }
    }

}