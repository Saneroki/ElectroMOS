/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Business.BusinessController;
import guiMain.Controller;
import guiMain.DialogCreateLayout;
import guiMain.LayoutSelect;
import guiWidgets.Campaign;
import guiWidgets.Widget;
import guiWidgets.WidgetSelector;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author Glenn
 */
public class FxmlDataController extends Controller implements Initializable {

    private BusinessController mediator;
    private LayoutSelect layoutEdit;
    private LayoutSelect layoutDelete;
    private WidgetSelector widgetSelector;

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
    private Pane paneTopLeft;
    @FXML 
    private Pane PaneTopCenter;
    @FXML
    private Pane PaneTopRight;
    @FXML
    private AnchorPane pageCenter;
    @FXML
    private ChoiceBox<Widget> choiceBoxTop1;
    @FXML
    private ChoiceBox<Widget> choiceBoxTop2;
    @FXML
    private ChoiceBox<Widget> choiceBoxTop3;
    @FXML
    private ChoiceBox<Widget> choiceBoxLeft1;
    @FXML
    private ChoiceBox<Widget> choiceBoxLeft2;
    @FXML
    private ChoiceBox<Widget> choiceBoxLeft3;
    @FXML
    private ChoiceBox<Widget> choiceBoxBottom1;
    @FXML
    private ChoiceBox<Widget> choiceBoxBottom3;
    @FXML
    private ChoiceBox<Widget> choiceBoxBottom2;
    @FXML
    private ChoiceBox<Widget> choiceBoxCenter1;
    @FXML
    private ChoiceBox<Widget> choiceBoxCenter2;
    @FXML
    private ChoiceBox<Widget> choiceBoxCenter3;
    @FXML
    private Button buttonUpdatePreview;
    @FXML
    private Button buttonLayoutNew;
    @FXML
    private Button buttonEditLayout;
    @FXML
    private Button buttonLayoutDelete;

    private void handleButtonAction(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        this.widgetSelector = new WidgetSelector();
        this.fillChoiceBoxes();

        this.layoutEdit = new LayoutSelect("Select Layout to Edit") {
            @Override
            public void onAccept() {

            }
        };
        this.layoutDelete = new LayoutSelect("Select Layout to Delete") {
            @Override
            public void onAccept() {

            }
        };
    }

    @FXML
    private void buttonListener(ActionEvent event) {
        Button button = (Button) event.getSource();

        //Check if preview button and activate
        if (button == this.buttonUpdatePreview) {
            this.refreshPreview();
        }

        if (button == this.buttonAccept) {
            mediator.acceptLayout("FrontPage");
        }

        if (button == this.buttonEditLayout) {
            this.layoutEdit.show();
        }

        if (button == this.buttonLayoutDelete) {
            this.layoutDelete.show();
        }
        
        if (button == this.buttonLayoutNew) {
            new DialogCreateLayout().showAndWait();
        }
    }

    @FXML
    private void onWidgetSelect(MouseEvent event) {
    }

    private void fillChoiceBoxes() {
        fillUpperBox(this.choiceBoxTop1);
        fillUpperBox(this.choiceBoxTop2);
        fillUpperBox(this.choiceBoxTop3);
        fillUpperBox(this.choiceBoxBottom1);
        fillUpperBox(this.choiceBoxBottom2);
        fillUpperBox(this.choiceBoxBottom3);
        fillUpperBox(this.choiceBoxCenter1);
        fillUpperBox(this.choiceBoxCenter2);
        fillUpperBox(this.choiceBoxCenter3);
        fillUpperBox(this.choiceBoxLeft1);
        fillUpperBox(this.choiceBoxLeft2);
        fillUpperBox(this.choiceBoxLeft3);
    }

    private void fillUpperBox(ChoiceBox box) {

        ArrayList<Widget> options = new ArrayList();
        for (Widget widget : widgetSelector.getWidgets()) {
            options.add(widget);
        }

        box.setItems(FXCollections.observableArrayList(options));
    }

    private void fillLeftBox(ChoiceBox box) {
        box.setItems(FXCollections.observableArrayList("None", "Insert Searchbar", "Insert Login Button", "Insert Campaign"));
    }

    private void fillCenterBox(ChoiceBox box) {
        box.setItems(FXCollections.observableArrayList("None", "Insert Searchbar", "Insert Login Button", "Insert Campaign"));
    }

    private void fillBottomBox(ChoiceBox box) {

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
            } else if (box.getParent() == pageCenter) {
            } else if (box.getParent() == pageFoot) {
            } else {
            }
        });

    }

    private void refreshPreview() {
        this.refreshWidget(this.choiceBoxBottom1);
        this.refreshWidget(this.choiceBoxBottom2);
        this.refreshWidget(this.choiceBoxBottom3);
        this.refreshWidget(this.choiceBoxCenter1);
        this.refreshWidget(this.choiceBoxCenter2);
        this.refreshWidget(this.choiceBoxCenter3);
        this.refreshWidget(this.choiceBoxLeft1);
        this.refreshWidget(this.choiceBoxLeft2);
        this.refreshWidget(this.choiceBoxLeft3);
        this.refreshWidget(this.choiceBoxTop1);
        this.refreshWidget(this.choiceBoxTop2);
        this.refreshWidget(this.choiceBoxTop3);
    }

    private void refreshWidget(ChoiceBox box) {
        if (box.getValue() == null || !box.isVisible()) {
            return;
        }
        
        

        try {
            this.placeWidget(box, this.widgetSelector.getWidget(((Widget) box.getValue()).getFxmlName()));
        } catch (IOException ex) {
            Logger.getLogger(FxmlDataController.class.getName()).log(Level.SEVERE, null, ex);
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
    }
}
