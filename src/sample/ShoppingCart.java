package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.*; // hämtar alla klass

//Klass
public class ShoppingC impements Pizza {
    private List<Pizza> pizzasInCart;
    private List<Extras> extrasInCart;
    int orderID;
    double totalPrice;


    //konstruktor
    public ShoppingC(ArrayList<Pizza> pizzas, ArrayList<Extras> extras, int orderID ) //
    {
     pizzasInCart = pi ; //Alla pizzor som användaren valt, läggs till i listan
        extrasInCart = ;// likadant gäller för extras.
        if (orderID>100) {
            orderID = 1;
        }
        this.orderID = orderID;
         //order från varsin användaren

        totalPrice = 0; //Summan av hela köpet
    }
    public ArrayList<Pizza> getPizzas() { // Hämtar och returnerar pizza
    List<Pizza> tempList = new ArrayList<Pizza>();
    tempList = pizzasInCart;
    return tempList;
    }//Pizza

    public ArrayList<Extras> getExtras() { // Hämtar och returnerar extras
    List<Extras> tempList = new ArrayList<Extras>();
    tempList = extrasInCart;
    return tempList;
    }//Extras

    public int getOrderID() { // Retunerar order
        return orderID;
    }//OrderID

    public double getTotalPrice(){ // Programmet räknar totala summan för alla pizzor

    for (Pizza pizza : pizzasInCart) { // räknar ut summan av pizzan

        totalPrice = totalPrice + pizza.getPrice();
    }
    for (Extras extras : extrasInCart) { // räknar ut summan av extras
        totalPrice += extras.getPrice();
    }
    return totalPrice; // Retunerar priset för summan av pizza och extra
    }//TotalPrice

    public setPizzasInCart(ArrayList<Pizza>pizzas){ // för över pizzor till shoppingcart
        pizzasInCart = pizzas;
    }//Setpizzaincart
        public setExtrasCart(ArrayList<Extras>extras{ // för över extras till shoppingcart
            extrasInCart = extras;

        }//Setextrasincart

}//klassen
