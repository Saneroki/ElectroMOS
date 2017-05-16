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

    private ArrayList<BusinessWidget> widgets;
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
    public ArrayList<BusinessWidget> getWidgets() {
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
    public void addWidget(BusinessWidget widget) {
        widgets.add(widget);
    }

    public void removeWidget(BusinessWidget widget) {
        widgets.remove(widget);
    }

}
