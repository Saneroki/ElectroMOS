/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.ResultSet;

/**
 *
 * @author Marcg
 */
public final class DBMediator {

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

    public boolean connectToDB(String url, String user, String pw) {
        con = new ConnectionToDB(url, user, pw);

        boolean canConnect = con.connect();
        System.out.println(canConnect ? "The connection was successfully established!" : "En error occured, trying to connect to the database..");
        return canConnect;
    }

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
}
