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
 * @author Glenn
 */
public class SCENE_CTRL_MainPage extends Controller implements Initializable {

    private BusinessController controller;

    @FXML
    private TextField fieldUsername;
    @FXML
    private TextField fieldPassword;
    @FXML
    private Button buttonLogin;
    @FXML
    private TextField fieldPath;

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
                Alert b = new Alert(Alert.AlertType.ERROR);
                b.setTitle("Wrong input");
                b.setContentText("Either the username, password, or the database path is invalid!");
                b.showAndWait();
            } else {
                this.getPageSwitcher().setSceneFromString(Page.PAGEPLANNER);
                guiMain.FxmlDataController layoutController = (guiMain.FxmlDataController) this.getPageSwitcher().getController(Page.PAGEPLANNER);
                layoutController.setMediator(controller);
            }
        }
    }

}
