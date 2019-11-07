package sample;


import java.util.ArrayList;

public class Menu {
    private ArrayList<Pizza>allPizzaMenu=new ArrayList<>();
    private ArrayList<Ingredient>allIngredientMenu=new ArrayList<>();
    private ArrayList<Extras>allExtrasMenu= new ArrayList<>();

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
        margerita.included.add(tomato);
        margerita.included.add(cheese);
        allPizzaMenu.add(margerita);
        Pizza funghi = new Pizza ("Funghi", 75.00);
        funghi.included.add(tomato);
        funghi.included.add(cheese);
        funghi.included.add(mushrooms);
        allPizzaMenu.add(funghi);
        Pizza vesuvio= new Pizza("Vesuvio", 75.00);
        vesuvio.included.add(tomato);
        vesuvio.included.add(cheese);
        vesuvio.included.add(ham);
        allPizzaMenu.add(vesuvio);
        Pizza calzone = new Pizza("Calzone", 75.00);
        calzone.included.add(tomato);
        calzone.included.add(cheese);
        calzone.included.add(ham);
        allPizzaMenu.add(calzone);
        Pizza capricciosa= new Pizza("Capricciosa", 75.00);
        capricciosa.included.add(tomato);
        capricciosa.included.add(cheese);
        capricciosa.included.add(ham);
        allPizzaMenu.add(capricciosa);
        Pizza orientale= new Pizza("Orientale", 75.00);
        orientale.included.add(tomato);
        orientale.included.add(mincedMeat);
        orientale.included.add(cheese);
        orientale.included.add(onion);
        allPizzaMenu.add(orientale);
        Pizza alTonno=new Pizza ("Al Tonno", 75.00);
        alTonno.included.add(tomato);
        alTonno.included.add(cheese);
        alTonno.included.add(tuna);
        alTonno.included.add(onion);
        allPizzaMenu.add(alTonno);
        Pizza campagnola=new Pizza ("Campagnola", 75.00);
        campagnola.included.add(tomato);
        campagnola.included.add(cheese);
        campagnola.included.add(salami);
        campagnola.included.add(onion);
        campagnola.included.add(olives);
        allPizzaMenu.add(campagnola);
        Pizza opera=new Pizza ("Opera", 75.00);
        opera.included.add(tomato);
        opera.included.add(cheese);
        opera.included.add(ham);
        opera.included.add(tuna);
        allPizzaMenu.add(opera);
        Pizza bussola=new Pizza("Bussola", 75.00);
        bussola.included.add(tomato);
        bussola.included.add(cheese);
        bussola.included.add(ham);
        bussola.included.add(shrimp);
        allPizzaMenu.add(bussola);
        Pizza calzoneSpecial=new Pizza("Calzone Special", 80.00);
        calzoneSpecial.included.add(tomato);
        calzoneSpecial.included.add(cheese);
        calzoneSpecial.included.add(ham);
        calzoneSpecial.included.add(shrimp);
        calzoneSpecial.included.add(mushrooms);
        allPizzaMenu.add(calzoneSpecial);
        Pizza colombo = new Pizza("Colombo", 80.00);
        colombo.included.add(tomato);
        colombo.included.add(cheese);
        colombo.included.add(tuna);
        colombo.included.add(shrimp);
        colombo.included.add(olives);
        allPizzaMenu.add(colombo);
    }
    public void createListOfExtras(){
        Extras water = new Extras("Water", 0.00);
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

    public Menu() {
        createListOfIngredientsAndPizzas();
        createListOfExtras();
    }
}
