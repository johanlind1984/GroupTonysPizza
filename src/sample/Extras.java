package sample;

import java.text.DecimalFormat;

public class Extras extends Product {
    // Written by Tadevos
    private String name;
    private double price;

    public Extras(String name, double price) {
        this.name = name;
        this.price = price;
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

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return name+" "+ df.format(price)+" kr";
    }
}
