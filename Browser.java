/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiWidgets;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
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
