/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package widgets;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import widgets.Widget;



/**
 *
 * @author Kristian
 */
public class Searchbar extends Widget {

    @FXML
    private TextField searchText;
    @FXML
    private Button searchButton;

    public Searchbar(int width, int height, int xPos, int yPos) {
        super.width = width;
        super.height = height;
        super.xPos = xPos;
        super.yPos = yPos;
    }

    @FXML
    private void searchAction(ActionEvent event) {
    }
    
}
