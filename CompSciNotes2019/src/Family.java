
/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class Family implements Comparable {

    LinkedList<Family> ancestors;
    LinkedList<Family> kids;
    String name;

    public Family(String name, Family parent) {
        ancestors=new LinkedList(parent.ancestors);
        ancestors.add(parent);
        parent.addKid(this);
        this.name = name;
        kids=new LinkedList<Family>();
    }

    public Family(String name) {
        this.name = name;
        ancestors = new LinkedList<Family>();
        kids=new LinkedList<Family>();
    }
    public void printFullFamily(){
        System.out.println(name);
        for (Family kid : kids) {
            System.out.println("Kid: "+kid.name);
        }
        if(!ancestors.isEmpty()){
            ancestors.get(ancestors.size()-1).printFullFamily();
        }
        
    }
    public void addKid(Family person){
        kids.add(person);
    }

    @Override
    public int compareTo(Object arg0) {
        Family other=(Family)arg0;
        if(other.kids.size()>kids.size())
            return 1;
        if(kids.size()==other.kids.size())
            return 0;
        else
            return -1;
    }

}
