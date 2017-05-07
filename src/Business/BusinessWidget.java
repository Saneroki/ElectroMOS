/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import guiWidgets.*;
import javafx.scene.Node;

/**
 *
 * @author andt
 */
class BusinessWidget{
    protected int id;
    protected int height;
    protected int width;
    protected int xPos;
    protected int yPos;
    protected int databaseID;

    public BusinessWidget(int width, int height, int x, int y, int id, int dbid){
        this.height = height;
        this.width = width;
        this.xPos = x;
        this.yPos = y;
        this.id = id;
        this.databaseID = dbid;
    }
      
    void setHeight(int value) {
        this.height = value;
    }

    void setWidth(int value) {
        this.width = value;
    }

    void setXPos(int value) {
        this.xPos = value;
    }

    void setYPos(int value) {
        this.yPos = value;
    }

    int getHeight() {
        return height;
    }

    int getWidth() {
        return width;
    }

    int getXPos() {
        return xPos;
    }

    int getYPos() {
        return yPos;
    }
    
    int getID(){
        return id;
    }
    
    int getDBID(){
        return databaseID;
    }
}
