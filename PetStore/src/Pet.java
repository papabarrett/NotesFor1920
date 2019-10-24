/**
 *
 * @author J. Barrett
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public abstract class Pet {
    String name;
    Date birthday;
    
    public Pet(String n, Date b){
        birthday=b;
        name=n;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    public abstract void speak();
    
    public int getAge(){
        Date now=new Date();
        long milliOld=now.getTime()-birthday.getTime();
        return (int)Math.floor(milliOld/1000/60/60/24/365.25);
    }

}