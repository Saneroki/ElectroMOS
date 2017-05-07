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

    private APPLICATION_Launch pageSwitcher;
    
    public void setPageSwitcher(APPLICATION_Launch pageSwitcher) {
        this.pageSwitcher = pageSwitcher;
    }

    /**
     * @return the pageSwitcher
     */
    public APPLICATION_Launch getPageSwitcher() {
        return pageSwitcher;
    }

}
