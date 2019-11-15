/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sample;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @authors Stefan, Johanna, Johan, Enock, Tadevos
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        try {
        Parent root = FXMLLoader.load(getClass().getResource("ViewTerminals.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Tony Mozzarella's Pizza");
        stage.getIcons().add(new Image("file:src\\TonyMozzarellaImages\\flag.png"));
        stage.show();
    }  catch (IOException ex){
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
