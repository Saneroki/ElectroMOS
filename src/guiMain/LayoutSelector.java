/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiMain;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Kristian
 */
public abstract class LayoutSelector extends Stage {

    private Scene scene;
    private ChoiceBox choices;

    public LayoutSelector(String title) {
        this.setTitle(title);
        this.setResizable(false);
        this.initialize();
    }

    /**
     * @author Kristian
     */
    private void initialize() {
        VBox vbox = new VBox();
        AnchorPane pane = new AnchorPane();
        pane.getChildren().add(vbox);
        this.scene = new Scene(pane);

        Button accept = new Button("Accept");
        Button cancel = new Button("Cancel");
        HBox buttonChoices = new HBox(cancel, accept);
        buttonChoices.setPadding(new Insets(8, 4, 4, 2));

        Label label = new Label("Select Layout");
        label.setFont(new Font("Arial", 18));
        label.setPadding(new Insets(2, 8, 8, 2));

        choices = new ChoiceBox();
        choices.setMinSize(280, 32);
        vbox.getChildren().addAll(label, choices, buttonChoices);
        vbox.setMinWidth(300);
        vbox.setMinHeight(100);
        vbox.setLayoutX(8);

        this.setScene(scene);

        accept.setOnAction((ActionEvent event) -> {
            onAccept();
        });
        cancel.setOnAction((ActionEvent event) -> {
            onCancel();
        });
    }
    
    /**
     * @author Kristian
     */
    public abstract void onAccept();

    /**
     * @author Kristian
     */
    public void onCancel() {
        this.hide();
    }
    
    public void setList(ArrayList<String> string) {
        choices.getItems().addAll(string);
        choices.getSelectionModel().select(0);
    }
    
    public String getChosenLayout() {
        return (String) choices.getSelectionModel().getSelectedItem();
    }
}
