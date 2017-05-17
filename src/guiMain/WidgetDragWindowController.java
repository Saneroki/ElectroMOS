/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiMain;

import guiWidgets.Widget;
import guiWidgets.WidgetSelector;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Kristian
 */
public class WidgetDragWindowController implements Initializable {

    @FXML
    private ScrollPane scrollPaneWidgets;
    private ArrayList<Widget> widgets;
    @FXML
    private VBox vBox;
    
    public void setAvailableWidgets(ArrayList<Widget> widgets) {
        this.widgets = widgets;
        this.addAllWidgetsToPane();
    }
    
    private void addAllWidgetsToPane() {
        for(Widget widget : widgets) {
            vBox.getChildren().add(widget.getNode());
            
            widget.getNode().setStyle("-fx-border-color:red; -fx-background-color: blue;");
            
            widget.getNode().setOnDragDetected((event) -> {
                Dragboard db = widget.getNode().startDragAndDrop(TransferMode.ANY);
                ClipboardContent c = new ClipboardContent();
                c.putString(widget.getFxmlName());
                db.setContent(c);
                
                event.consume();
            });
            
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
