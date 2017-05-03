/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Marcg
 */
public class CMSmediator implements Mediator{
    Logic logic;
    public CMSmediator(){
        logic = new Logic();
        
    }

    

    @Override
    public void sendData(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void connectToDB(String user, String pw, String url) {
        logic.connectDB(user, pw, url);
    }

    
}
