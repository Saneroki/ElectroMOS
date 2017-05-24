/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import guiWidgets.Widget;
import java.util.ArrayList;
import mediators.BusinessMediator;
import mediators.DatabaseMediator;
import persistence.DBMediator;

/**
 *
 * @author Kristian
 */
public class BusinessController implements BusinessMediator {

    private static BusinessController controller;

    @Override
    public void clearRepresentations() {
        this.widgetHandler.setRepresentations(null);
    }

    public static BusinessController getBusinessController() {
        if (controller == null) {
            controller = new BusinessController();
        }
        return controller;
    }

    private DatabaseMediator databaseMediator;
    private WidgetHandler widgetHandler;

    private BusinessController() {
        widgetHandler = new WidgetHandler();   
    }

    @Override
    public void addWidget(Widget widget) {
        widgetHandler.addWidget(widget);
    }

    @Override
    public void removeWidget(Widget widget) {
        widgetHandler.removeWidget(widget);
    }
    
    @Override
    public int getPageID(String desc) {
        return databaseMediator.getPage(desc);
    }

    @Override
    public void acceptLayout(String desc) {
        int pageID = databaseMediator.getPage(desc);
        if (pageID == -1) {
            System.out.println("Page doesn't exists - creates it");
            pageID = databaseMediator.addPage(desc);
        } else {
            System.out.println("Page exists - loaded");
        }
        
        databaseMediator.updateWidgets(pageID, widgetHandler.getRepresentations());
    }
    
    @Override
    public boolean pageExists(String description) {
        return databaseMediator.getPage(description) != -1;
    }

    @Override
    public boolean connectToDB(String url, String username, String password) {
        databaseMediator = DBMediator.getMediator(url, username, password);
        return databaseMediator.hasConnection();
    }
    
    @Override
    public ArrayList<String> getAllLayouts() {
        return databaseMediator.getAllLayouts();
    }
    
    @Override
    public void removePage(String description) {
        int id = databaseMediator.getPage(description);
        databaseMediator.removePage(id);
    }
    
    
    /**
     * Loads the selected pageID widgets to the WidgetHandler
     * @param pageID 
     */
    @Override
    public void loadWidgetRepresentation(int pageID) {
        this.widgetHandler.setRepresentations(this.databaseMediator.getWidgets(pageID));
    }
    
    @Override
    public ArrayList<WidgetRepresentation> getRepresentations() {
        return this.widgetHandler.getRepresentations();
    }
    
    @Override
    public ArrayList<Widget> getWidgets() {
        return this.widgetHandler.getWidgets();
    }
}
