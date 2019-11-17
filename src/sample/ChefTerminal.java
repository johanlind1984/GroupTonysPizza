package sample;
import java.util.ArrayList;
import java.util.List;

public class ChefTerminal {

    private String name;
    private ArrayList<Pizza> queueOfPizzasToBake;

    public ChefTerminal(String name) {
        this.name = name;
        this.queueOfPizzasToBake = new ArrayList<>();
    }

    public void addListOfPizzasToQueue(ArrayList<Pizza> newOrderOfPizzas) {
        queueOfPizzasToBake.addAll(newOrderOfPizzas);
    }

    public boolean removePizzaFromBakeQueue(Pizza pizzaToRemove) {
        if(queueOfPizzasToBake.contains(pizzaToRemove)) {
            queueOfPizzasToBake.remove(pizzaToRemove);
            return true;
        }

        return false;
    }

    public void setOrderStatus(OrderStatus status, Pizza pizzaToChangeStatus) {
        for (Pizza pizza : queueOfPizzasToBake) {
            if(pizza.equals(pizzaToChangeStatus)) {
                pizza.setOrderStatus(status);
            }
        }
    }


    public ArrayList<Pizza> getPizzasToBakeQueue() {
        return queueOfPizzasToBake;
    }

    public int getQueueCount() {
        return queueOfPizzasToBake.size();
    }
}
