/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import dbcontroller.DBMediator;

/**
 *
 * @author Marcg
 */
public class Logic {
    
    DBMediator dB;
    
    public Logic(){
        dB = DBMediator.getMediator();
    }
    
   public void connectDB(String user, String pw, String url){
       dB.connectToDB(user, pw, url);
   }
   
   
    
}