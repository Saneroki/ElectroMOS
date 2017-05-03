/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author andt
 */
public class Product {
    private String name;
    private int serialNumber;
    private double price;
    private String imgSrc;
    
    public Product(String name,  int serial, double price){
        this.name = name;
        this.serialNumber = serial;
        this.price =  price;
    }
    public Product (String name, int serial, double price, String imgSrc){
        this.name = name;
        this.serialNumber = serial;
        this.price =  price;
        this.imgSrc =  imgSrc;
    }
    
    public String getName(){
        return name;
    }
    public int getSerial(){
        return serialNumber;
    }
    public double getPrice(){
        return price;
    }
    public String getImgSrc(){
        return imgSrc;
    }
}
