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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Glenn
 */
public class Launcher extends Application {

    private Stage stage;
    private HashMap<Page, Controller> pages;
    private WidgetSelector widgetSelector;

    @Override
    public void start(Stage stage) throws Exception {
        this.pages = new HashMap();
        this.stage = stage;
        stage.setTitle("Main Page");        
        stage.setScene(this.loadLayout(Page.MAINPAGE));
        stage.show();
    }

    public void setSceneFromString(Page page) {
        try {
            stage.setScene(this.loadLayout(page));
            stage.centerOnScreen();
        } catch (IOException ex) {
            System.out.println("Unable to open file");
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Scene loadLayout(Page fxmlName) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Parent root = loader.load(
                getClass().getResourceAsStream(fxmlName.toString()));
        
        Controller mainCtrl = loader.getController();

        this.pages.put(fxmlName, mainCtrl);
        
        mainCtrl.setPageSwitcher(this);
        Scene scene = new Scene(root);
        /*
        PageNavigator.setMainController(mainCtrl);
        PageNavigator.loadContent(PageNavigator.MAINPAGEFXML);
         */
        return scene;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void changeStageTitle(String name) {
        this.stage.setTitle(name);
    }

    /**
     * @param page
     * @return the pages
     */
    public Controller getController(Page page) {
        return pages.get(page);
    }
}
