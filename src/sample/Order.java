package sample;

import java.util.ArrayList;

public class Order {
    private ArrayList<Pizza> pizzasInCart;
    private ArrayList<Extras> extrasInCart;
    private int orderID;
    private double totalPriceOfOrder;
    private boolean isOrderComplete;

    public Order()
    {
        pizzasInCart = new ArrayList<>() ;
        extrasInCart = new ArrayList<>();
        totalPriceOfOrder = 0;
        this.orderID = 0;
        isOrderComplete = false;
    }

    public ArrayList<Pizza> getPizzas() {
        return pizzasInCart;
    }

    public ArrayList<Extras> getExtras() {
        return extrasInCart;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public boolean isOrderComplete() {
        boolean isAllPizzaDone = true;

        for (Pizza pizza : pizzasInCart) {
            if(pizza.getOrderStatus() != 3) {
                isAllPizzaDone = false;
            }
        }
        isOrderComplete = isAllPizzaDone;
        return isAllPizzaDone;
    }

    public int getOrderID() { // Retunerar order
        return orderID;
    }

    public double getTotalPriceOfOrder(){

        for (Pizza pizza : pizzasInCart) {
            totalPriceOfOrder += pizza.getPrice();
        }

        for (Extras extras : extrasInCart) {
            totalPriceOfOrder += extras.getPrice();
        }
        return totalPriceOfOrder;
    }

    public void setPizzasInOrder(ArrayList<Pizza> pizzas){
        pizzasInCart = pizzas;
    }

    public void setExtrasOrder(ArrayList<Extras> extras) {
        extrasInCart = extras;
    }

    @Override
    public String toString() {
        String stringToReturn = orderID + "\n\t";

        for (Pizza pizza : pizzasInCart) {
            stringToReturn += pizza.getName() + " " + pizza.getOrderStatus() + "\n\tExtras Ingredients:";
            for (Ingredient ingredient : pizza.getExtraIngredients()) {
                stringToReturn += "+" + ingredient.getName();
            }
            stringToReturn += "\n\t";
        }

        stringToReturn += "\n\t";

        for (Extras extra : extrasInCart) {
            stringToReturn += extra.getName() + ", ";
        }

        stringToReturn += "\n\tOrder Done: " + isOrderComplete + "\n";

        return stringToReturn;
    }
}
