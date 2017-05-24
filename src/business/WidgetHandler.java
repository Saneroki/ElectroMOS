/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import guiWidgets.Widget;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Kristian
 */
public class WidgetHandler {

    private HashMap<Widget, WidgetRepresentation> widgets;

    public WidgetHandler() {
        this.widgets = new HashMap<>();
    }

    void addWidget(Widget widget) {
        WidgetRepresentation representation = new WidgetRepresentation(widget.getXPos(), widget.getYPos(), widget.getFxmlName());
        widgets.put(widget, representation);
    }

    void removeWidget(Widget widget) {
        widgets.remove(widget);
    }

    ArrayList<Widget> getWidgets() {
        ArrayList<Widget> widgetsToReturn = new ArrayList();
        Iterator it = widgets.entrySet().iterator();

        while (it.hasNext()) {
            widgetsToReturn.add((Widget) ((Map.Entry) it.next()).getKey());
        }
        return widgetsToReturn;
    }

    ArrayList<WidgetRepresentation> getRepresentations() {
        ArrayList<WidgetRepresentation> widgetsToReturn = new ArrayList();
        Iterator it = widgets.entrySet().iterator();

        while (it.hasNext()) {
            widgetsToReturn.add((WidgetRepresentation) ((Map.Entry) it.next()).getValue());
        }
        return widgetsToReturn;
    }

    /**
     * if widgets == null, then it's cleared.
     * @param widgets 
     */
    void setRepresentations(ArrayList<WidgetRepresentation> widgets) {
        this.widgets = new HashMap<>();
        //clear only if widgets == null
        if (widgets == null) {
            return;
        }
        for (WidgetRepresentation widgetRepresentation : widgets) {
            this.widgets.put(new Widget(widgetRepresentation), widgetRepresentation);
        }
    }
}
