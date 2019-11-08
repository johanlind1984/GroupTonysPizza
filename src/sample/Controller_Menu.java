/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    
<<<<<<< HEAD
    
    
    //REDUNDANT METHOD BELOW
=======
>>>>>>> Johan
    public void handButtonActionPizza(ActionEvent e){
    
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ViewTerminals.fxml"));
<<<<<<< HEAD

=======
>>>>>>> Johan
            Stage primaryStage = new Stage();
            Scene scene = new Scene(root, 350, 350);
            
            primaryStage.setTitle("System");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(Controller_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
