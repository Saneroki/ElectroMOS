/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiMain;

import business.BusinessController;
import guiWidgets.Widget;
import guiWidgets.WidgetSelector;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Pair;

/**
 *
 * @author Glenn, Kristian
 */
public class Pageplaner extends Controller implements Initializable {

    private BusinessController mediator;
    private LayoutSelector layoutEdit;
    private LayoutSelector layoutDelete;
    private WidgetSelector widgetSelector;
    private String currentLayout;

    private Label label;
    @FXML
    private Button buttonCancel;
    @FXML
    private Button buttonAccept;
    @FXML
    private AnchorPane pageTop;
    @FXML
    private AnchorPane pageLeft;
    @FXML
    private AnchorPane pageFoot;
    @FXML
    private AnchorPane pageMiddle;
    @FXML
    private Button buttonLayoutNew;
    @FXML
    private Button buttonEditLayout;
    @FXML
    private Button buttonLayoutDelete;
    @FXML
    private VBox vBoxWidgetsAvailable;

    private void handleButtonAction(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.widgetSelector = new WidgetSelector();
        

        addAllWidgetsToPane();
        this.initializePanes();

        this.layoutEdit = new LayoutSelector("Select Layout to Edit") {
            @Override
            public void onAccept() {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Unsaved Progress");
                alert.setContentText("Do you want to save before closing?");
                alert.showAndWait();
                if(alert.getResult().getText() == "OK") {
                    mediator.acceptLayout(currentLayout);
                }
            }
        };
        this.layoutDelete = new LayoutSelector("Select Layout to Delete") {
            @Override
            public void onAccept() {
                this.hide();
                mediator.removePage(this.getChosenLayout());
            }
        };
    }

    private void addAllWidgetsToPane() {
        for (Widget widget : widgetSelector.getWidgets()) {
            Button widgetAvailable = new Button(widget.getFxmlName());
            this.vBoxWidgetsAvailable.getChildren().add(widgetAvailable);

            widget.getNode().setStyle("-fx-border-color:red; -fx-background-color: blue;");

            widgetAvailable.setOnDragDetected((event) -> {
                Dragboard db = widgetAvailable.startDragAndDrop(TransferMode.ANY);
                ClipboardContent c = new ClipboardContent();
                c.putString(widget.getFxmlName());
                db.setContent(c);

                event.consume();
            });

        }
    }

    private void initializePanes() {
        makeDropAble(pageMiddle);
        makeDropAble(pageLeft);
        makeDropAble(pageTop);
        makeDropAble(pageFoot);
    }

    private void makeDropAble(AnchorPane pane) {
        pane.setOnDragOver((event) -> {
            if (event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.COPY);
            }

            event.consume();
        });

        pane.setOnDragDropped((event) -> {
            try {
                Widget widget = widgetSelector.getWidget(event.getDragboard().getString());
                Node node = widget.getNode();
                pane.getChildren().add(node);
                node.setLayoutX(event.getX());
                node.setLayoutY(event.getY());

                node.setOnContextMenuRequested((onDelete) -> {
                    ((Pane) node.getParent()).getChildren().remove(node);
                });

                mediator.addWidget(widget, BusinessController.Area.TOP);
            } catch (IOException ex) {
                System.out.println("Widget is unable to be added to page..\n" + ex);
                Logger.getLogger(Pageplaner.class.getName()).log(Level.SEVERE, null, ex);
            }
            event.consume();
        });
    }

    @FXML
    private void buttonListener(ActionEvent event) {
        Button button = (Button) event.getSource();

        //Check if preview button and activate
        if (button == this.buttonAccept) {
            mediator.acceptLayout(currentLayout);
        }

        if (button == this.buttonEditLayout) {
            this.layoutEdit.show();
        }

        if (button == this.buttonLayoutDelete) {
            this.layoutDelete.show();
        }

        if (button == this.buttonLayoutNew) {
            DialogCreateLayout dialog = new DialogCreateLayout();
            dialog.showAndWait();
            String result = ((Pair<String, String>)dialog.getResult()).getValue();
            if(mediator.pageExists(result)) {
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setTitle("Layout Name already exist!");
                a.setContentText("Do you really want to overwrite?");
                a.showAndWait();
                System.out.println(a.getResult());
            }
            currentLayout = result;
        }
    }

    private void giveChoiceBoxAllOptions(ChoiceBox box) {

        ArrayList<Widget> options = new ArrayList();
        for (Widget widget : widgetSelector.getWidgets()) {
            options.add(widget);
        }

        box.setItems(FXCollections.observableArrayList(options));
    }

    @FXML
    private void contextMenuPageRequested(ContextMenuEvent event) {
    }

    private void placeWidget(ChoiceBox box, Widget widget) {
        Node node = widget.getNode();

        Pane parent = ((Pane) box.getParent());
        double posX, posY;
        posX = box.getLayoutX();
        posY = box.getLayoutY();

        box.setVisible(false);

        parent.getChildren().add(node);
        node.setLayoutX(posX);
        node.setLayoutY(posY);

        mediator.addWidget(widget, BusinessController.Area.TOP);
        //add to business
        //        if (box.getParent() == pageTop) {
        //        } else if (box.getParent() == pageCenter) {
        //        } else if (box.getParent() == pageFoot) {
        //        } else {
        //        }
        //on right click remove!
        node.setOnContextMenuRequested((event) -> {
            box.setVisible(true);
            ((Pane) node.getParent()).getChildren().remove(node);
            if (box.getParent() == pageTop) {
                mediator.removeWidget(widget);
            } else if (box.getParent() == pageMiddle) {
            } else if (box.getParent() == pageFoot) {
            } else {
            }
        });
        //        node.setOnContextMenuRequested((event) -> {
        //            box.setVisible(true);
        //            ((AnchorPane) node.getParent()).getChildren().remove(node);
        //            if (box.getParent() == pageTop) {
        //            } else if (box.getParent() == pageCenter) {
        //            } else if (box.getParent() == pageFoot) {
        //            } else {
        //            }
        //        });

    }

    private void refreshWidget(ChoiceBox box) {
        if (box.getValue() == null || !box.isVisible()) {
            return;
        }
        /*
        switch (box.getValue().toString()) {
            case "Insert Searchbar":
                placeWidget(box, new Searchbar(10, 10));
                break;
            default:
                break;
        }*/

        try {
            this.placeWidget(box, this.widgetSelector.getWidget(((Widget) box.getValue()).getFxmlName()));
        } catch (IOException ex) {
            Logger.getLogger(Pageplaner.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Widget selected: " + box.getValue());
    }

    /**
     * @return the mediator
     */
    public BusinessController getMediator() {
        return mediator;
    }

    /**
     * @param mediator the mediator to set
     */
    public void setMediator(BusinessController mediator) {
        this.mediator = mediator;
        ArrayList<String> layouts = mediator.getAllLayouts();
        
        this.layoutDelete.setList(layouts);
        this.layoutEdit.setList(layouts);
    }

}
