/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiWidgets;

import guiMain.Controller;
import guiMain.Page;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 *
 * @author Kristian
 */
public class WidgetSelector {

    private ArrayList<Widget> widgets;
    private File directory;

    public WidgetSelector() {
        this.widgets = new ArrayList();
        
        try {
            this.updateWidgets();
        } catch (IOException ex) {
            System.out.println("Widget selector was unable to load widgets");
            Logger.getLogger(WidgetSelector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateWidgets() throws IOException {
        directory = new File(System.getProperty("user.dir") + "/src/guiWidgets");
        loadAll(getFilteredFiles("fxml"));
    }

    private ArrayList<String> getFilteredFiles(String fileExtensionWanted) {
        ArrayList<String> returnStrings = new ArrayList();

        for (File file : directory.listFiles()) {
            
            String extension = file.toString().split("\\.")[1];
            if(extension.equals(fileExtensionWanted)) {
                returnStrings.add(file.getName());
            }
        }
        return returnStrings;
    }
    
    private void loadAll(ArrayList<String> paths) throws IOException {
        for(String string : paths) {
            this.loadWidget(string);
        }
    }
    
    private void loadWidget(String fileName) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Node root = FXMLLoader.load(getClass().getResource(fileName));
        
        System.out.println("Class name: "+root.getClass().getSimpleName());
        
        
        
        this.getWidgets().add(new Widget(root, fileName));
    }

    /**
     * @return the widgets
     */
    public ArrayList<Widget> getWidgets() {
        return widgets;
    }
    
    public Widget getWidget(String name) {
        for(Widget widget : widgets) {
            if(name == null ? widget.getFxmlName() == null : name.equals(widget.getFxmlName())) {
                return widget;
            }
        }
        return null;
    }
}
