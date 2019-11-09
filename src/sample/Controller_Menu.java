/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.stage.WindowEvent;

/**
 *
 * @author Stefan
 */


public class Controller_Menu {

    @FXML
    Button payOrderID;
    @FXML
    Button changeOrderID;
    @FXML
    Button removeItemID;
    @FXML
    Button sendOrderID;
    @FXML
    Button removeOrderID;
    @FXML
    Button takeOrderID;
    @FXML
    Button orderInOvenID;
    @FXML
    Button orderCompleteID;
    @FXML
    ListView pizzaListID;
    @FXML
    ListView extraListID;
    @FXML
    ListView orderListID;
    @FXML
    ListView chefOrderListID;
    @FXML
    ListView statusOrderListID;


    ObservableList<Pizza> pizzaObservableList;
    ObservableList<Ingredient> ingredientObservableList;
    ObservableList<Extras> extrasObservableList;
    ObservableList<Order> orderObservableList;

    Menu menu;

    @FXML
    public void initialize() {
        menu = new Menu();
        pizzaObservableList = FXCollections.observableArrayList(menu.getAllPizzaMenu());
        ingredientObservableList = FXCollections.observableArrayList(menu.getAllIngredientMenu());
        extrasObservableList = FXCollections.observableArrayList(menu.getAllExtrasMenu());
    }
    

    @FXML
    public void handlePickPizza(ActionEvent pickPizza, WindowEvent cTextMenu) {
        CheckBox checkBox = new CheckBox();
        if (checkBox.isSelected()) {
            isAmerican(true);
        } else if (!checkBox.isSelected()) {
            isAmerican(false);
        } else
            isAmerican(false);
    }
    
    
    @FXML
    public void handlePickExtra(ActionEvent pickExtra) {

    }

    @FXML
    public void handleCustomerOrderList(ActionEvent orderList) {

    }

    @FXML
    public void handleChefOrderList(ActionEvent chefOrderList) {

    }

    @FXML
    public void handleStatusOrderList(ActionEvent statusOrderList) {

    }

    @FXML
    public void handleOrderCompleteBtn(ActionEvent orderComplete) {

    }

    @FXML
    public void handleOrderInOvenBtn(ActionEvent orderInOven) {

    }

    @FXML
    public void handleTakeOrderBtn(ActionEvent takeOrder) {

    }

    @FXML
    public void handleRemoveOrderBtn(ActionEvent removeOrder) {

    }

    @FXML
    public void handleSendOrderBtn(ActionEvent sendOrder) {

    }

    @FXML
    public void handleRemoveBtn(ActionEvent removeItem) {

    }

    @FXML
    public void handleChangeOrderBtn(ActionEvent changeOrder) {

    }

    @FXML
    public void handlePayOrderBtn(ActionEvent payOrder) {

    }
}
