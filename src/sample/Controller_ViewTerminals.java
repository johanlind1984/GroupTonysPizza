/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.io.File;
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
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Stefan
 */
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
    ObservableList<Extras> extrasMenuObservableList;
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
    }

    public void refreshUI() {
        statusTerminal.checkIfAnyOrderIsComplete();
        pizzaMenuObservableList = FXCollections.observableArrayList(menu.getAllPizzaMenu());
        ingredientMenuObservableList = FXCollections.observableArrayList(menu.getAllIngredientMenu());
        extrasMenuObservableList = FXCollections.observableArrayList(menu.getAllExtrasMenu());
        chefTerminalObservableList = FXCollections.observableArrayList(chefTerminal.getPizzasToBakeQueue());
        shoppingCartObservableList = FXCollections.observableArrayList(customerTerminal.getShoppingCart());
        statusTerminalObservableList = FXCollections.observableArrayList(statusTerminal.getOrders());
        pizzaMenuListView.setItems(pizzaMenuObservableList);
        extraMenuListView.setItems(extrasMenuObservableList);
        shoppingCartListView.setItems(shoppingCartObservableList);
        chefOrderListView.setItems(chefTerminalObservableList);
        statusOrderListView.refresh();
        statusOrderListView.setItems(statusTerminalObservableList);
        shoppingCartTotalPriceTextField.setStyle("-fx-text-inner-color: back;");
        shoppingCartTotalPriceTextField.setText("" + customerTerminal.getTotalPriceOfShoppingCart());
    }

    public void prepareCustomerTerminalForNewCustomer() {
        customerTerminal.clearShoppingCartsAndOrder();
        refreshUI();
    }

    private void playSoundIfAnyOrdercomplete() {
        if(statusTerminal.checkIfAnyOrderIsComplete()) {
            try
            {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(new File("src\\sample\\sound\\yababy.wav")));
                clip.start();
            }
            catch (Exception exc)
            {
                exc.printStackTrace(System.out);
            }
        }
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
        chefTerminal.setOrderStatus(OrderStatus.ORDER_IS_COMPLETE, (Pizza) chefOrderListView.getSelectionModel().getSelectedItem());
        chefTerminal.removePizzaFromBakeQueue((Pizza) chefOrderListView.getSelectionModel().getSelectedItem());
        playSoundIfAnyOrdercomplete();
        refreshUI();
    }

    @FXML
    public void handleOrderInOvenBtn(ActionEvent orderInOven) {
        chefTerminal.setOrderStatus(OrderStatus.ORDER_IS_IN_OVEN, (Pizza) chefOrderListView.getSelectionModel().getSelectedItem());
        refreshUI();
    }

    @FXML
    public void handleTakeOrderBtn(ActionEvent takeOrder) {
        chefTerminal.setOrderStatus(OrderStatus.ORDER_IS_PREPARING_FOR_OVEN, (Pizza) chefOrderListView.getSelectionModel().getSelectedItem());
        refreshUI();
    }

    @FXML
    public void handleRemoveOrderBtn(ActionEvent removeOrder) {
        for (Pizza pizzaToRemoveFormChefTerminal : ((Order) statusOrderListView.getSelectionModel().getSelectedItem()).getPizzas()) {
            chefTerminal.removePizzaFromBakeQueue(pizzaToRemoveFormChefTerminal);
        }

        statusTerminal.completeOrder((Order) statusOrderListView.getSelectionModel().getSelectedItem());
        refreshUI();
    }

    @FXML
    public void handleSendOrderBtn(ActionEvent sendOrder) {
        for (Pizza pizzaToRemoveFormChefTerminal : ((Order) statusOrderListView.getSelectionModel().getSelectedItem()).getPizzas()) {
            chefTerminal.removePizzaFromBakeQueue(pizzaToRemoveFormChefTerminal);
        }

        statusTerminal.completeOrder((Order) statusOrderListView.getSelectionModel().getSelectedItem());
        refreshUI();
    }

    @FXML
    public void handleRemoveBtn(ActionEvent removeItem) {
        String classSelected = shoppingCartListView.getSelectionModel().getSelectedItem().getClass().toString();

        if(shoppingCartListView.getSelectionModel().getSelectedItem().getClass().toString().equals("class sample.Pizza")) {
            customerTerminal.removePizzaFromShoppingCart((Pizza) shoppingCartListView.getSelectionModel().getSelectedItem());
        } else {
            customerTerminal.removeExtraFromCart((Extras) shoppingCartListView.getSelectionModel().getSelectedItem());
        }

        refreshUI();
    }

    @FXML
    void handleChangeOrderBtn(MouseEvent event) {
        if(shoppingCartListView.getSelectionModel().getSelectedItem().getClass().toString().equals("class sample.Pizza")) {
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

                stage.show();
            } catch (IOException e) {
                Logger.getLogger(Controller_ViewTerminals.class.getName()).log(Level.SEVERE, null, e);
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

    public void handlePickPizza(MouseEvent contextMenuEvent) {
        Pizza pizzaToAddToOrder = (Pizza) pizzaMenuListView.getSelectionModel().getSelectedItem();
        customerTerminal.addPizzaToShoppingCart(pizzaToAddToOrder);
        shoppingCartTotalPriceTextField.setText(("" + customerTerminal.getTotalPriceOfShoppingCart()));
        refreshUI();
    }

    public void handlePickExtra(MouseEvent contextMenuEvent) {
        Extras extrasToAddToOrder = (Extras) extraMenuListView.getSelectionModel().getSelectedItem();
        customerTerminal.addExtraToShoppingCart(extrasToAddToOrder);
        shoppingCartTotalPriceTextField.setText(("" + customerTerminal.getTotalPriceOfShoppingCart()));
        refreshUI();
    }
}
