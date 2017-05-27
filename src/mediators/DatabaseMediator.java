/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediators;

import business.WidgetRepresentation;
import java.util.ArrayList;

/**
 *
 * @author Kristian
 */
public interface DatabaseMediator {
    public int getPage(String desc);
    public int addPage(String desc);
    public boolean updateWidgets(int pageID, ArrayList<WidgetRepresentation> representations);
    public ArrayList<WidgetRepresentation> getWidgets(int pageID);
    public ArrayList<String> getAllLayouts();
    public void removePage(int id);
    public boolean hasConnection();
}
