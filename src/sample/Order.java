package sample;

import java.util.ArrayList;

public class Order {
    private ArrayList<Pizza> pizzasInCart;
    private ArrayList<Extra> extrasInCart;
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

    public ArrayList<Extra> getExtras() {
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
            if(!pizza.getOrderStatus().equals(OrderStatus.ORDER_IS_COMPLETE)) {
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

        for (Extra extra : extrasInCart) {
            totalPriceOfOrder += extra.getPrice();
        }
        return totalPriceOfOrder;
    }

    public void setPizzasInOrder(ArrayList<Pizza> pizzas){
        pizzasInCart = pizzas;
    }

    public void setExtrasOrder(ArrayList<Extra> extras) {
        extrasInCart = extras;
    }

    private String getStringForOrderStatusPizza(Pizza pizza) {
        if(pizza.getOrderStatus().equals(OrderStatus.ORDER_NOT_TAKEN)) {
            return "Pizzan väntar på bagare";
        } else if(pizza.getOrderStatus().equals(OrderStatus.ORDER_IS_PREPARING_FOR_OVEN)) {
            return "Pizzan förbereds för ugnen";
        } else if(pizza.getOrderStatus().equals(OrderStatus.ORDER_IS_IN_OVEN)) {
            return "Pizzan är i ugnen";
        } else if(pizza.getOrderStatus().equals(OrderStatus.ORDER_IS_COMPLETE)) {
            return "Pizzan är klar";
        } else {
            return "-1";
        }
    }

    private String getStringForOrderStatusOrder() {
        if(isOrderComplete())
            return  "\n\tOrder klar\n";
        else
            return  "\n\tOrder förbereds";
    }

    @Override
    public String toString() {
        String stringToReturn = orderID + "\n\t";

        for (Pizza pizza : pizzasInCart) {

            String orderStatusString = " | " + getStringForOrderStatusPizza(pizza);
            stringToReturn += pizza.getName() + " " + orderStatusString + "\n\tExtras Ingredienser:";

            for (Ingredient ingredient : pizza.getExtraIngredients()) {
                stringToReturn += "+" + ingredient.getName();
            }
            stringToReturn += "\n\t";
        }

        stringToReturn += "\n\t";

        for (Extra extra : extrasInCart) {
            stringToReturn += extra.getName() + ", ";
        }

        stringToReturn += getStringForOrderStatusOrder();


        return stringToReturn;
    }
}
