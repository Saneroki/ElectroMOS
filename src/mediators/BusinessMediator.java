/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediators;

import business.WidgetRepresentation;
import guiWidgets.Widget;
import java.util.ArrayList;

/**
 *
 * @author Kristian
 */
public interface BusinessMediator {
    public void clearRepresentations();
    public void addWidget(Widget widget);
    public void removeWidget(Widget widget);
    public int getPageID(String desc);
    public void acceptLayout(String desc);
    public boolean pageExists(String description);
    public ArrayList<String> getAllLayouts();
    public void removePage(String description);
    public void loadWidgetRepresentation(int pageID);
    public ArrayList<WidgetRepresentation> getRepresentations();
    public ArrayList<Widget> getWidgets();
    public boolean connectToDB(String url, String username, String password);
}
