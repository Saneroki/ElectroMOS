/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiWidgets;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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
    private Button btAddToCart; //This button is first relevant when theres
    // made a cart in the webshop.
    @FXML
    private Label LblPrice;
    @FXML
    private Button buttonTitle;
    @FXML
    private Button buttonImg;

    private String title;
    private int serialNumber;
    private double price;
    private Image img;

    private String fxmlFile;
    
    public ProductContainer(){
        System.out.println("ProductContainer initiliazing with defaults...");//test
        this.fxmlFile = "/src/guiWidgets/ProductContainer.fxml";
        this.title = "title";
        this.serialNumber = 0000001;
        this.price = 1.00;
//        this is commented out because it will create exceptions because the values will applied to "nulls"
//        LblProductTitle.setText(title);
//        LblSerialNumber.setText("" + this.serialNumber);
//        LblPrice.setText("" + this.price);
        System.out.println("productContainer initialized");//test
    }
    
    public ProductContainer(String title, int serial, double price) {
        System.out.println("productContainer initializing without image ...");//test

        this.fxmlFile = "/src/guiWidgets/ProductContainer.fxml";
        this.title = title;
        this.serialNumber = serial;
        this.price = price;

//        LblProductTitle.setText(this.title);
//        LblSerialNumber.setText("" + this.serialNumber);
//        LblPrice.setText("" + this.price);
        System.out.println("productContainer initialized");//test
    }

    public ProductContainer(String title, int serial, double price, Image img) {
        System.out.println("productContainer initializing with image...");//test

        this.fxmlFile = "/src/guiWidgets/ProductContainer.fxml";
        this.title = title;
        this.serialNumber = serial;
        this.price = price;
        this.img = img;

//        LblProductTitle.setText(this.title);
//        LblSerialNumber.setText("" + this.serialNumber);
//        LblPrice.setText("" + this.price);
        
        if (img != null) {
            ImgviewProduct.setImage(img);
        }
        System.out.println("productContainer initialized!");//test
    }

    public ProductContainer(String title, int serial, double price, String imgSrc) {
        System.out.println("productContainer initializing with imgsrc");//test
        this.title = title;
        this.serialNumber = serial;
        this.price = price;

        try {
            File file = new File(imgSrc);
            this.img = new Image(imgSrc, 0, 150, true, false);
        } catch (Exception e) {
            this.img = new Image("src/ImageNotFound.png");
        }

//        LblProductTitle.setText(this.title);
//        LblSerialNumber.setText("" + this.serialNumber);
//        LblPrice.setText("" + this.price);
//        ImgviewProduct.setImage(img);
        System.out.println("productContainer initialized.");//test
    }

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

//    public Widget setNode() throws IOException{
//        FXMLLoader loader = new FXMLLoader();
//        
//        String fileName = "/src/guiWidgets/ProductContainer.fxml";
//        
//        Node root = FXMLLoader.load(getClass().getResource(fileName));
//
//        return new Widget(root, fileName);
//    }
    public String getFxmlPath() {
        return fxmlFile;
    }

//    public Node getNode() {
//        return Widget.getNode();
//    }
    public String getTitle() {
        return title;
    }

    public int getSerial() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public Image getImage() {
        return img;
    }

}
