/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiWidgets;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;

/**
 *
 * @author andt
 */
public class Browser extends Widget implements Initializable {

    @FXML
    private ScrollPane ScrollPane;

    public Browser(int height, int width, int xPos, int yPos){
        super.width = width;
        super.height = height;
        super.xPos = xPos;
        super.yPos = yPos;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
}
