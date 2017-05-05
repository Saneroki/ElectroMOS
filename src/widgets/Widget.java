/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package widgets;

import javafx.scene.Node;

/**
 *
 * @author andt
 */
public abstract class Widget{
    protected int id;
    protected int height;
    protected int width;
    protected int xPos;
    protected int yPos;

//        public Widget(int width, int height){
//            this.height = height;
//            this.width = width;
//        }
    public void setHeight(int value) {
        this.height = value;
    }

    public void setWidth(int value) {
        this.width = value;
    }

    public void setXPos(int value) {
        this.xPos = value;
    }

    public void setYPos(int value) {
        this.yPos = value;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }
}
