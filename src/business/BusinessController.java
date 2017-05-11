/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import persistence.DBMediator;
import guiWidgets.Widget;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;

/**
 *
 * @author Kristian
 */
public class BusinessController {

    private static BusinessController controller;

    public enum Area {
        TOP, LEFT, CENTER, BOTTOM;
    }

    public static BusinessController getBusinessController() {
        if (controller == null) {
            controller = new BusinessController();
        }
        return controller;
    }

    private Logic logic;

    private BusinessController() {
        logic = new Logic();
    }

    public void addWidget(Widget widget, Area area) {

        logic.addWidgetToPage(widget.getID(), widget.getDBID(), widget.getXPos(), widget.getYPos(), widget.getHeight(), widget.getWidth(), widget.getFxmlName(), getAreaList(area));
        
<<<<<<< HEAD:src/business/BusinessController.java
        //logic.addWidgetToPage(widget.getID(), widget.getDBID(), widget.getXPos(), widget.getYPos(), widget.getWidgetHeight(), widget.getWidgetWidth(), getAreaList(area));
=======

>>>>>>> 3c37eb3e05fd78b92ab4528107c9e84ef0962bf1:src/Business/BusinessController.java
    }

    public void removeWidget(Widget widget) {
        logic.removeWidget(widget.getID());
    }

    private String getAreaList(Area area) {
        switch (area) {
            case BOTTOM:
                return "bottom";
            case LEFT:
                return "left";
            case CENTER:
                return "center";
            case TOP:
                return "top";
            default:
                break;
        }
        return null;
    }

    public void acceptLayout(String desc) {
        int pageID = logic.getPage(desc);
        if (pageID == -1) {
            System.out.println("Page doesn't exists - creates it");
            pageID = logic.addPage(desc);
        } else {
            System.out.println("Page exists - loaded");
        }
        
        logic.updateWidgets(pageID);
    }

    public boolean connectToDB(String url, String username, String password) {
        return this.logic.loginToDatabase(url, username, password);
    }
}
