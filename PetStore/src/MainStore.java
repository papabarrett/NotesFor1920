/**
 *
 * @author J. Barrett
 */

import java.lang.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class MainStore {
    public static void main(String[] args) throws Exception {
        Pet fred;
        fred=new Parrot("Fred",new GregorianCalendar(11,12,2018).getTime());
    //    fred=new Snake("Fred",new GregorianCalendar(11,12,2018).getTime());
        fred.speak();
        if(fred instanceof Snake)
            System.out.println(((Snake)fred).getAntidote());
        
        ArrayList<Pet> list;
        list=new ArrayList<Pet>();
        for (int i = 0; i < 10; i++) {
            if(Math.random()<.4)
                list.add(new Parrot("Stale Chicken "+i,new GregorianCalendar(11,12,2018).getTime()));
            else
                list.add(new Snake("Hufflepuff Mascot"+i,new GregorianCalendar(11,12,2018).getTime()));
        }
        
        for (int i = 0; i < list.size(); i++) {
            Pet get = list.get(i);
            
            if(get instanceof Venomous)
                System.out.println(((Pet)get).getName()+" "+((Venomous) get).getAntidote());
        }
    }

}