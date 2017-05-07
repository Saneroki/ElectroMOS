/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import dbcontroller.DBMediator;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author Marcg
 */
class Logic {
    HashMap<Widgets, String> widgets = new HashMap<>();
    DBMediator dB;
    
    Logic(){
        dB = DBMediator.getMediator();
    }
    
    String addPage(String description){
        String s = "";
        String sql = "";
        ResultSet result;
        int id = 0;
      
        
        try{
            sql = "INSERT INTO \"site\"(\"Description\")\n" +
               "VALUES ('" + description + "')";
            dB.sendData(sql);
            
            sql = "SELECT \"site\".site_id FROM \"site\" WHERE \"site\".\"Description\" = '" + description + "'";
            dB.sendData(sql);
            result = dB.getResult();
            result.next();
            id = result.getInt(1);
            
        for(Widget w: widgets.keySet()){
            sql = "INSERT INTO \"site_widget\"(widget_id, site_id, x, y, height, width)\n" +
                  "VALUES (" + w.getID() + ", " + id + ", " + w.getX() + ", " + w.getY() + ", " + w.getHeight() + ", " + w.getWidth() + ")";
            dB.sendData(sql);
        }
        
        s = "Page added succesfully!";
        } catch(SQLException e){
            System.out.println(e);
            s = "Something went wrong!";
        }
 
        
        return s;
    }
    
    void addWidgetToPage(int id, String desc, int x, int y, int height, int width, String typeName){
        widgets.put(new Widget(id, desc, x, y, height, width), typeName);
    }
    
    void clearWidgets(){
        widgets.clear();
    }
    
    
}