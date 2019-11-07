import java.util.ArrayList;

public class ChefTerminal {

    //* AUTHOR: JOHAN LIND* //

    private String name;
    private ArrayList<Pizza> queueOfPizzasToBake;

    // CONSIDER USING A ENUM INSTEAD, ESPECIALLY FOR USABILITY IN CONTROLLERCLASS
//    private static final int ORDER_NOT_TAKEN = 0;
//    private static final int ORDER_IS_TAKEN = 1;
//    private static final int ORDER_IS_IN_OVEN = 2;
//    private static final int ORDER_IS_COMPLETE = 3;

    public ChefTerminal(String name) {
        this.name = name;
        this.queueOfPizzasToBake = new ArrayList<>();
    }

    public void addPizzaToBakeQueue(Pizza pizzaToBake) {
        queueOfPizzasToBake.add(pizzaToBake);
    }

    public boolean removePizzaFromBakeQueue(Pizza pizzaToRemove) {
        // TESTED
        if(queueOfPizzasToBake.contains(pizzaToRemove)) {
            queueOfPizzasToBake.remove(pizzaToRemove);
            return true;
        }

        return false;
    }

    public void setOrderStatus(int orderStatus, Pizza pizzaToChangeStatus) {
        for (Pizza pizza : queueOfPizzasToBake) {
            if(pizza.equals(pizzaToChangeStatus)) {
                pizza.setOrdernumber(orderStatus);
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
