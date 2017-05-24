/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.*;

// java -cp postgresql-9.4-1201.jdbc4.jar:. DBtest
public class ConnectionToDB {

    Connection con = null;
    ResultSet result = null;
    String url = null;
    String user = null;
    String password = null;

    protected ConnectionToDB(String url, String user, String password) {

        this.url = url;
        this.user = user;
        this.password = password;

        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("Something is wrong with your jdbc path!");
            e.printStackTrace();
            return;

        }

    }

    /**
     * Returns whether or not it was successful
     *
     * @return
     */
    protected boolean connect() {

        try {
            con = DriverManager.getConnection(url, user, password);

        } catch (SQLException ex) {
            /*
            Logger lgr = Logger.getLogger(ConnectionToDB.class.getName());
            lgr.log(Level.WARNING, ex.getMessage(), ex);
             */
            System.out.println("An error occured trying to connect to the database (ConnectionToDB)");
            return false;
        }

        if (con != null) {
            return true;
        } else {
            return false;
        }
    }

    protected ResultSet sendDBStatement(String statement) {
        PreparedStatement prepStat = null;
        try {
            prepStat = con.prepareStatement(statement);
            result = prepStat.executeQuery();
        } catch (SQLException e) {
            System.out.println("error occured: " + e);
        }

        return result;
    }

    protected void updateDBStatement(String statement) {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(statement);
            stmt.close();
        } catch (SQLException e) {
        }
    }
}
