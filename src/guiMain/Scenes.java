/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiMain;

/**
 *
 * @author Kristian
 */
public enum Scenes {
    LOGINTODB("LoginToDatabase.fxml"),
    PAGEPLANNER("Pageplaner.fxml");

    private String pageName;

    private Scenes(String string) {
        this.pageName = string;
    }

    /**
     * @author Glenn
     * @return a fitting name for the Scene
     */
    public String getSceneTitle() {
        String title = null;
        if (this.pageName.equals(LOGINTODB.toString())) {
            title = "Login";
        } else if (this.pageName.equals(PAGEPLANNER.toString())) {
            title = "Page planer";
        }
        return title;
    }

    @Override
    public String toString() {
        return this.pageName;
    }
}
