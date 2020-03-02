
import java.text.DecimalFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author student
 */
public class CerealBox {
    String name;
    int servingsPerBox, calories, caloriesFat;
    private double gramsFat;

    public CerealBox(String name, int servingsPerBox, int calories, int caloriesFat, double gramsFat) {
        this.name = name;
        this.servingsPerBox = servingsPerBox;
        this.calories = calories;
        this.caloriesFat = caloriesFat;
        this.gramsFat = gramsFat;
    }

    public CerealBox() {
        name="No name yet";
        gramsFat=calories=servingsPerBox=caloriesFat=1;
    }
    
    public void printReport(){
        System.out.println(name);
        System.out.println("Servings Per Box:\t"+servingsPerBox);
        System.out.println("Calories/Calories from Fat:\t"+calories+"/"+caloriesFat);
        System.out.println("Calories in Box:\t"+getCalInBox());
        System.out.println("Fat (grams):\t"+new DecimalFormat("0.#").format(gramsFat));
        System.out.println("Fat in Box (grams):\t"+new DecimalFormat("0.#").format(getFatInBox()));
        System.out.println("---------------------------------");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getServingsPerBox() {
        return servingsPerBox;
    }

    public void setServingsPerBox(int servingsPerBox) {
        this.servingsPerBox = servingsPerBox;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getCaloriesFat() {
        return caloriesFat;
    }

    public void setCaloriesFat(int caloriesFat) {
        this.caloriesFat = caloriesFat;
    }

    public double getGramsFat() {
        return gramsFat;
    }

    public void setGramsFat(double gramsFat) {
        this.gramsFat = gramsFat;
    }
    
    public int getCalInBox(){
        return calories*servingsPerBox;
    }
    
    public double getFatInBox(){
        return gramsFat*servingsPerBox;
    }
    
}
