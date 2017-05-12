/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiMain;

import guiWidgets.WidgetSelector;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Glenn
 */
public class Launcher extends Application {

    private Stage stage;
    private HashMap<Scenes, Controller> scene;
    private WidgetSelector widgetSelector;

    @Override
    public void start(Stage stage) throws Exception {
        this.scene = new HashMap();
        this.stage = stage;
        setSceneFromString(Scenes.LOGINTODB);
        stage.show();
    }

    public void setSceneFromString(Scenes scene) {
        try {
            stage.setScene(this.loadSceneContent(scene));
            this.changeStageTitle("ElectroMOS - " + scene.getSceneTitle());
            stage.centerOnScreen();
        } catch (IOException ex) {
            System.out.println("Unable to open file");
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Scene loadSceneContent(Scenes fxmlName) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Parent root = loader.load(
                getClass().getResourceAsStream(fxmlName.toString()));
        
        Controller mainCtrl = loader.getController();

        this.scene.put(fxmlName, mainCtrl);
        
        mainCtrl.setSceneSwitcher(this);
        Scene newScene = new Scene(root);
        return newScene;
    }
    
        public void changeStageTitle(String name) {
        this.stage.setTitle(name);
    }

    /**
     * @param sceneController
     * @return the scene
     */
    public Controller getController(Scenes sceneController) {
        return scene.get(sceneController);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
