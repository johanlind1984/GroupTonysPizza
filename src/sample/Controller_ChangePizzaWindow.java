package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

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
    Pizza pizza;
    ArrayList<Ingredient> allIngredientsOnPizza;

    @FXML
    public void initialize() {
        menu = new Menu();
        pizza = new Pizza("", 0);
        allIngredientsOnPizza = new ArrayList<Ingredient>();
    }

    private void refreshUI() {
        ArrayList<Ingredient> allIngredientsOnPizza = new ArrayList<Ingredient>(pizza.getIncludedIngredients());
        allIngredientsOnPizza.addAll(pizza.getExtraIngredients());
        ingredientsOnPizza = FXCollections.observableArrayList(allIngredientsOnPizza);
        ingredientMenu = FXCollections.observableArrayList(menu.getAllIngredientMenu());
        addIngredientsListID.setItems(ingredientMenu);
        changedPizzaListID.setItems(ingredientsOnPizza);
    }

    public void setPizzaToModify(Pizza incomingPizza) {
        pizza = incomingPizza;
        ArrayList<Ingredient> allIngredientsOnPizza = new ArrayList<Ingredient>(pizza.getIncludedIngredients());
        allIngredientsOnPizza.addAll(pizza.getExtraIngredients());
        ingredientsOnPizza = FXCollections.observableArrayList(allIngredientsOnPizza);
        ingredientMenu = FXCollections.observableArrayList(menu.getAllIngredientMenu());
        addIngredientsListID.setItems(ingredientMenu);
        changedPizzaListID.setItems(ingredientsOnPizza);

    }

    public void addIngredientToPizza(MouseEvent event) {
        pizza.addIngredientExtra((Ingredient) addIngredientsListID.getSelectionModel().getSelectedItem());
        refreshUI();
    }

    public void removeIngredientToPizza(MouseEvent event) {
        pizza.removeIngredient((Ingredient) changedPizzaListID.getSelectionModel().getSelectedItem());
        refreshUI();
    }

    public void closeWindow(ActionEvent event) {

    }
}
