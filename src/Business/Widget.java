package Logic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marcg
 */
class Widgets {
    String desc;
    int x;
    int y;
    
    Widgets(int x, int y, String desc){
        this.x = x;
        this.y = y;
        this.desc = desc;
               
    }
    
    void setX(int x){
        this.x = x;
    }
    
    void setY(int y){
        this.y = y;
    }
    
    int getX(){
        return x;
    }
    
    int getY(){
        return y;
    }
    
    void setDesc(String desc){
        this.desc = desc;
    }
    
    String getDesc(){
        return desc;
    }
    
    
}
