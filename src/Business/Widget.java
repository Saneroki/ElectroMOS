package Business;

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
    int id;
    String desc;
    int x;
    int y;
    int height;
    int width;
    
    Widgets(int id, int x, int y, String desc, int height, int width){
        
        this.id = id;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
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
    
    void setHeight(int height){
        this.height = height;
    }
    
    void setWidth(int width){
        this.width = width;
    }
    
    int getHeight(){
        return this.height;
    }
    
    int getWidth(){
        return this.width;
    }
    
    int getID(){
        return id;
    }                                                   
    
    
}
