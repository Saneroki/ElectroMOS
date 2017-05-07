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
public class DBMediator {

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

    public void connectToDB(String url, String user, String pw) {
        con = new ConnectionToDB(url, user, pw);
        status = con.connect();
        System.out.println(status);
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
    
    public static void main(String[] args) {
        DBMediator databaseMediator = DBMediator.getMediator();
    }
}
