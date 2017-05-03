/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author andt
 */
public abstract class Widget {

    protected int height;
    protected int width;

//        public Widget(int width, int height){
//            this.height = height;
//            this.width = width;
//        }
    public void setHeight(int value) {
        this.height = value;
    }

    public void setWidth(int value) {
        this.width = value;
    }
}
