/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class CalendarTest {
    public static void main(String[] args) throws Exception {
        Date day=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("E");
        Calendar noon=Calendar.getInstance();
        noon.set(Calendar.HOUR_OF_DAY, 12);
        boolean am=day.before(noon.getTime());
        System.out.println(am);
        String tag=am?"AM":"PM";
        System.out.println(sdf.format(day)+tag+".txt");
    }

}