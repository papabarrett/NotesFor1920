/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class Snake extends Pet implements Venomous{

    public Snake(String n, Date b) {
        super(n, b);
    }

    @Override
    public void speak() {
        System.out.println(name+" says HISSSSSSS");

    }

    @Override
    public String getAntidote() {
        return "Vial 10412";
    }

}