package sample;
import java.util.ArrayList;

public class CustomerTerminal {

    //* AUTHOR: JOHAN LIND* //

    private final Menu menu;
    private Order order;
    private int orderID;
    private ArrayList<Pizza> pizzasInShoppingCart;
    private ArrayList<Extras> extrasInShoppingCart;

    public CustomerTerminal() {
        menu = new Menu();
        orderID = 1;
        order = new Order();
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

    public boolean checkOutShoppingCart() {
        order.setExtrasOrder(extrasInShoppingCart);
        order.setPizzasInOrder(pizzasInShoppingCart);

        if (orderID>100) {
            orderID = 1;
        }

        order.setOrderID(orderID);

        if (order.getTotalPriceOfOrder() != 0) {
            if (CardReader.processPayment()) {
                return true;
            }
        }
        return false;
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
            orderID = 1;
            return orderID;
        }

    }

    public ArrayList<Pizza> getPizzasInShoppingCart() {
        return pizzasInShoppingCart;
    }

    public ArrayList<Extras> getExtrasInShoppingCart() {
        return extrasInShoppingCart;
    }

    public void clearShoppingCartsAndOrder() {
        order = new Order();
        pizzasInShoppingCart = new ArrayList<Pizza>();
        extrasInShoppingCart = new ArrayList<Extras>();
    }
}
