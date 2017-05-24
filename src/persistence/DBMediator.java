/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import business.WidgetRepresentation;
import java.sql.ResultSet;
import java.util.ArrayList;
import mediators.DatabaseMediator;

/**
 *
 * @author Marcg
 */
public final class DBMediator implements DatabaseMediator {

    private static DBMediator mediator;

    /**
     * Returns null, if no connection can be found.
     *
     * @param url
     * @param user
     * @param pw
     * @return
     */
    public static DBMediator getMediator(String url, String user, String pw) {
        if (mediator == null) {
            mediator = new DBMediator();
            if (!mediator.connectToDB(url, user, pw)) {
                mediator = null;
                return null;
            }
        }
        return mediator;
    }
    ConnectionToDB con;
    String status;
    ResultSet result;
    private Logic logic;

    private DBMediator() {
        logic = new Logic(this);
    }

    private boolean connectToDB(String url, String user, String pw) {
        con = new ConnectionToDB(url, user, pw);

        boolean canConnect = con.connect();
        System.out.println(canConnect ? "The connection was successfully established!" : "En error occured, trying to connect to the database..");
        return canConnect;
    }

    @Override
    public boolean hasConnection() {
        return this.con.con != null;
    }

    public void sendData(String string) {
        result = con.sendDBStatement(string);
    }

    public void sendUpdate(String string) {
        con.updateDBStatement(string);
    }

    public void getData() {

    }

    public String getDBstatus() {
        return status;
    }

    public ResultSet getResult() {
        return result;
    }

    @Override
    public int getPage(String desc) {
        return logic.getPage(desc);
    }

    @Override
    public int addPage(String desc) {
        return logic.addPage(desc);
    }

    @Override
    public ArrayList<String> getAllLayouts() {
        return logic.getAllLayouts();
    }

    @Override
    public void removePage(int id) {
        logic.removePage(id);
    }

    @Override
    public boolean updateWidgets(int pageID, ArrayList<WidgetRepresentation> representations) {
        return logic.updateWidgets(pageID, representations);
    }

    @Override
    public ArrayList<WidgetRepresentation> getWidgets(int pageID) {
        return logic.getWidgets(pageID);
    }
}
