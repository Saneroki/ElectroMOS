/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiWidgets;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import guiWidgets.Widget;



/**
 *
 * @author Kristian
 */
public class Searchbar extends Widget {

    @FXML
    private TextField searchText;
    @FXML
    private Button searchButton;

    public Searchbar(int width, int height) {
        super.width = width;
        super.height = height;
    }

    @FXML
    private void searchAction(ActionEvent event) {
    }
    
}
