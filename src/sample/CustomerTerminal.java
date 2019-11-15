package sample;
import java.util.ArrayList;
import java.util.Random;

public class CustomerTerminal {

    private final Menu menu;
    private Order order;
    private int orderID;
    int terminalID;
    private int totalPriceOfShoppingCart;
    private ArrayList<Pizza> pizzasInShoppingCart;
    private ArrayList<Extra> extrasInShoppingCart;

    public CustomerTerminal() {
        terminalID = 1;
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

    private Pizza createUniqueCopyOfPizza(Pizza pizzaToMakeCopyOf) {
        Pizza copyOfPizza = new Pizza(pizzaToMakeCopyOf.getName(), pizzaToMakeCopyOf.getPrice());

        for (Ingredient ingredient : pizzaToMakeCopyOf.getIncludedIngredients()) {
            copyOfPizza.addIngredientIncluded(ingredient);
        }

        for (Ingredient ingredient : pizzaToMakeCopyOf.getExtraIngredients()) {
            copyOfPizza.addIngredientIncluded(ingredient);
        }

        return copyOfPizza;
    }

    public void addPizzaToShoppingCart(Pizza pizzaToAddToCart) {
        Pizza copyOfPizzaToAdd = createUniqueCopyOfPizza(pizzaToAddToCart);
        pizzasInShoppingCart.add(copyOfPizzaToAdd);
    }

    public boolean removePizzaFromShoppingCart(Pizza pizzaToRemoveFromCart) {
        if(pizzasInShoppingCart.contains(pizzaToRemoveFromCart)) {
            pizzasInShoppingCart.remove(pizzaToRemoveFromCart);
            return true;
        }
        return false;
    }

    public void addExtraToShoppingCart(Extra extraToAddToCart) {
        extrasInShoppingCart.add(extraToAddToCart);
    }

    public boolean removeExtraFromCart(Extra extraRemoveFromCart) {
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

        for (Extra extra : extrasInShoppingCart) {
            priceToReturn += extra.getPrice();
        }

        return priceToReturn;
    }

    public boolean checkOutShoppingCart() {
        if(isShoppingCartEmpty()) {
            return false;
        } else {
            order.setExtrasOrder(extrasInShoppingCart);
            order.setPizzasInOrder(pizzasInShoppingCart);
            order.setOrderID(orderID);

            if (order.getTotalPriceOfOrder() != 0) {
                if (!CardReader.processPayment()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isShoppingCartEmpty() {
        if(pizzasInShoppingCart.isEmpty() && extrasInShoppingCart.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void setTerminalID() {
        Random random = new Random();
        terminalID = random.nextInt(4)+1;
    }

    public int getTerminalID() {
        return terminalID;
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

    public ArrayList<Extra> getExtrasInShoppingCart() {
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
        extrasInShoppingCart = new ArrayList<Extra>();
        orderID = getOrderID() + 1;
        totalPriceOfShoppingCart = 0;
    }
}
