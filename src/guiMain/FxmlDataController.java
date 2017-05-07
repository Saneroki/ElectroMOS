/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiMain;

import Business.BusinessController;
import guiWidgets.Campaign;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Glenn
 */
public class FxmlDataController implements Initializable {

    BusinessController mediator;
    private LayoutSelect layoutEdit;
    private LayoutSelect layoutDelete;

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
    private AnchorPane pageCenter;
    @FXML
    private ChoiceBox<?> choiceBoxTop1;
    @FXML
    private ChoiceBox<?> choiceBoxTop2;
    @FXML
    private ChoiceBox<?> choiceBoxTop3;
    @FXML
    private ChoiceBox<?> choiceBoxLeft1;
    @FXML
    private ChoiceBox<?> choiceBoxLeft2;
    @FXML
    private ChoiceBox<?> choiceBoxLeft3;
    @FXML
    private ChoiceBox<?> choiceBoxBottom1;
    @FXML
    private ChoiceBox<?> choiceBoxBottom3;
    @FXML
    private ChoiceBox<?> choiceBoxBottom2;
    @FXML
    private ChoiceBox<?> choiceBoxCenter1;
    @FXML
    private ChoiceBox<?> choiceBoxCenter2;
    @FXML
    private ChoiceBox<?> choiceBoxCenter3;
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
        this.fillChoiceBoxes();
        this.mediator = BusinessController.getBusinessController();
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
        }
        
        if (button == this.buttonEditLayout) {
            this.layoutEdit.show();
        }
        
        if (button == this.buttonLayoutDelete) {
            this.layoutDelete.show();
        }
    }

    @FXML
    private void onWidgetSelect(MouseEvent event) {
    }

    private void fillChoiceBoxes() {
        fillUpperBox(this.choiceBoxTop1);
        fillUpperBox(this.choiceBoxTop2);
        fillUpperBox(this.choiceBoxTop3);
    }

    private void fillUpperBox(ChoiceBox box) {
        box.setItems(FXCollections.observableArrayList("None", "Insert Searchbar", "Insert Login Button", "Insert Campaign"));
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

    private void placeWidget(ChoiceBox box, Node node) {
        AnchorPane parent = ((AnchorPane) box.getParent());
        double posX, posY;
        posX = box.getLayoutX();
        posY = box.getLayoutY();

        box.setVisible(false);

        parent.getChildren().add(node);
        node.setLayoutX(posX);
        node.setLayoutY(posY);

        //add to business
        if (box.getParent() == pageTop) {
        } else if (box.getParent() == pageCenter) {
        } else if (box.getParent() == pageFoot) {
        } else {
        }

        //on right click remove!
        node.setOnContextMenuRequested((event) -> {
            box.setVisible(true);
            ((AnchorPane) node.getParent()).getChildren().remove(node);
            if (box.getParent() == pageTop) {
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

//        switch ((String) box.getValue()) {
//            case "Insert Searchbar":
//                this.placeWidget(box, new SearchBar());
//                break;
//
//            case "Insert Campaign":
//                this.placeWidget(box, new Campaign());
//                break;
//
//            case "Insert Login Button":
//                this.placeWidget(box, new ButtonLogin());
//                break;
//
//            default:
//                System.out.println("String: " + (String) box.getValue());
//                break;
//        }
    }
}
