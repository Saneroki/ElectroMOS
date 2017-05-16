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
public abstract class Controller {

    private Launcher sceneSwitcher;
    
    public void setSceneSwitcher(Launcher sceneSwitcher) {
        this.sceneSwitcher = sceneSwitcher;
    }

    /**
     * @return the pageSwitcher
     */
    public Launcher getSceneSwitcher() {
        return sceneSwitcher;
    }

}
