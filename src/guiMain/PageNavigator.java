/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiMain;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

/**
 *
 * @author Glenn
 */
public class PageNavigator {
    public static final String MAINPAGEFXML     = "SCENE_FXML_MainPage.fxml";
    public static final String PAGEPLANERFXML   = "SCENE_FXML_PagePlaner.fxml";

    
    private static SCENE_CTRL_PagePlaner pagePlaner;
    private static SCENE_CTRL_MainPage mainPage;
    
    
    static void setMainController(SCENE_CTRL_MainPage mainPage) {
        PageNavigator.mainPage = mainPage;
    }

    static void loadContent(String fxml) {
        try {
            mainPage.setContent((Node) FXMLLoader.load(
                    PageNavigator.class.getResource(fxml)));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
