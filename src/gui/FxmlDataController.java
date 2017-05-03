/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Business.CMSmediator;
import Business.Mediator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author Glenn
 */
public class FxmlDataController implements Initializable {
    
    Mediator mediator;
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mediator = new CMSmediator();
        
        
        mediator.connectToDB("postgres", "Npaexmmf226", "jdbc:postgresql://10.126.115.233:5432/ElectroMOSDB");
    }    
    
}
