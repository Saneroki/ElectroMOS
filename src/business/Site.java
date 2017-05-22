/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;

/**
 *
 * @author Kristian
 */
public class Site {

    private ArrayList<WidgetRepresentation> widgets;
    private String description;
    private int id;
    
    public Site(String description) {
        this.description = description;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the widgets
     */
    public ArrayList<WidgetRepresentation> getWidgets() {
        return widgets;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param widget
     */
    public void addWidget(WidgetRepresentation widget) {
        widgets.add(widget);
    }

    public void removeWidget(WidgetRepresentation widget) {
        widgets.remove(widget);
    }

}
