/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbcontroller;

import Business.BusinessController.Area;
import Business.Mediator;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;

/**
 *
 * @author Marcg
 */
public class DBMediator implements Mediator {

    private static DBMediator mediator;

    public static DBMediator getMediator() {
        if (mediator == null) {
            mediator = new DBMediator();
        }
        return mediator;
    }
    ConnectionToDB con;
    String status;
    ResultSet result;

    private DBMediator() {
        this.connectToDB("jdbc:postgresql://10.126.115.233:5432/ElectroMOSDB", "postgres", "Npaexmmf226");
    }

    @Override
    public void connectToDB(String url, String user, String pw) {
        con = new ConnectionToDB(url, user, pw);
        status = con.connect();
        System.out.println(status);
    }

    @Override
    public void sendData(String string) {
        result = con.sendDBStatement(string);
    }
    
    public void sendUpdate(String string) {
        con.updateDBStatement(string);
    }

    @Override
    public void getData() {

    }

    public String getDBstatus() {
        return status;
    }

    public ResultSet getResult() {
        return result;
    }

    /**
     * Make changes to the database
     *
     * @param widgets
     * @param siteId
     * @param area
     * @return whether or not it was successful.
     */
    public boolean commitChanges(List<Node> widgets, int siteId, Area area) throws SQLException {
        //Update class descriptions
        for (Node node : widgets) {
            this.updateExistingClassesRegistered(node);
        }

        String string = "INSERT INTO ";
        switch (area) {
            case BOTTOM:

                break;
            case LEFT:

                break;
            case TOP:

                break;
            case CENTER:

                break;
        }
        return true;
    }

    private void updateExistingClassesRegistered(Node node) throws SQLException {
        sendData("SELECT name FROM widget WHERE name = '" + node.getClass().toString()+"';");

        //if it exists return
        if (result.next()) {
            System.out.println("result: "+result.getString("name"));
            result.close();
            return;
        }
        
        
        //if it doesn't exist, create
        sendData("INSERT INTO widget(name)\n"
                + "VALUES\n ('" + node.getClass().toString() + "');");
        result.close();
    }
    
    public static void main(String[] args) {
        DBMediator databaseMediator = DBMediator.getMediator();
    }
}
