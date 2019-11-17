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
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Controller_ViewTerminals {

    @FXML
    Button payOrderButton;
    @FXML
    Button changeOrderButton;
    @FXML
    Button removeItemButton;
    @FXML
    Button sendOrderButton;
    @FXML
    Button removeOrderButton;
    @FXML
    Button takeOrderButton;
    @FXML
    Button orderInOvenButton;
    @FXML
    Button orderCompleteButton;
    @FXML
    TextField shoppingCartTotalPriceTextField;
    @FXML
    Tab terminalIDTab;
    @FXML
    ListView pizzaMenuListView;
    @FXML
    ListView extraMenuListView;
    @FXML
    ListView shoppingCartListView;
    @FXML
    ListView chefOrderListView;
    @FXML
    ListView statusOrderListView;


    ObservableList<Pizza> pizzaMenuObservableList;
    ObservableList<Ingredient> ingredientMenuObservableList;
    ObservableList<Extra> extrasMenuObservableList;
    ObservableList<Product> shoppingCartObservableList;
    ObservableList<Pizza> chefTerminalObservableList;
    ObservableList<Order> statusTerminalObservableList;
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
        customerTerminal.setTerminalID();
        terminalIDTab.setText("Customer Terminal " + customerTerminal.getTerminalID());
    }

    public void refreshUI() {
        statusTerminal.checkIfAnyOrderIsComplete();

        pizzaMenuObservableList = FXCollections.observableArrayList(menu.getAllPizzaMenu());
        ingredientMenuObservableList = FXCollections.observableArrayList(menu.getAllIngredientMenu());
        extrasMenuObservableList = FXCollections.observableArrayList(menu.getAllExtrasMenu());
        chefTerminalObservableList = FXCollections.observableArrayList(chefTerminal.getPizzasToBakeQueue());
        shoppingCartObservableList = FXCollections.observableArrayList(customerTerminal.getShoppingCart());
        statusTerminalObservableList = FXCollections.observableArrayList(statusTerminal.getOrders());

        statusOrderListView.refresh();
        chefOrderListView.refresh();
        shoppingCartListView.refresh();

        pizzaMenuListView.setItems(pizzaMenuObservableList);
        extraMenuListView.setItems(extrasMenuObservableList);
        shoppingCartListView.setItems(shoppingCartObservableList);
        chefOrderListView.setItems(chefTerminalObservableList);
        statusOrderListView.setItems(statusTerminalObservableList);

        shoppingCartTotalPriceTextField.setStyle("-fx-text-inner-color: black;");
        shoppingCartTotalPriceTextField.setText("" + customerTerminal.getTotalPriceOfShoppingCart());
    }

    public void prepareCustomerTerminalForNewCustomer() {
        customerTerminal.clearShoppingCartsAndOrder();
        refreshUI();
    }

    @FXML
    public void handlePizzaCompleteBtn(ActionEvent orderComplete) {
        chefTerminal.setOrderStatus(OrderStatus.ORDER_IS_COMPLETE, (Pizza) chefOrderListView.getSelectionModel().getSelectedItem());
        chefTerminal.removePizzaFromBakeQueue((Pizza) chefOrderListView.getSelectionModel().getSelectedItem());
        statusTerminal.playSoundIfAnyOrdercomplete();
        chefTerminal.setOrderStatus(OrderStatus.ORDER_IS_COMPLETE, (Pizza) chefOrderListView.getSelectionModel().getSelectedItem());
        chefTerminal.removePizzaFromBakeQueue((Pizza) chefOrderListView.getSelectionModel().getSelectedItem());
        statusTerminal.playSoundIfAnyOrdercomplete();
        refreshUI();
    }

    @FXML
    public void handlePizzaInOvenBtn(ActionEvent orderInOven) {
        chefTerminal.setOrderStatus(OrderStatus.ORDER_IS_IN_OVEN, (Pizza) chefOrderListView.getSelectionModel().getSelectedItem());
        refreshUI();
    }

    @FXML
    public void handleTakePizzaBtn(ActionEvent takeOrder) {
        chefTerminal.setOrderStatus(OrderStatus.ORDER_IS_PREPARING_FOR_OVEN, (Pizza) chefOrderListView.getSelectionModel().getSelectedItem());
        refreshUI();
    }

    @FXML
    public void handleSendOrderBtn(ActionEvent sendOrder) {
        if(!statusOrderListView.getSelectionModel().isEmpty()) {
            for (Pizza pizzaToRemoveFormChefTerminal : ((Order) statusOrderListView.getSelectionModel().getSelectedItem()).getPizzas()) {
                chefTerminal.removePizzaFromBakeQueue(pizzaToRemoveFormChefTerminal);
            }

            statusTerminal.completeOrder((Order) statusOrderListView.getSelectionModel().getSelectedItem());
            refreshUI();
        }
    }

    @FXML
    public void handleRemoveFromShoppingCartBtn(ActionEvent removeItem) {
        if(!shoppingCartListView.getSelectionModel().isEmpty()) {
            if (shoppingCartListView.getSelectionModel().getSelectedItem().getClass().toString().equals("class sample.Pizza")) {
                customerTerminal.removePizzaFromShoppingCart((Pizza) shoppingCartListView.getSelectionModel().getSelectedItem());
            } else {
                customerTerminal.removeExtraFromCart((Extra) shoppingCartListView.getSelectionModel().getSelectedItem());
            }

            refreshUI();
        }
    }

    @FXML
    void handleChangeOrderBtn(MouseEvent event) {
        if(!shoppingCartListView.getSelectionModel().isEmpty()) {
            if (shoppingCartListView.getSelectionModel().getSelectedItem().getClass().toString().equals("class sample.Pizza")) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("changePizzaWindow.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();

                    stage.getIcons().add(new Image("file:src\\TonyMozzarellaImages\\flag.png"));
                    stage.setTitle("Tony Mozzarella's Pizza");
                    stage.setAlwaysOnTop(true);
                    stage.setScene(new Scene(root1));

                    Controller_ChangePizzaWindow controller = fxmlLoader.<Controller_ChangePizzaWindow>getController();
                    Pizza selectedPizza = (Pizza) shoppingCartListView.getSelectionModel().getSelectedItem();
                    controller.setPizzaToModify(selectedPizza);
                    controller.setViewTerminalsController(this);

                    stage.show();
                } catch (IOException e) {
                    Logger.getLogger(Controller_ViewTerminals.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }

    }

    @FXML
    public void handlePayOrderBtn(ActionEvent payOrder) {
        if(customerTerminal.checkOutShoppingCart()) {
            statusTerminal.addOrder(customerTerminal.getOrder());
            chefTerminal.addListOfPizzasToQueue(customerTerminal.getPizzasInShoppingCart());
            prepareCustomerTerminalForNewCustomer();
            refreshUI();
        } else {
            shoppingCartTotalPriceTextField.setStyle("-fx-text-inner-color: red;");
            shoppingCartTotalPriceTextField.setText("FEL: Ditt köp medges ej, eller tom varukorg");
        }
    }

    public void handlePickPizzaFromMenu(MouseEvent contextMenuEvent) {
        Pizza pizzaToAddToOrder = (Pizza) pizzaMenuListView.getSelectionModel().getSelectedItem();
        customerTerminal.addPizzaToShoppingCart(pizzaToAddToOrder);
        shoppingCartTotalPriceTextField.setText(("" + customerTerminal.getTotalPriceOfShoppingCart()));
        refreshUI();
    }

    public void handlePickExtraFromMenu(MouseEvent contextMenuEvent) {
        Extra extraToAddToOrder = (Extra) extraMenuListView.getSelectionModel().getSelectedItem();
        customerTerminal.addExtraToShoppingCart(extraToAddToOrder);
        shoppingCartTotalPriceTextField.setText(("" + customerTerminal.getTotalPriceOfShoppingCart()));
        refreshUI();
    }
}
