/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbcontroller;

import Business.Mediator;
import java.sql.ResultSet;

/**
 *
 * @author Marcg
 */
public class DBMediator implements Mediator{
    ConnectionToDB con;
    String status;
    ResultSet result;
    
    public DBMediator(){
        
    }

    @Override
    public void connectToDB(String user, String pw, String url) {
        con = new ConnectionToDB(user, pw, url);
        status = con.connect();
        System.out.println(status);
    }

    @Override
    public void sendData(String string) {
        result = con.sendDBStatement(string);
    }

    @Override
    public void getData() {
        
    }
    
    public String getDBstatus(){
        return status;
    }
    
    public ResultSet getResult(){
        return result;
    }
}
