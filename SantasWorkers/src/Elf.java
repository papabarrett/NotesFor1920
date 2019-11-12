/**
 *
 * @author J. Barrett
 * To Do:
 * 1) write findHighestValueGift
 * 2) write createPathToGift 
 * 3) write createPathHome
 * 4) write move so that 
 *  a)if he is at home, he finds the highest value gift and starts on that path
 *  b)if he is on a path, he finishes it
 *  c)if he just finished his path to a gift, have him create a path home 
 *              (a gift could have spawned to block his way)
 */

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class Elf extends DrawableRectangle{
    LinkedList path;   

    public Elf() {
        super(0, 0, "elf.jpg");
    }

    public void move(Collection<DrawableRectangle> list, char[][] map) {

        updatePosition();
    }

    @Override
    public char getSymbol() {
        return 'e';
    }

    public Collection getPath() {
        return path;
    }

    //given the list, find the gift with the highest value. 
    //if there is no gift in the list, return null
    public Gift findHighestValueGift(Collection<DrawableRectangle> list){
        return null;
    }
    
    //create a path to the targeted gift that walks around rocks and current gifts 
    //but assume the elf may step over gifts generated while he is traveling on his path
    public LinkedList createPathToGift(Gift gift, char[][] map){
        return null;
    }
    
    //create a path to 0,0 that walks around rocks and current gifts but assume the elf
    //may step over gifts generated while he is traveling on his path
    public LinkedList createPathHome(char[][] map){
        return null;
    }

}