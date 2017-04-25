
package Business;

/**
 *
 * @author Marcg
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public interface Mediator {
    public abstract void connectToDB(String user, String pw, String db);
    public abstract void sendData();
    public abstract void getData();
    
}


