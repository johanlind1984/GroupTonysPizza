
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

    public ArrayList getPizzaQueue() {
        return orders;
    }
}
