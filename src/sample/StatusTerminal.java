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

    public void checkIfAnyOrderIsComplete() {
        // for each trhrough the orderlist, check all pizzas in order if status is set to complete. If all pizzas have
        // status complete the order is done.
        //
    }

    public void completeOrder(Order orderToComplete) {
        orders.remove(orderToComplete);
    }

    public ArrayList getOrders() {
        return orders;
    }
}
