/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiMain;

/**
 *
 * @author Glenn
 */
public enum Page {
    MAINPAGE("SCENE_FXML_MainPage.fxml"), PAGEPLANNER("FxmlData.fxml");

    private String pageName;

    private Page(String string) {
        this.pageName = string;
    }

    @Override
    public String toString() {
        return this.pageName;
    }
}
