package sample;

import java.awt.*;
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
        for (Order order : orders) {
            if(order.isOrderComplete()) {
                return true;
            }
        }

        return false;
    }
    public void playSoundIfAnyOrdercomplete() {
        if(checkIfAnyOrderIsComplete()) {
            Toolkit.getDefaultToolkit().beep();
        }
    }


    public void completeOrder(Order orderToComplete) {
        orders.remove(orderToComplete);
    }

    public ArrayList getOrders() {
        return orders;
    }
}
