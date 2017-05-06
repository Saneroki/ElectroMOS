/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiWidgets;

import java.io.File;
import javafx.scene.image.Image;

/**
 *
 * @author andt
 */
public class Product {

    private String name;
    private int serialNumber;
    private double price;
    private String imgSrc;
    private Image img;

    public Product(String name, int serial, double price) {
        this.name = name;
        this.serialNumber = serial;
        this.price = price;
        this.imgSrc = "0";
    }

    public Product(String name, int serial, double price, String imgSrc) {
        this.name = name;
        this.serialNumber = serial;
        this.price = price;
        this.imgSrc = imgSrc;

        try {
            File file = new File(imgSrc);
            img = new Image(imgSrc, 0, 150, true, false);
        } catch (Exception e) {
            img = new Image("src.imageNotFound.png");
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
}
