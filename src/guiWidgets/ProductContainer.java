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

//<<<<<<< HEAD
//    public ProductContainer(/*int id, int height, int width, int xPos, int yPos*/) {
////        super.id = id;
////        super.width = width;
////        super.height = height;
////        super.xPos = xPos;
////        super.yPos = yPos;
//    }
//
//    public ProductContainer(/*String title, int serial, double price, Image img*/) {
////        this.title = title;
////        this.serialNumber = serial;
////        this.price = price;
////        this.img = img;
////
////        LblProductTitle.setText(this.title);
////        LblSerialNumber.setText("" + this.serialNumber);
////        LblPrice.setText("" + this.price);
////        ImgviewProduct.setImage(img);
//
//    }
//
//    public ProductContainer(String title, int serial, double price, String imgSrc, int id, int height, int width, int xPos, int yPos) {
//        super.id = id;
//        super.width = width;
//        super.height = height;
//        super.xPos = xPos;
//        super.yPos = yPos;
//        
//        this.title = title;
//        this.serialNumber = serial;
//        this.price = price;
//        this.img = img;
//
//
//        LblProductTitle.setText(this.title);
//        LblSerialNumber.setText("" + this.serialNumber);
//        LblPrice.setText("" + this.price);
//        ImgviewProduct.setImage(img);
//    }


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
