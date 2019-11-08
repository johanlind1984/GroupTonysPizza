package sample;

import java.util.ArrayList;

// Written by Tadevos
public class Pizza {

    private String name;
    private double price;
    private int ordernumber;
    private ArrayList<Ingredient> includedIngredients;
    private ArrayList<Ingredient> extraIngredients;

    public Pizza(String name, double price) {
        this.name = name;
        this.price = price;
        this.ordernumber = 0;
    }

    public void addIngredientIncluded(Ingredient ingredientToAdd) {
        includedIngredients.add(ingredientToAdd);
    }
    public void addIngredientExtra(Ingredient ingredientToAdd) {
        extraIngredients.add(ingredientToAdd);
    }

    public boolean removeIngredient(Ingredient ingredientToRemove) {
        if(extraIngredients.contains(ingredientToRemove)) {
            extraIngredients.remove(ingredientToRemove);
            return true;
        } else if (includedIngredients.contains(ingredientToRemove)) {
            extraIngredients.remove(ingredientToRemove);
            return true;
        }

        return false;
    }

    public ArrayList<Ingredient> getIncludedIngredients() {
        return includedIngredients;
    }

    public ArrayList<Ingredient> getExtraIngredients() {
        return extraIngredients;
    }

    public int getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(int ordernumber) {
        this.ordernumber = ordernumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        String stringToReturn = name;
        stringToReturn += "\t" + price + "kr" + "\n";

        for (Ingredient ingredient : includedIngredients) {
            stringToReturn += ingredient.getName() + ", ";
        }

        for (Ingredient ingredient : extraIngredients) {
            stringToReturn += ingredient.getName() + ", ";
        }

        return stringToReturn;
    }
}
