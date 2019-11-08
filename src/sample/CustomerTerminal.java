package sample;
import java.util.ArrayList;

public class CustomerTerminal {

    //* AUTHOR: JOHAN LIND* //

    private final Menu menu;
    private Order order;
    private int orderCount;
    private ArrayList<Pizza> pizzasInShoppingCart;
    private ArrayList<Extras> extrasInShoppingCart;

    public CustomerTerminal() {
        menu = new Menu();
        orderCount = 1;
        order = new Order();
        pizzasInShoppingCart = new ArrayList<>();
        extrasInShoppingCart = new ArrayList<>();
    }

    public boolean addExtraIngredientToPizza(Ingredient ingredientToAdd, Pizza pizzaToAddTo) {
        for (Pizza tempPizza : pizzasInShoppingCart) {
            if(tempPizza.equals(pizzaToAddTo)) {
                tempPizza.addExtraIngredient(ingredientToAdd);
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
        pizzasInShoppingCart.add(new Pizza(pizzaToAddToCart.getName(), pizzaToAddToCart.getPrice(), pizzaToAddToCart.getIncludedIngredients()));
    }

    public boolean removePizzaFromShoppingCart(Pizza pizzaToRemoveFromCart) {
        if(pizzasInShoppingCart.contains(pizzaToRemoveFromCart)) {
            pizzasInShoppingCart.remove(pizzaToRemoveFromCart);
            return true;
        }
        return false;
    }

    public void addExtraToCart(Extras extraToAddToCart) {
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
        order.setExtrasInOrder(extrasInShoppingCart);
        order.setPizzasInOrder(pizzasInShoppingCart);
        order.setOrderNumber(getOrderCount());

        if (order.getTotalPrice() != 0) {
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

    public int getOrderCount() {
        if(orderCount < 100) {
            return orderCount;
        } else {
            orderCount = 1;
            return orderCount;
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
