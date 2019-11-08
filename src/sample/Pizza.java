package sample;

// Written by Tadevos
public class Pizza {

    private String name;
    private double price;
    private int ordernumber;

    public Pizza(String name, double price) {
        this.name = name;
        this.price = price;
        this.ordernumber = 0;
    }

    public int getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(int ordernumber) {
        this.ordernumber = ordernumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
