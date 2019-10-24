/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class Parrot extends Pet{

    public Parrot(String n, Date b) {
        super(n, b);
    }

    @Override
    public void speak() {
        System.out.println(name+" says \"CRACKER\"");
    }
    
    public void fly(){
        System.out.println("Wheeeeee!!");
    }

}