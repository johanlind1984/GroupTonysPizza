package sample;
import java.util.ArrayList;

public class StatusTerminal {

    //* AUTHOR: JOHAN LIND* //

    private ArrayList<Order> orders;

    public StatusTerminal() {
        orders = new ArrayList();
    }

    public void addOrder(Order orderToAdd) {
        orders.add(orderToAdd);
    }

    public boolean checkIfAnyOrderIsComplete() {
        boolean isOrderComplete = true;

        for(int i = 0; i < orders.size();i++) {
            for (Pizza pizza : orders.get(i).getPizzas()) {
                if(pizza.getOrderStatus() != 3) {
                    isOrderComplete = false;
                }
            }
        }
        return isOrderComplete;
    }

    public void completeOrder(Order orderToComplete) {
        orders.remove(orderToComplete);
    }

    public ArrayList getOrders() {
        return orders;
    }
}
