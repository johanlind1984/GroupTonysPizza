package sample;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Pizza extends Product {

    private OrderStatus orderStatus;
    private ArrayList<Ingredient> includedIngredients;
    private ArrayList<Ingredient> extraIngredients;

    public Pizza(String name, double price) {
        super(name, price);
        this.orderStatus = OrderStatus.ORDER_NOT_TAKEN;
        this.includedIngredients = new ArrayList<>();
        this.extraIngredients = new ArrayList<>();
    }

    public void addIngredientIncluded(Ingredient ingredientToAdd) {
        includedIngredients.add(ingredientToAdd);
    }
    public void addIngredientExtra(Ingredient ingredientToAdd) {
        price += ingredientToAdd.getPrice();
        extraIngredients.add(ingredientToAdd);
    }

    public boolean removeIngredient(Ingredient ingredientToRemove) {
        if(extraIngredients.contains(ingredientToRemove)) {
            extraIngredients.remove(ingredientToRemove);
            price -= ingredientToRemove.getPrice();
            return true;
        } else if (includedIngredients.contains(ingredientToRemove)) {
            includedIngredients.remove(ingredientToRemove);
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

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatusToSet) {
        orderStatus = orderStatusToSet;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        String stringToReturn = name;
        stringToReturn += " " + df.format(price) + " kr" + '\n';

        for (Ingredient ingredient : includedIngredients) {
            stringToReturn += ingredient.getName() + ", ";
        }

        for (Ingredient ingredient : extraIngredients) {
            stringToReturn += ingredient.getName() + ", ";
        }

        return stringToReturn;
    }
}
