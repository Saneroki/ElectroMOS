/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiWidgets;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;

/**
 *
 * @author andt
 */
public class Product implements Initializable {

    private String name;
    private int serialNumber;
    private double price;
    private String imgSrc;
    private Image img;

    public Product(String name, int serial, double price) {
        this.name = name;
        this.serialNumber = serial;
        this.price = price;
        this.imgSrc = "src/ImageNotFound.png";
    }

    public Product(String name, int serial, double price, String imgSrc) {
        this.name = name;
        this.serialNumber = serial;
        this.price = price;
        this.imgSrc = imgSrc;

        Date date = new Date();//test
        String newline = System.getProperty("line.separator");//test
        String time = date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();//test
        write("src/fileWrittenToCheck.txt", time + ": product created with image source" + newline);//test

        try {
            File file = new File(imgSrc);
            img = new Image(imgSrc, 0, 150, true, false);
        } catch (Exception e) {
            img = new Image("src/ImageNotFound.png");
        }
    }

    public String getName() {
        return name;
    }

    public int getSerial() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public Image getImage() {
        return img;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void write(String path, String text) {
        File fileWrittenToCheck = new File(path);
        try {
            FileWriter fileWriter = new FileWriter(path, true);
            fileWriter.write(text);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
