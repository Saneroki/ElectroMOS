/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiMain;

import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.Pair;

/**
 *
 * @author Kristian
 */
public class DialogCreateLayout extends Dialog {

    public DialogCreateLayout() {
        this.setTitle("Create New Layout");
        this.setHeaderText("Please enter a name for the new layout");
        VBox vbox = new VBox();
        Label label = new Label("Layout Name:");
        TextField field = new TextField("Layout Name");
        vbox.getChildren().addAll(label, field);

        this.getDialogPane().setContent(vbox);
        
        ButtonType type = new ButtonType("Create!", ButtonData.OK_DONE);
        this.getDialogPane().getButtonTypes().add(type);
        
        this.setResultConverter((param) -> {
            return new Pair("", field.getText());
        });
    }
}
