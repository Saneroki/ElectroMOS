/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiMain;

import business.BusinessController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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

    void setContent(Node node) {

    }

    @FXML
    private void buttonListener(ActionEvent event) {
        if (event.getSource() == buttonLogin) {
            boolean isConnected = controller.connectToDB(this.fieldPath.getText(), this.fieldUsername.getText(), this.fieldPassword.getText());

            if (!isConnected) {
                DialogboxError(
                        "Error", 
                        "Connection to the Database Failed \n\n"
                        + "Maybe the username, password, or the database path is invalid!");
            } else {
                switchSceneToPageplaner();
            }
        } else if (event.getSource() == buttonLoginWithoutDB) {
            DialogboxError("Warning",
                    "Warning \n\n"
                    + "The program will not function as expected without a Database!");
            switchSceneToPageplaner();
        }
    }
    
    private void switchSceneToPageplaner() {
        this.getSceneSwitcher().setSceneFromString(Scenes.PAGEPLANNER);
        guiMain.Pageplaner layoutController = (guiMain.Pageplaner) this.getSceneSwitcher().getController(Scenes.PAGEPLANNER);
        layoutController.setMediator(controller);
        
                
                
        
    }
    
    private void DialogboxError(String title, String content) {
        Alert b = new Alert(Alert.AlertType.ERROR);
        b.setTitle(title);
        b.setContentText(content);
        b.showAndWait();
    }
}
