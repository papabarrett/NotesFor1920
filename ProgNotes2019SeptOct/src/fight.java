
/**
 *
 * @author J. Barrett
 */
import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class fight {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("fight.dat"));
        int num=scan.nextInt();

        for (int i = 0; i < num; i++) {
            System.out.println("BATTLE "+(i+1));
           playBattle(scan); 
        }
        
    }

    public static void playBattle(Scanner scan) {
        int php = scan.nextInt(), pw = scan.nextInt(), pa = scan.nextInt();
        int mhp = scan.nextInt(), mw = scan.nextInt(), ma = scan.nextInt();
        while (php > 0 && mhp > 0) {
            int playerDamage = (php + pw) - (mhp + ma);
            if (playerDamage <= 0) {
                playerDamage = (int) Math.ceil((php + pw) / 10.0);
            }
            mhp -= playerDamage;
            System.out.println("The player attacks the monster for " + playerDamage + " damage!");
            if (mhp <= 0) {
                System.out.println("The monster has been slain!");
            }
            int monsterDamage = (mhp + mw) - (php + pa);
            if (monsterDamage <= 0) {
                monsterDamage = (int) Math.ceil((mhp + mw) / 10.0);
            }
            php -= monsterDamage;
            if (mhp > 0) {
                System.out.println("The monster attacks the player for " + monsterDamage + " damage!");
                if (php <= 0) {
                    System.out.println("The player has been slain!");
                }
            }
        }
    }

}
