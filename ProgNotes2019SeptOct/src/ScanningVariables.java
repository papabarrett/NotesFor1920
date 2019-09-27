
/**
 *
 * @author J. Barrett
 */
import java.util.*;
import java.lang.*;

public class ScanningVariables {

    public static void main(String[] args) throws Exception {
        System.out.print("Please enter two numbers: ");
        Scanner scan = new Scanner(System.in);    //make a new Scanner called scan
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int total = num1 + num2;
        System.out.println("The sum of the two numbers is " + total + ".");
        double money = total * .05;
        System.out.println("The value of " + total + " nickels is " + money + ".");
        char letter = ' ';
        System.out.print("Please enter a message: "); 
        scan.nextLine();  //absorbs the enter from the two numbers
        String message = scan.nextLine();
        money = message.length() * .05;
        System.out.println("At 5 cents a character, the message \"" + message
                + "\" will cost " + money);

    }

}
