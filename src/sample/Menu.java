package sample;
import java.util.ArrayList;

public class Menu {
    private ArrayList<Pizza>allPizzaMenu;
    private ArrayList<Ingredient>allIngredientMenu;
    private ArrayList<Extras>allExtrasMenu;

    public Menu() {
        allPizzaMenu = new ArrayList<>();
        allIngredientMenu = new ArrayList<>();
        allExtrasMenu = new ArrayList<>();
        createListOfIngredientsAndPizzas();
        createListOfExtras();
    }


    public void createListOfIngredientsAndPizzas(){
        Ingredient tomato=new Ingredient ("Tomat", 5.00);
        allIngredientMenu.add(tomato);
        Ingredient cheese=new Ingredient ("Ost", 5.00);
        allIngredientMenu.add(cheese);
        Ingredient mushrooms=new Ingredient ("Champinjoner", 10.00);
        allIngredientMenu.add(mushrooms);
        Ingredient tuna = new Ingredient ("Tonfisk", 10.00);
        allIngredientMenu.add(tuna);
        Ingredient mincedMeat = new Ingredient ("Köttfärs", 10.00);
        allIngredientMenu.add(mincedMeat);
        Ingredient ham = new Ingredient ("Skinka", 10.00);
        allIngredientMenu.add(ham);
        Ingredient onion= new Ingredient("Lök", 5.00);
        allIngredientMenu.add(onion);
        Ingredient salami=new Ingredient ("Salami", 10.00);
        allIngredientMenu.add(salami);
        Ingredient olives=new Ingredient("Oliver", 5.00);
        allIngredientMenu.add(olives);
        Ingredient shrimp=new Ingredient("Räkor", 10.00);
        allIngredientMenu.add(shrimp);


        Pizza margerita = new Pizza ("Margerita", 70.00);
        margerita.addIngredientIncluded(tomato);
        margerita.addIngredientIncluded(cheese);
        allPizzaMenu.add(margerita);
        Pizza funghi = new Pizza ("Funghi", 75.00);
        funghi.addIngredientIncluded(tomato);
        funghi.addIngredientIncluded(cheese);
        funghi.addIngredientIncluded(mushrooms);
        allPizzaMenu.add(funghi);
        Pizza vesuvio= new Pizza("Vesuvio", 75.00);
        vesuvio.addIngredientIncluded(tomato);
        vesuvio.addIngredientIncluded(cheese);
        vesuvio.addIngredientIncluded(ham);
        allPizzaMenu.add(vesuvio);
        Pizza calzone = new Pizza("Calzone", 75.00);
        calzone.addIngredientIncluded(tomato);
        calzone.addIngredientIncluded(cheese);
        calzone.addIngredientIncluded(ham);
        allPizzaMenu.add(calzone);
        Pizza capricciosa= new Pizza("Capricciosa", 75.00);
        capricciosa.addIngredientIncluded(tomato);
        capricciosa.addIngredientIncluded(cheese);
        capricciosa.addIngredientIncluded(ham);
        allPizzaMenu.add(capricciosa);
        Pizza orientale= new Pizza("Orientale", 75.00);
        orientale.addIngredientIncluded(tomato);
        orientale.addIngredientIncluded(mincedMeat);
        orientale.addIngredientIncluded(cheese);
        orientale.addIngredientIncluded(onion);
        allPizzaMenu.add(orientale);
        Pizza alTonno=new Pizza ("Al Tonno", 75.00);
        alTonno.addIngredientIncluded(tomato);
        alTonno.addIngredientIncluded(cheese);
        alTonno.addIngredientIncluded(tuna);
        alTonno.addIngredientIncluded(onion);
        allPizzaMenu.add(alTonno);
        Pizza campagnola=new Pizza ("Campagnola", 75.00);
        campagnola.addIngredientIncluded(tomato);
        campagnola.addIngredientIncluded(cheese);
        campagnola.addIngredientIncluded(salami);
        campagnola.addIngredientIncluded(onion);
        campagnola.addIngredientIncluded(olives);
        allPizzaMenu.add(campagnola);
        Pizza opera=new Pizza ("Opera", 75.00);
        opera.addIngredientIncluded(tomato);
        opera.addIngredientIncluded(cheese);
        opera.addIngredientIncluded(ham);
        opera.addIngredientIncluded(tuna);
        allPizzaMenu.add(opera);
        Pizza bussola=new Pizza("Bussola", 75.00);
        bussola.addIngredientIncluded(tomato);
        bussola.addIngredientIncluded(cheese);
        bussola.addIngredientIncluded(ham);
        bussola.addIngredientIncluded(shrimp);
        allPizzaMenu.add(bussola);
        Pizza calzoneSpecial=new Pizza("Calzone Special", 80.00);
        calzoneSpecial.addIngredientIncluded(tomato);
        calzoneSpecial.addIngredientIncluded(cheese);
        calzoneSpecial.addIngredientIncluded(ham);
        calzoneSpecial.addIngredientIncluded(shrimp);
        calzoneSpecial.addIngredientIncluded(mushrooms);
        allPizzaMenu.add(calzoneSpecial);
        Pizza colombo = new Pizza("Colombo", 80.00);
        colombo.addIngredientIncluded(tomato);
        colombo.addIngredientIncluded(cheese);
        colombo.addIngredientIncluded(tuna);
        colombo.addIngredientIncluded(shrimp);
        colombo.addIngredientIncluded(olives);
        allPizzaMenu.add(colombo);
    }
    public void createListOfExtras(){
        Extras water = new Extras("Vatten", 0.00);
        allExtrasMenu.add(water);
        Extras mineralWaterNatural=new Extras("Mineralvatten naturell", 20.00);
        allExtrasMenu.add(mineralWaterNatural);
        Extras mineralWaterLemon=new Extras("Mineralvatten citron", 20.00);
        allExtrasMenu.add(mineralWaterLemon);
        Extras cocaCola=new Extras("Coca-Cola", 20.00);
        allExtrasMenu.add(cocaCola);
        Extras fanta = new Extras("Fanta", 20.00);
        allExtrasMenu.add(fanta);
        Extras sprite=new Extras("Sprite", 20.00);
        allExtrasMenu.add(sprite);
        Extras pizzaSalad=new Extras("Pizzasallad", 0.00);
        allExtrasMenu.add(pizzaSalad);
        Extras bearnaiseSause=new Extras("Bearnaisesås", 10.00);
        allExtrasMenu.add(bearnaiseSause);
        Extras bread = new Extras("Bröd", 10.00);
        allExtrasMenu.add(bread);
    }
    public ArrayList<Pizza> getAllPizzaMenu() {
        return allPizzaMenu;
    }

    public ArrayList<Ingredient> getAllIngredientMenu() {
        return allIngredientMenu;
    }

    public ArrayList<Extras> getAllExtrasMenu() {
        return allExtrasMenu;
    }
}
