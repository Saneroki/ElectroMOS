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

    private Launcher pageSwitcher;
    
    public void setPageSwitcher(Launcher pageSwitcher) {
        this.pageSwitcher = pageSwitcher;
    }

    /**
     * @return the pageSwitcher
     */
    public Launcher getPageSwitcher() {
        return pageSwitcher;
    }

}
