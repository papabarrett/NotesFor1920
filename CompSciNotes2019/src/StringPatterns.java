/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class StringPatterns {
    public static void main(String[] args) throws Exception {
        String password="freg0r7";
        System.out.println(password.matches("[gfw].*"));
        System.out.println(password.matches(".*[a-z].*"));
        System.out.println(password.matches(".*[A-Z].*"));
        System.out.println(password.matches(".*[0-9].*"));
    }

}