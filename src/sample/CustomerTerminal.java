package sample;
import java.util.ArrayList;

public class CustomerTerminal {

    //* AUTHOR: JOHAN LIND* //

    private final Menu menu;
    private Order order;
    private int orderID;
    private int totalPriceOfShoppingCart;
    private ArrayList<Pizza> pizzasInShoppingCart;
    private ArrayList<Extras> extrasInShoppingCart;

    public CustomerTerminal() {
        menu = new Menu();
        orderID = 1;
        order = new Order();
        totalPriceOfShoppingCart = 0;
        pizzasInShoppingCart = new ArrayList<>();
        extrasInShoppingCart = new ArrayList<>();
    }

    public boolean addExtraIngredientToPizza(Ingredient ingredientToAdd, Pizza pizzaToAddTo) {
        for (Pizza tempPizza : pizzasInShoppingCart) {
            if(tempPizza.equals(pizzaToAddTo)) {
                tempPizza.addIngredientExtra(ingredientToAdd);
                return true;
            }
        }
        return false;
    }

    public boolean removeIngredientFromPizza(Ingredient ingredientToRemove, Pizza pizzaToRemoveFrom) {
        for (Pizza tempPizza : pizzasInShoppingCart) {
            if(tempPizza.equals(pizzaToRemoveFrom)) {
                tempPizza.removeIngredient(ingredientToRemove);
                return true;
            }
        }
        return false;
    }

    public void addPizzaToShoppingCart(Pizza pizzaToAddToCart) {
        pizzasInShoppingCart.add(new Pizza(pizzaToAddToCart.getName(), pizzaToAddToCart.getPrice()));
    }

    public boolean removePizzaFromShoppingCart(Pizza pizzaToRemoveFromCart) {
        if(pizzasInShoppingCart.contains(pizzaToRemoveFromCart)) {
            pizzasInShoppingCart.remove(pizzaToRemoveFromCart);
            return true;
        }
        return false;
    }

    public void addExtraToShoppingCart(Extras extraToAddToCart) {
        extrasInShoppingCart.add(extraToAddToCart);
    }

    public boolean removeExtraFromCart(Extras extraRemoveFromCart) {
        if(extrasInShoppingCart.contains(extraRemoveFromCart)) {
            extrasInShoppingCart.remove(extraRemoveFromCart);
            return true;
        }
        return false;
    }

    public int getTotalPriceOfShoppingCart() {
        int priceToReturn = 0;

        for (Pizza pizza : pizzasInShoppingCart) {
            priceToReturn += pizza.getPrice();
            for (Ingredient extraIngredient : pizza.getExtraIngredients()) {
                priceToReturn += extraIngredient.getPrice();
            }
        }

        for (Extras extra : extrasInShoppingCart) {
            priceToReturn += extra.getPrice();
        }

        return priceToReturn;
    }

    public boolean checkOutShoppingCart() {
        if(pizzasInShoppingCart.isEmpty() && extrasInShoppingCart.isEmpty()) {
            return false;
        } else {
            order.setExtrasOrder(extrasInShoppingCart);
            order.setPizzasInOrder(pizzasInShoppingCart);
            order.setOrderID(orderID);

            if (order.getTotalPriceOfOrder() != 0) {
                if (CardReader.processPayment()) {
                    // Add call to flush all lists and prepare terminal for next customer.
                    return true;
                }
            }
        }
        return true;
    }

    public Menu getMenu() {
        return menu;
    }

    public Order getOrder() {
        return order;
    }

    public int getOrderID() {
        if(orderID < 100) {
            return orderID;
        } else {
            orderID = 0;
            return orderID;
        }

    }

    public ArrayList<Pizza> getPizzasInShoppingCart() {
        return pizzasInShoppingCart;
    }

    public ArrayList<Extras> getExtrasInShoppingCart() {
        return extrasInShoppingCart;
    }

    public ArrayList<Product> getShoppingCart() {
        ArrayList<Product> listToReturn = new ArrayList<>(pizzasInShoppingCart);
        listToReturn.addAll(extrasInShoppingCart);
        return listToReturn;

    }

    public void clearShoppingCartsAndOrder() {
        order = new Order();
        pizzasInShoppingCart = new ArrayList<Pizza>();
        extrasInShoppingCart = new ArrayList<Extras>();
        orderID = getOrderID() + 1;
        totalPriceOfShoppingCart = 0;
    }
}
