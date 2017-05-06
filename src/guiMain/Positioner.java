/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiMain;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javax.jws.Oneway;

/**
 *
 * @author Kristian
 */
public class Positioner extends ImageView {

    private Node widget;
    private MouseEvent currentMouseEvent;
    private boolean beingDragged;
    private static final Image controllerImage = new Image("positioner.png");

    public Positioner(Node node) {
        this.widget = node;
        this.setImage(controllerImage);
        this.initialize();

    }

    private void initialize() {
        this.setOnMouseEntered((MouseEvent event) -> {
            if (!beingDragged) {
                getScene().setCursor(Cursor.HAND);
            }
        });
        this.setOnMouseExited((MouseEvent event) -> {
            if (!beingDragged) {
                getScene().setCursor(Cursor.DEFAULT);
            }
        });
        this.setOnDragDetected((MouseEvent event) -> {
            onDrag(event);
        });
        
        /*
        this.setOnMouseReleased((event) -> {
            onDragDone();
        });
        this.setOnMouseMoved((MouseEvent event) -> {
            beingDragged();
        });
        this.setOnMouseExited((MouseEvent event) -> {
            beingDragged();
        });
        */
    }

    /**
     * @return the widget
     */
    public Node getWidget() {
        return widget;
    }

    private void onDrag(MouseEvent event) {
        this.beingDragged = true;
        this.currentMouseEvent = event;
        
        Dragboard db = this.startDragAndDrop(TransferMode.MOVE);
        
        ClipboardContent c = new ClipboardContent();
        c.putImage(this.getImage());
        db.setContent(c);
        
        db.setDragView(controllerImage);
    }

    private void onDragDone() {
        getScene().setCursor(Cursor.DEFAULT);
        System.out.println("Drag done!");
        this.beingDragged = false;
    }

    public void beingDragged() {
        if (this.beingDragged) {
            getScene().setCursor(Cursor.CLOSED_HAND);

            this.layoutXProperty().set(this.currentMouseEvent.getX());
            this.layoutYProperty().set(this.currentMouseEvent.getY());

        }
    }
}
