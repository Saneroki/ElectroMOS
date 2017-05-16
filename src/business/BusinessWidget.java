/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author andt
 */
class BusinessWidget {

    protected int id;
    protected int height;
    protected int width;
    protected int xPos;
    protected int yPos;
    protected int widgetID;
    private String widgetFxmlName;

    public BusinessWidget(int width, int height, int x, int y, int id, int dbid) {
        this.height = height;
        this.width = width;
        this.xPos = x;
        this.yPos = y;
        this.id = id;
        this.widgetID = dbid;
    }
    
    public BusinessWidget(int x, int y, String widgetFxmlName) {
        this.xPos = x;
        this.yPos = y;
        this.widgetFxmlName = widgetFxmlName;
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

    int getID() {
        return id;
    }

    int getDBID() {
        return widgetID;
    }

    /**
     * @return the widgetFxmlName
     */
    public String getWidgetFxmlName() {
        return widgetFxmlName;
    }

    /**
     * @param widgetFxmlName the widgetFxmlName to set
     */
    public void setWidgetFxmlName(String widgetFxmlName) {
        this.widgetFxmlName = widgetFxmlName;
    }
}
