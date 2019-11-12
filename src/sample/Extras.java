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

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.00");
        return name+" "+ df.format(price)+" kr";
    }
}
