/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package widgets;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 *
 * @author andt
 */
public class ProductContainer extends Widget implements Initializable{

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
    public ProductContainer(int heigth, int width, int xPos, int yPos){
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void handleAddToCartButtonAction(ActionEvent event) {
    }

    @FXML
    private void handleProductButtonAction(ActionEvent event) {
    }
    
}
