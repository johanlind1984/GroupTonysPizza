package sample;

public class Ingredient extends Product {

    public Ingredient(String name, double price) {
        super(name, price);
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String toString(){
      return name+"\t"+price+" kr";
    }
}
