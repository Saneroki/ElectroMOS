/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import dbcontroller.DBMediator;
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

    private ArrayList<Node> widgetsLeft;
    private ArrayList<Node> widgetsCenter;
    private ArrayList<Node> widgetsTop;
    private ArrayList<Node> widgetsBottom;

    private DBMediator databaseMediator;

    private BusinessController() {
        widgetsLeft = new ArrayList();
        widgetsTop = new ArrayList();
        widgetsCenter = new ArrayList();
        widgetsBottom = new ArrayList();

        databaseMediator = DBMediator.getMediator();
    }

    public void addWidget(Node widget, Area area) {
        getAreaList(area).add(widget);
    }

    public void removeWidget(Node widget, Area area) {
        getAreaList(area).remove(widget);
    }

    private List<Node> getAreaList(Area area) {
        switch (area) {
            case BOTTOM:
                return this.widgetsBottom;
            case LEFT:
                return this.widgetsLeft;
            case CENTER:
                return this.widgetsCenter;
            case TOP:
                return this.widgetsTop;

            default:
                break;
        }
        return null;
    }

    public void acceptLayout() {
        try {
            this.databaseMediator.commitChanges(widgetsTop, 0, Area.TOP);
            this.databaseMediator.commitChanges(widgetsCenter, 0, Area.CENTER);
            this.databaseMediator.commitChanges(widgetsLeft, 0, Area.LEFT);
            this.databaseMediator.commitChanges(widgetsBottom, 0, Area.BOTTOM);
        } catch (SQLException ex) {
            System.out.println("An error occured updating the layout");
            Logger.getLogger(BusinessController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}