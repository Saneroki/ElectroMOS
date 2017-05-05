/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiWidgets;

import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

/**
 *
 * @author Kristian
 */
public class Campaign extends ImageView {

    private static Image image = new Image("campaign.png");

    public Campaign() {
        this.setImage(image);
    }
    
    public void setImage() {
        FileChooser fs = new FileChooser();
        image = new Image(fs.showOpenDialog(this.getScene().getWindow()).getPath());
    }

    private void initialize() {
        this.setOnMouseEntered((MouseEvent event) -> {
            getScene().setCursor(Cursor.HAND);
        });
        this.setOnMouseExited((MouseEvent event) -> {
            getScene().setCursor(Cursor.DEFAULT);
        });
    }
}
