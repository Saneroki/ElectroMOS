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
public enum Scenes {
    LOGINTODB("LoginToDatabase.fxml"),
    PAGEPLANNER("Pageplaner.fxml");

    private String pageName;

    private Scenes(String string) {
        this.pageName = string;
    }

    @Override
    public String toString() {
        return this.pageName;
    }
}
