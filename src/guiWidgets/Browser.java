/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiWidgets;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
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

    public Browser() throws IOException {
        productList = new ArrayList<>();
        productContainerList = new ArrayList<>();

//        addProduct("test", 00000001, 1, "src/ImageNotFound.png", true);
    }

    public void addProduct(String name, int serial, double price) {
        Product p = new Product(name, serial, price);
        addToLocalProductList(p);
    }
    public void addProduct(String name, int serial, double price, boolean b) {
        Product p = new Product(name, serial, price);
        addToLocalProductList(p ,b);
    }

    public void addProduct(String name, int serial, double price, String imgSrc) throws IOException {
        Product p = new Product(name, serial, price, imgSrc);
        addToLocalProductList(p);
    }
    public void addProduct(String name, int serial, double price, String imgSrc, boolean b) throws IOException {
        Product p = new Product(name, serial, price, imgSrc);
        addToLocalProductList(p);
    }

    public void addProduct(Product p) {
        addToLocalProductList(p);
    }
    public void addProduct(Product p, boolean b) {
        addToLocalProductList(p, b);
    }

    public void addToLocalProductList(Product p) {
        productList.add(p);
        addToLocalProductContainerList(p);
    }
    public void addToLocalProductList(Product p, boolean b) {
        productList.add(p);
        addToLocalProductContainerList(p);
    }

    public void addToLocalProductContainerList(Product p) {
        productContainerList.add(new ProductContainer(p.getName(), p.getSerial(), p.getPrice(), p.getImage()));
    }
    public void addToLocalProductContainerList(Product p, boolean b) throws IOException {
        productContainerList.add(new ProductContainer(p.getName(), p.getSerial(), p.getPrice(), p.getImage()));
        if(b){
            showProducts();
        }
    }

    public void showProducts() throws IOException {

        System.out.println("showProducts method called");//test

        String fileName = "/src/guiWidgets/ProductContainer.fxml";
            
        System.out.println("step 1");//test

        try {
            Node root = FXMLLoader.load(getClass().getResource(fileName));//something goes wrong here
//            System.out.println("file found");//test

            int xIndent = 0;
            int yIndent = 0;
            System.out.println("step 2");//test
            for (ProductContainer p : productContainerList) {
//                Widget widget = new Widget(root, fileName);

//                Node node = widget.getNode();
                  Widget widget = new Widget(root, fileName);
                  Node node = widget.getNode();

                Parent parent = this.ScrollPane;

                double posX, posY;
                posX = parent.getLayoutX() + xIndent;
                posY = parent.getLayoutY() + yIndent;

                System.out.println("positions set for node");//test

                parent.getChildrenUnmodifiable().add(node);
                System.out.println("node added");//test
                node.setLayoutX(posX);
                node.setLayoutY(posY);

                xIndent = +230;

                if (xIndent == 4 * 230) {
                    xIndent = 0;
                    yIndent = +300;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("file not found \n" + e);
        }
    }

    //getters
    public ArrayList<Product> getLocalProductList() {
        return productList;
    }

    public ArrayList<ProductContainer> getLocalProductContainerList() {
        return productContainerList;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        try {
            addProduct("test", 00000001, 1, "src/ImageNotFound.png", true);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

}
