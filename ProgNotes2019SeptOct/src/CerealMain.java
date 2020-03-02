/**
 *
 * @author Barrett Desktop
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class CerealMain {
    public static void main(String[] args) throws Exception {
        CerealBox luckyCharms=new CerealBox();
        luckyCharms.name="Lucky Charms";
        luckyCharms.calories=130;
        luckyCharms.servingsPerBox=17;
        luckyCharms.caloriesFat=10;
        luckyCharms.setGramsFat(1);
        CerealBox frostedFlakes=new CerealBox();
        CerealBox cheerios=new CerealBox("Cheerios",16,100,15,2.2);
        frostedFlakes.name="Frosted Flakes";
        frostedFlakes.calories=100;
        frostedFlakes.servingsPerBox=10;
        frostedFlakes.caloriesFat=0;
        frostedFlakes.setGramsFat(0);
        luckyCharms.printReport();
        frostedFlakes.printReport();
        cheerios.printReport();
    }

}