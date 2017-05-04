/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 *
 * @author Kristian
 */
public class Searchbar extends HBox {

    private TextField searchText;
    private Button searchButton;
    
    public Searchbar() {
        searchText = new TextField("Search Product");
        searchButton = new Button("Search");
        
        this.getChildren().addAll(searchText, searchButton);
    }
}
