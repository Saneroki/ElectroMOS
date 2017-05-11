/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import persistence.DBMediator;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcg
 */
class Logic {

    HashMap<BusinessWidget, String> widgets = new HashMap<>();
    DBMediator dB;

    Logic() {
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
        dB = DBMediator.getMediator();
        return dB.connectToDB(url, username, password);
    }

    int addPage(String description) {
        String s = "";
        String sql = "";
        ResultSet result;
        int id = 0;

        try {
            sql = "INSERT INTO \"site\"(\"Description\")\n"
                    + "VALUES ('" + description + "')";
            dB.sendData(sql);

            sql = "SELECT \"site\".site_id FROM \"site\" WHERE \"site\".\"Description\" = '" + description + "'";
            dB.sendData(sql);
            result = dB.getResult();
            result.next();
            id = result.getInt(1);

            for (BusinessWidget w : widgets.keySet()) {
                sql = "INSERT INTO \"site_widget\"(widget_id, site_id, x, y, height, width)\n"
                        + "VALUES (" + w.getDBID() + ", " + id + ", " + w.getXPos() + ", " + w.getYPos() + ", " + w.getHeight() + ", " + w.getWidth() + ")";
                dB.sendData(sql);
            }

            s = "Page added succesfully!";
        } catch (SQLException e) {
            System.out.println(e);
            s = "Something went wrong!";
        }

        return id;
    }
<<<<<<< HEAD:src/business/Logic.java
=======

>>>>>>> 3c37eb3e05fd78b92ab4528107c9e84ef0962bf1:src/Business/Logic.java

    void updateWidgets(int siteID) {
        try {
            updateFxmlNames();
            //delete all widgets from last
            sendUpdate("DELETE FROM site_widget WHERE site_id = " + siteID + ";");

            //insert widgets
            String string = "INSERT INTO site_widget(widget_id, site_id, x, y)"
                    + "VALUES\n";
            for (BusinessWidget widget : widgets.keySet()) {
                string += "('" + widget.widgetID + "', '" + siteID + "', '" + widget.getXPos() + "', '" + widget.getYPos() + "'),";
            }
            string = string.substring(0, string.length() - 1);
            string += ";";
            sendUpdate(string);

        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void updateFxmlNames() throws SQLException {
        for (BusinessWidget widget : widgets.keySet()) {
            ResultSet result = sendUpdate("SELECT id FROM widget WHERE widget_name = " + "'" + widget.getWidgetFxmlName() + "'");
            if (!result.next()) {
                sendUpdate("INSERT INTO widget(widget_name) VALUES ('" + widget.getWidgetFxmlName() + "');");
            }
        }

        //update ids on widget
        for (BusinessWidget widget : widgets.keySet()) {
            ResultSet result = sendUpdate("SELECT id FROM widget WHERE widget_name = " + "'" + widget.getWidgetFxmlName() + "'");
            result.next();
            widget.widgetID = result.getInt("id");
        }
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
            if (result == null) {
                return -1;
            }
            result.next();
            return result.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    void addWidgetToPage(int id, int dbid, int x, int y, int height, int width, String fxmlName, String typeName) {
        BusinessWidget newWidget = new BusinessWidget(height, width, x, y, id, dbid);
        newWidget.setWidgetFxmlName(fxmlName);
        widgets.put(newWidget, typeName);
<<<<<<< HEAD:src/business/Logic.java
    }

    void addWidgetToPage(int id, int dbid, double x, double y, int height, int width, String typeName) {
        widgets.put(new BusinessWidget(height, width, (int) x, (int) y, id, dbid), typeName);
=======

>>>>>>> 3c37eb3e05fd78b92ab4528107c9e84ef0962bf1:src/Business/Logic.java
    }

    void clearWidgets() {
        widgets.clear();
    }

    void removeWidget(int id) {
        for (BusinessWidget w : widgets.keySet()) {
            if (w.getID() == id) {
                widgets.remove(w);
            }
        }
    }
}
