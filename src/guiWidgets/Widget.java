/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiWidgets;

import business.WidgetRepresentation;
import java.io.Serializable;
import javafx.scene.Node;

/**
 *
 * @author andt
 */
public class Widget {

    /**
     * @return the local position of x
     */
    public int getXPos() {
        xPos = getTotalX();
        return (int) xPos;
    }

    /**
     * Used for getting the total value for the whole scene and node.
     *
     * @return
     */
    private double getTotalY() {
        Node currentNode = node;
        double totalValue = node.getLayoutY();
        while (currentNode.getParent().getParent() != null) {
            currentNode = currentNode.getParent();
            totalValue += currentNode.getLayoutY();
        }
        return totalValue;
    }

    /**
     * Used for getting the total value for the whole scene and node.
     *
     * @return
     */
    private double getTotalX() {
        Node currentNode = node;
        double totalValue = node.getLayoutX();
        while (currentNode.getParent().getParent() != null) {
            currentNode = currentNode.getParent();
            totalValue += currentNode.getLayoutX();
        }
        return totalValue;
    }

    /**
     * @param xPos the xPos to set
     */
    public void setxPos(double xPos) {
        this.xPos = xPos;
    }

    /**
     * @return the yPos
     */
    public int getYPos() {
        yPos = getTotalY();
        return (int) yPos;
    }

    /**
     * @param yPos the yPos to set
     */
    public void setyPos(double yPos) {
        this.yPos = yPos;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return (int) width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return (int) height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the DBID
     */
    public int getDBID() {
        return DBID;
    }

    /**
     * @param DBID the DBID to set
     */
    public void setDBID(int DBID) {
        this.DBID = DBID;
    }

    private String fxmlName;
    private Node node;
    private double xPos, yPos, width, height;
    private int ID, DBID;

    public Widget(Node node, String name) {
        this.fxmlName = name;
        this.node = node;
    }

    public Widget(WidgetRepresentation repres) {
        this.fxmlName = repres.getWidgetFxmlName();
        this.xPos = repres.getXPos();
        this.yPos = repres.getYPos();
    }
    
    /**
     * @return the node
     */
    public Node getNode() {
        return node;
    }

    /**
     * @return the fxmlName
     */
    public String getFxmlName() {
        return fxmlName;
    }

    @Override
    public String toString() {
        return "Insert " + getFxmlName().split("\\.")[0];
    }
    
    public void setNode(Node node) {
        this.node = node;
    }
    
    public double getCurrentX() {
        return this.xPos;
    }
    
    public double getCurrentY() {
        return this.yPos;
    }
}
