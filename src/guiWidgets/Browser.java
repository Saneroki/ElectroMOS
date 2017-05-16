/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiWidgets;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Kristian
 */
public class Browser implements Initializable {

    private ArrayList<Product> productList;
    private ArrayList<ProductContainer> productContainerList;
    @FXML
    private ScrollPane ScrollPane;
    @FXML
    private TitledPane titlePane;


    public Browser(/*int id, int height, int width, int xPos, int yPos*/)/* throws IOException*/ {
//        super.id = id;
//        super.width = width;
//        super.height = height;
//        super.xPos = xPos;
//        super.yPos = yPos;
//        
//        titlePane.setPrefWidth(this.width);
//        titlePane.setMaxWidth(this.width);
//        titlePane.setPrefHeight(this.height);
//        titlePane.setMaxHeight(this.height);
//        //there needs to be a stock that holds all the products fetched from the PIM
//        productList = new ArrayList<>();
//        productContainerList = new ArrayList<>();
//        
        //i have no idea if this will work...
//        for(ProductContainer p: productContainerList){
//            Pane newPane = FXMLLoader.load(getClass().getResource("FXMLProductContainer.fxml"));
//            
//        }
        
        
    }
    
//    public void addProduct(String name, int serial, double price){
//        Product p = new Product(name, serial, price);
//        addToLocalProductList(p);
//    }
//    public void addProduct(String name, int serial, double price, String imgSrc){
//        Product p = new Product(name, serial, price, imgSrc);
//        addToLocalProductList(p);
//    }
//
//    public void addToLocalProductList(Product p) {
//        productList.add(p);
//        addToLocalProductContainerList(p);
//    }

//    public void addToLocalProductContainerList(Product p) {
//        productContainerList.add(new ProductContainer(p.getName(), p.getSerial(), p.getPrice(), p.getImage()));
//    }

    //getters
    public ArrayList<Product> getLocalProductList() {
        return productList;
    }

    public ArrayList<ProductContainer> getLocalProductContainerList() {
        return productContainerList;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
