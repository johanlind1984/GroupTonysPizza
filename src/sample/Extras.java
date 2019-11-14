package sample;

import java.text.DecimalFormat;

public class Extras extends Product {

    public Extras(String name, double price) {
        super(name, price);
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return name+" "+ df.format(price)+" kr";
    }
}
