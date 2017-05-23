/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiMain;

import business.BusinessController;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Glenn, Kristian
 */
public class LoginToDatabase extends Controller implements Initializable {

    private BusinessController controller;

    @FXML
    private TextField fieldUsername;
    @FXML
    private TextField fieldPassword;
    @FXML
    private Button buttonLogin;
    @FXML
    private TextField fieldPath;
    @FXML
    private Button buttonLoginWithoutDB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controller = BusinessController.getBusinessController();
    }

    @FXML
    private void buttonListener(ActionEvent event) {
        if (event.getSource() == buttonLogin) {
            boolean isConnected = controller.connectToDB(
                    this.fieldPath.getText(), 
                    this.fieldUsername.getText(), 
                    this.fieldPassword.getText());

            if (!isConnected) {
                alertConnectionError();
            } else {
                switchSceneToPageplaner();
            }
        } else if (event.getSource() == buttonLoginWithoutDB) {
            alertConfirmation();
        }
    }
    
    /**
     * Will switch the current Scene to Page planer
     * @author Kristian
     */
    private void switchSceneToPageplaner() {
        guiMain.Pageplaner layoutController; 
        
        this.getSceneSwitcher().setSceneFromString(Scenes.PAGEPLANNER);
        
        layoutController = (guiMain.Pageplaner) 
                this.getSceneSwitcher().getController(Scenes.PAGEPLANNER);
        layoutController.setMediator(controller);  
    }
    
    private void alertConnectionError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Connection to the Database Failed!");
        alert.setContentText("Maybe the username, password, or the database path is invalid!");
        alert.showAndWait();
    }
    
    private void alertConfirmation(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Warning");
        alert.setHeaderText("The program will not function as expected without a Database!");
        alert.setContentText("Are you really sure to use the program without a Database?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            switchSceneToPageplaner();
        } else {
            //DoNothing
        }
    }
}
