package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class Controller_ChangePizzaWindow {

    @FXML
    ListView ingredientsOnPizzaListView;
    @FXML
    ListView ingredientsListView;

    ObservableList<Ingredient> ingredientsOnPizzaObservableList;
    ObservableList<Ingredient> ingredientMenuObservableList;
    ArrayList<Ingredient> allIngredientsOnPizza;
    Controller_ViewTerminals viewTerminalsController;
    Menu menu;
    Pizza pizza;


    @FXML
    public void initialize() {
        allIngredientsOnPizza = new ArrayList<Ingredient>();
        menu = new Menu();
        pizza = new Pizza("", 0);

    }

    private void refreshUI() {
        ArrayList<Ingredient> allIngredientsOnPizza = new ArrayList<Ingredient>(pizza.getIncludedIngredients());
        allIngredientsOnPizza.addAll(pizza.getExtraIngredients());
        ingredientsOnPizzaObservableList = FXCollections.observableArrayList(allIngredientsOnPizza);
        ingredientMenuObservableList = FXCollections.observableArrayList(menu.getAllIngredientMenu());
        ingredientsListView.setItems(ingredientMenuObservableList);
        ingredientsOnPizzaListView.setItems(ingredientsOnPizzaObservableList);
        viewTerminalsController.refreshUI();
    }

    public void setPizzaToModify(Pizza incomingPizza) {
        pizza = incomingPizza;
        ArrayList<Ingredient> allIngredientsOnPizza = new ArrayList<Ingredient>(pizza.getIncludedIngredients());
        allIngredientsOnPizza.addAll(pizza.getExtraIngredients());
        ingredientsOnPizzaObservableList = FXCollections.observableArrayList(allIngredientsOnPizza);
        ingredientMenuObservableList = FXCollections.observableArrayList(menu.getAllIngredientMenu());
        ingredientsListView.setItems(ingredientMenuObservableList);
        ingredientsOnPizzaListView.setItems(ingredientsOnPizzaObservableList);

    }

    public void addIngredientToPizza(MouseEvent event) {
        pizza.addIngredientExtra((Ingredient) ingredientsListView.getSelectionModel().getSelectedItem());
        refreshUI();
    }

    public void removeIngredientFromPizza(MouseEvent event) {
        pizza.removeIngredient((Ingredient) ingredientsOnPizzaListView.getSelectionModel().getSelectedItem());
        refreshUI();
    }

    public void setViewTerminalsController(Controller_ViewTerminals viewTerminalsController) {
        this.viewTerminalsController = viewTerminalsController;
    }
}
