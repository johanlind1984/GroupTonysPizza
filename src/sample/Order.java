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
        if(pizzasInCart.isEmpty()) {
            return true;
        }

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

    private String getStringForOrderStatus(Pizza pizza) {
        if(pizza.getOrderStatus() == 0) {
            return "Pizzan väntar på bagare";
        } else if(pizza.getOrderStatus() == 1) {
            return "Pizzan förbereds för ugnen";
        } else if(pizza.getOrderStatus() == 2) {
            return "Pizzan är i ugnen";
        } else if(pizza.getOrderStatus() == 3) {
            return "Pizzan är klar";
        } else {
            return "-1";
        }
    }

    @Override
    public String toString() {
        String stringToReturn = orderID + "\n\t";

        for (Pizza pizza : pizzasInCart) {

            String orderStatusString = " | " + getStringForOrderStatus(pizza);
            stringToReturn += pizza.getName() + " " + orderStatusString + "\n\tExtras Ingredienser:";

            for (Ingredient ingredient : pizza.getExtraIngredients()) {
                stringToReturn += "+" + ingredient.getName();
            }
            stringToReturn += "\n\t";
        }

        stringToReturn += "\n\t";

        for (Extras extra : extrasInCart) {
            stringToReturn += extra.getName() + ", ";
        }
<<<<<<< HEAD

        if(isOrderComplete) {
            stringToReturn += "\n\tOrder Redo för utlämning";
        } else {
            stringToReturn += "\n\tOrder inte klar";
        }
=======
        if(isOrderComplete())
        stringToReturn += "\n\tOrder klar\n";
        else
            stringToReturn+= "\n\tOrder förbereds";
>>>>>>> Commiters

        return stringToReturn;
    }
}
