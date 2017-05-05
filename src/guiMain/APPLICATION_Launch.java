/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiMain;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Glenn
 */
public class APPLICATION_Launch extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Main Page");
        
        stage.setScene(createScene(loadMainPane()));
        stage.show();
    }
    
    
    private Pane loadMainPane() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        
        Pane mainPane = (Pane) loader.load(
                getClass().getResourceAsStream(PageNavigator.MAINPAGEFXML));
        
        SCENE_CTRL_MainPage mainCtrl = loader.getController();
        
        PageNavigator.setMainController(mainCtrl);
        PageNavigator.loadContent(PageNavigator.MAINPAGEFXML);
        
        return mainPane;
    }
    
    private Scene createScene (Pane pane) {
        Scene scene = new Scene(pane);
        
        return scene;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
