/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import business.WidgetRepresentation;
import persistence.DBMediator;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcg
 */
class Logic {

    DBMediator dB;
    private ArrayList<WidgetRepresentation> widgets;

    Logic(DBMediator dB) {
        this.dB = dB;
    }

    /**
     * Returns whether or not it was successful
     *
     * @param url
     * @param username
     * @param password
     * @return
     */
    boolean loginToDatabase(String url, String username, String password) {
        dB = DBMediator.getMediator(url, username, password);
        return dB.hasConnection();
    }

    int addPage(String description) {
        String s = "";
        String sql = "";
        ResultSet result;

        try {
            sql = "INSERT INTO \"site\"(\"Description\")\n"
                    + "VALUES ('" + description + "')";
            dB.sendData(sql);

            sql = "SELECT \"site\".site_id FROM \"site\" WHERE \"site\".\"Description\" = '" + description + "'";
            dB.sendData(sql);
            result = dB.getResult();
            result.next();

            s = "Page added succesfully!";
            return result.getInt(1);
        } catch (SQLException e) {
            System.out.println(e);
            s = "Something went wrong!";
        }

        //Something went wrong!
        return -1;
    }

    boolean updateWidgets(int siteID, ArrayList<WidgetRepresentation> widgets) {
        this.widgets = widgets;
        try {
            updateFxmlNames();
            //delete all widgets from last
            sendUpdate("DELETE FROM site_widget WHERE site_id = " + siteID + ";");

            //insert widgets
            String string = "INSERT INTO site_widget(widget_id, site_id, x, y)"
                    + "VALUES\n";
            for (WidgetRepresentation widget : widgets) {
                string += "('" + widget.getWidgetID() + "', '" + siteID + "', '" + widget.getXPos() + "', '" + widget.getYPos() + "'),";
            }
            string = string.substring(0, string.length() - 1);
            string += ";";
            sendUpdate(string);
        } catch (SQLException e) {
            System.out.println("Exception:\n" + e);
            return false;
        }
        return true;
    }

    void updateFxmlNames() throws SQLException {
        for (WidgetRepresentation widget : widgets) {
            ResultSet result = sendUpdate("SELECT id FROM widget WHERE widget_name = " + "'" + widget.getWidgetFxmlName() + "'");
            if (!result.next()) {
                sendUpdate("INSERT INTO widget(widget_name) VALUES ('" + widget.getWidgetFxmlName() + "');");
            }
        }

        //update ids on widget
        for (WidgetRepresentation widget : widgets) {
            ResultSet result = sendUpdate("SELECT id FROM widget WHERE widget_name = " + "'" + widget.getWidgetFxmlName() + "'");
            result.next();
            widget.setWidgetID(result.getInt("id"));
        }
    }

    ArrayList<String> getAllLayouts() {
        try {
            ArrayList<String> names = new ArrayList();
            ResultSet result = sendUpdate("SELECT \"Description\"\n"
                    + "FROM site;");
            while (result.next()) {
                names.add(result.getString(1));
            }
            return names;
        } catch (SQLException ex) {
            Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    void removePage(int id) {
        sendUpdate("DELETE"
                + " FROM site_widget"
                + " WHERE site_id = "+id+";");
        System.out.println("ID: "+id);
        sendUpdate("DELETE FROM site WHERE site_id = " + id + ";");
    }
    
    

    /**
     * Returns resultset
     *
     * @param sql
     * @return
     */
    ResultSet sendUpdate(String sql) {
        dB.sendData(sql);
        return dB.getResult();
    }

    int getPage(String description) {
        try {
            dB.sendData("SELECT \"site\".site_id FROM \"site\" WHERE \"site\".\"Description\" = '" + description + "'");
            ResultSet result = dB.getResult();

            while (result.next()) {
                return result.getInt("site_id");
            }

            return -1;
        } catch (SQLException ex) {
            Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    ArrayList<WidgetRepresentation> getWidgets(int pageID) {
        ArrayList<WidgetRepresentation> returnList = new ArrayList();

        dB.sendData("SELECT widget.widget_name, site_widget.x, site_widget.y\n"
                + "FROM site_widget INNER JOIN widget ON site_widget.widget_id = widget.id, site\n"
                + "WHERE site.site_id = " + pageID + " AND site.site_id = site_widget.site_id;");

        ResultSet result = dB.getResult();
        try {
            WidgetRepresentation widget;
            while (result.next()) {
                String name = result.getString(1);
                int x = result.getInt(2);
                int y = result.getInt(3);
                widget = new WidgetRepresentation(x, y, name);
                returnList.add(widget);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
        }

        return returnList;
    }

}
