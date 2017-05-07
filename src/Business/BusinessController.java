/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import dbcontroller.DBMediator;
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


    private Logic logic = new Logic();

    private BusinessController() {
    }

    public void addWidget(Widget widget, Area area) {
        logic.addWidgetToPage(widget.getID(), widget.getDBID(), widget.getXPos(), widget.getYPos(), widget.getWidgetHeight(), widget.getWidgetWidth(), getAreaList(area));
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
       logic.addPage(desc);
    }
}