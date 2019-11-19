package sample;

public class Ingredient extends Product {

    public Ingredient(String name, double price) {
        super(name, price);
    }

    @Override
    public String toString(){
      return name+"\t"+price+" kr";
    }
}
