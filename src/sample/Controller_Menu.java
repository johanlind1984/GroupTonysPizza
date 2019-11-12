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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

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
    TextField ShoppingCartTotalPriceID;
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
    ObservableList<Product> shoppingCartObservableList;
    ObservableList<Pizza> chefObservableList;
    ObservableList<Order> orderObservableList;

    Menu menu;
    CustomerTerminal customerTerminal;
    ChefTerminal chefTerminal;
    StatusTerminal statusTerminal;

    @FXML
    public void initialize() {
        menu = new Menu();
        customerTerminal = new CustomerTerminal();
        chefTerminal = new ChefTerminal("ChefTerminal");
        statusTerminal = new StatusTerminal();

        pizzaObservableList = FXCollections.observableArrayList(menu.getAllPizzaMenu());
        ingredientObservableList = FXCollections.observableArrayList(menu.getAllIngredientMenu());
        extrasObservableList = FXCollections.observableArrayList(menu.getAllExtrasMenu());
        chefObservableList = FXCollections.observableArrayList(chefTerminal.getPizzasToBakeQueue());
        shoppingCartObservableList = FXCollections.observableArrayList(customerTerminal.getPizzasInShoppingCart());
        orderObservableList = FXCollections.observableArrayList(statusTerminal.getOrders());
        pizzaListID.setItems(pizzaObservableList);
        extraListID.setItems(extrasObservableList);
        orderListID.setItems(shoppingCartObservableList);
        chefOrderListID.setItems(chefObservableList);
        statusOrderListID.setItems(orderObservableList);

    }

    public void refrehUI() {
        pizzaObservableList = FXCollections.observableArrayList(menu.getAllPizzaMenu());
        ingredientObservableList = FXCollections.observableArrayList(menu.getAllIngredientMenu());
        extrasObservableList = FXCollections.observableArrayList(menu.getAllExtrasMenu());
        chefObservableList = FXCollections.observableArrayList(chefTerminal.getPizzasToBakeQueue());
        shoppingCartObservableList = FXCollections.observableArrayList(customerTerminal.getPizzasInShoppingCart());
        orderObservableList = FXCollections.observableArrayList(statusTerminal.getOrders());
        pizzaListID.setItems(pizzaObservableList);
        extraListID.setItems(extrasObservableList);
        orderListID.setItems(shoppingCartObservableList);
        chefOrderListID.setItems(chefObservableList);
        statusOrderListID.setItems(orderObservableList);
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
        chefTerminal.setOrderStatus(3, (Pizza) chefOrderListID.getSelectionModel().getSelectedItem());
        chefTerminal.removePizzaFromBakeQueue((Pizza) chefOrderListID.getSelectionModel().getSelectedItem());
        chefObservableList = FXCollections.observableArrayList(chefTerminal.getPizzasToBakeQueue());
        statusTerminal.checkIfAnyOrderIsComplete();
        refrehUI();
    }

    @FXML
    public void handleOrderInOvenBtn(ActionEvent orderInOven) {
        chefTerminal.setOrderStatus(2, (Pizza) chefOrderListID.getSelectionModel().getSelectedItem());
        statusTerminal.checkIfAnyOrderIsComplete();
        refrehUI();
    }

    @FXML
    public void handleTakeOrderBtn(ActionEvent takeOrder) {
        chefTerminal.setOrderStatus(1, (Pizza) chefOrderListID.getSelectionModel().getSelectedItem());
        statusTerminal.checkIfAnyOrderIsComplete();
        refrehUI();
    }

    @FXML
    public void handleRemoveOrderBtn(ActionEvent removeOrder) {

    }

    @FXML
    public void handleSendOrderBtn(ActionEvent sendOrder) {
        System.out.println("\n\n\n IN HANDLESENDORDERBTN \n\n\n");
        Order tempOrder = (Order) statusOrderListID.getSelectionModel().getSelectedItem();
        statusTerminal.completeOrder(tempOrder);
        refrehUI();
    }

    @FXML
    public void handleRemoveBtn(ActionEvent removeItem) {
        String classSelected = orderListID.getSelectionModel().getSelectedItem().getClass().toString();

        if(orderListID.getSelectionModel().getSelectedItem().getClass().toString().equals("class sample.Pizza")) {
            customerTerminal.removePizzaFromShoppingCart((Pizza) orderListID.getSelectionModel().getSelectedItem());
        } else {
            customerTerminal.removeExtraFromCart((Extras) orderListID.getSelectionModel().getSelectedItem());
        }

        refrehUI();
    }

    @FXML
    public void handleChangeOrderBtn(ActionEvent changeOrder) {

    }

    @FXML
    public void handlePayOrderBtn(ActionEvent payOrder) {
        customerTerminal.checkOutShoppingCart();
        statusTerminal.addOrder(customerTerminal.getOrder());
        chefTerminal.addListOfPizzasToQueue(customerTerminal.getPizzasInShoppingCart());
        refrehUI();

    }

    public void handlePickPizza(MouseEvent contextMenuEvent) {
        Pizza pizzaToAddToOrder = (Pizza) pizzaListID.getSelectionModel().getSelectedItem();
        customerTerminal.addPizzaToShoppingCart(pizzaToAddToOrder);
        ShoppingCartTotalPriceID.setText(("" + customerTerminal.getTotalPriceOfShoppingCart()));
        refrehUI();
    }

    public void handlePickExtra(MouseEvent contextMenuEvent) {
        Extras extrasToAddToOrder = (Extras) extraListID.getSelectionModel().getSelectedItem();
        customerTerminal.addExtraToShoppingCart(extrasToAddToOrder);
        ShoppingCartTotalPriceID.setText(("" + customerTerminal.getTotalPriceOfShoppingCart()));
        refrehUI();
    }
}
