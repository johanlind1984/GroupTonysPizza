package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class Controller_ChangePizzaWindow {
    @FXML
    Button addIngredientsToPizzaID;
    @FXML
    Button backToMainID;
    @FXML
    Button customizedPizzaToOrderID;
    @FXML
    ListView addIngredientsListID;
    @FXML
    ListView changedPizzaListID;

    ObservableList<Ingredient> ingredientsOnPizza;
    ObservableList<Ingredient> ingredientMenu;
    Menu menu;

    @FXML
    public void initialize() {
        menu = new Menu();

    }

    public void setPizzaToModify(Pizza incomingPizza) {
        System.out.println(incomingPizza.getName());
        ArrayList<Ingredient> allIngredientsOnPizza = new ArrayList<Ingredient>(incomingPizza.getIncludedIngredients());
        allIngredientsOnPizza.addAll(incomingPizza.getExtraIngredients());
        ingredientsOnPizza = FXCollections.observableArrayList(allIngredientsOnPizza);
        ingredientMenu = FXCollections.observableArrayList(menu.getAllIngredientMenu());
        addIngredientsListID.setItems(ingredientMenu);
        changedPizzaListID.setItems(ingredientsOnPizza);
    }
}
