
/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class FamilyRunner {

    public static void main(String[] args) throws Exception {
        ArrayList<Family> party = new ArrayList<Family>();
        Family john = new Family("John");
        Family sam = new Family("Sam", john);
        Family tabitha = new Family("Tabitha", john);
        Family caroline = new Family("Caroline", tabitha);
        party.add(john);
        party.add(sam);
        party.add(tabitha);
        party.add(caroline);

        Collections.sort(party);

        for (Family family : party) {
            family.printFullFamily();
            System.out.println("--------------------------");
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int i = 0; i < 10; i++) {
            queue.add((int)( Math.random() * 100));
            System.out.println(queue);
        }
        System.out.println("=========");
        while (queue.size() > 0) {
            int num = queue.poll();
            System.out.println("Pulled "+num);
            if (num % 3 == 0) {
                queue.add((int) (Math.random() * 100));
            }
            System.out.println(queue);

        }
    }
}
