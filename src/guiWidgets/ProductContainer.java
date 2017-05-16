/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiWidgets;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Kristian
 */
public class ProductContainer implements Initializable {

    @FXML
    private ImageView ImgviewProduct;
    @FXML
    private Label LblProductTitle;
    @FXML
    private Label LblSerialNumber;
    @FXML
    private Button btAddToCart;
    @FXML
    private Label LblPrice;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleAddToCartButtonAction(ActionEvent event) {
    }

    @FXML
    private void handleProductButtonAction(ActionEvent event) {
    }
    
}
