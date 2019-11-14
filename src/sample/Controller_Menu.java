/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;


import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

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
    TextField shoppingCartTotalPriceID;
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
        refreshUI();
    }

    public void refreshUI() {
        statusTerminal.checkIfAnyOrderIsComplete();
        pizzaObservableList = FXCollections.observableArrayList(menu.getAllPizzaMenu());
        ingredientObservableList = FXCollections.observableArrayList(menu.getAllIngredientMenu());
        extrasObservableList = FXCollections.observableArrayList(menu.getAllExtrasMenu());
        chefObservableList = FXCollections.observableArrayList(chefTerminal.getPizzasToBakeQueue());
        shoppingCartObservableList = FXCollections.observableArrayList(customerTerminal.getShoppingCart());
        orderObservableList = FXCollections.observableArrayList(statusTerminal.getOrders());
        pizzaListID.setItems(pizzaObservableList);
        extraListID.setItems(extrasObservableList);
        orderListID.setItems(shoppingCartObservableList);
        chefOrderListID.setItems(chefObservableList);
        statusOrderListID.refresh();
        statusOrderListID.setItems(orderObservableList);
        shoppingCartTotalPriceID.setStyle("-fx-text-inner-color: back;");
        shoppingCartTotalPriceID.setText("" + customerTerminal.getTotalPriceOfShoppingCart());
    }

    public void prepareCustomerTerminalForNewCustomer() {
        customerTerminal.clearShoppingCartsAndOrder();
        refreshUI();
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
        chefTerminal.setOrderStatus(OrderStatus.ORDER_IS_COMPLETE, (Pizza) chefOrderListID.getSelectionModel().getSelectedItem());
        chefTerminal.removePizzaFromBakeQueue((Pizza) chefOrderListID.getSelectionModel().getSelectedItem());
        statusTerminal.playSoundIfAnyOrdercomplete();
        refreshUI();
    }

    @FXML
    public void handleOrderInOvenBtn(ActionEvent orderInOven) {
        chefTerminal.setOrderStatus(OrderStatus.ORDER_IS_IN_OVEN, (Pizza) chefOrderListID.getSelectionModel().getSelectedItem());
        refreshUI();
    }

    @FXML
    public void handleTakeOrderBtn(ActionEvent takeOrder) {
        chefTerminal.setOrderStatus(OrderStatus.ORDER_IS_PREPARING_FOR_OVEN, (Pizza) chefOrderListID.getSelectionModel().getSelectedItem());
        refreshUI();
    }

    @FXML
    public void handleRemoveOrderBtn(ActionEvent removeOrder) {
        for (Pizza pizzaToRemoveFormChefTerminal : ((Order) statusOrderListID.getSelectionModel().getSelectedItem()).getPizzas()) {
            chefTerminal.removePizzaFromBakeQueue(pizzaToRemoveFormChefTerminal);
        }

        statusTerminal.completeOrder((Order) statusOrderListID.getSelectionModel().getSelectedItem());
        refreshUI();
    }

    @FXML
    public void handleSendOrderBtn(ActionEvent sendOrder) {
        for (Pizza pizzaToRemoveFormChefTerminal : ((Order) statusOrderListID.getSelectionModel().getSelectedItem()).getPizzas()) {
            chefTerminal.removePizzaFromBakeQueue(pizzaToRemoveFormChefTerminal);
        }

        statusTerminal.completeOrder((Order) statusOrderListID.getSelectionModel().getSelectedItem());
        refreshUI();
    }

    @FXML
    public void handleRemoveBtn(ActionEvent removeItem) {
        String classSelected = orderListID.getSelectionModel().getSelectedItem().getClass().toString();

        if(orderListID.getSelectionModel().getSelectedItem().getClass().toString().equals("class sample.Pizza")) {
            customerTerminal.removePizzaFromShoppingCart((Pizza) orderListID.getSelectionModel().getSelectedItem());
        } else {
            customerTerminal.removeExtraFromCart((Extras) orderListID.getSelectionModel().getSelectedItem());
        }

        refreshUI();
    }

    @FXML
    void handleChangeOrderBtn(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("changePizzaWindow.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            
            stage.getIcons().add(new Image("file:src\\TonyMozzarellaImages\\flag.png"));
            stage.setTitle("Tony Mozzarella's Pizza");
            stage.setAlwaysOnTop(true);
            stage.setScene(new Scene(root1));

            Controller_ChangePizzaWindow controller = fxmlLoader.<Controller_ChangePizzaWindow>getController();
            Pizza selectedPizza = (Pizza) orderListID.getSelectionModel().getSelectedItem();
            controller.setPizzaToModify(selectedPizza);

            stage.show();
        } catch (IOException e) {
            Logger.getLogger(Controller_Menu.class.getName()).log(Level.SEVERE, null, e);
        }

        refreshUI();
    }

    @FXML
    public void handlePayOrderBtn(ActionEvent payOrder) {
        if(customerTerminal.checkOutShoppingCart()) {
            statusTerminal.addOrder(customerTerminal.getOrder());
            chefTerminal.addListOfPizzasToQueue(customerTerminal.getPizzasInShoppingCart());
            prepareCustomerTerminalForNewCustomer();
            refreshUI();
        } else {
            shoppingCartTotalPriceID.setStyle("-fx-text-inner-color: red;");
            shoppingCartTotalPriceID.setText("FEL: Ditt köp medges ej, eller tom varukorg");
        }

    }

    public void handlePickPizza(MouseEvent contextMenuEvent) {
        Pizza pizzaToAddToOrder = (Pizza) pizzaListID.getSelectionModel().getSelectedItem();
        customerTerminal.addPizzaToShoppingCart(pizzaToAddToOrder);
        shoppingCartTotalPriceID.setText(("" + customerTerminal.getTotalPriceOfShoppingCart()));
        refreshUI();
    }

    public void handlePickExtra(MouseEvent contextMenuEvent) {
        Extras extrasToAddToOrder = (Extras) extraListID.getSelectionModel().getSelectedItem();
        customerTerminal.addExtraToShoppingCart(extrasToAddToOrder);
        shoppingCartTotalPriceID.setText(("" + customerTerminal.getTotalPriceOfShoppingCart()));
        refreshUI();
    }
}
