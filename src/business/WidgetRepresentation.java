/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author fanders
 */
public class WidgetRepresentation {

    protected int id;
    protected int height;
    protected int width;
    protected int xPos;
    protected int yPos;
    private int widgetID;
    private String widgetFxmlName;

    public WidgetRepresentation(int width, int height, int x, int y, int id, int dbid) {
        this.height = height;
        this.width = width;
        this.xPos = x;
        this.yPos = y;
        this.id = id;
        this.widgetID = dbid;
    }

    public WidgetRepresentation(int x, int y, String widgetFxmlName) {
        this.xPos = x;
        this.yPos = y;
        this.widgetFxmlName = widgetFxmlName;
    }

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

    public int getID() {
        return id;
    }

    public int getDBID() {
        return getWidgetID();
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

    /**
     * @return the widgetID
     */
    public int getWidgetID() {
        return widgetID;
    }

    /**
     * @param widgetID the widgetID to set
     */
    public void setWidgetID(int widgetID) {
        this.widgetID = widgetID;
    }

    @Override
    public String toString() {
        return this.widgetFxmlName;
    }

}
