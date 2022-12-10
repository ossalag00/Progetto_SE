/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import Tool.SelectTool;
import javafx.scene.shape.Shape;

/**
 *
 * @author ciroc
 */
public class ToBackCommand implements Command{
    private SelectTool selectTool;
    private Shape s;

    public ToBackCommand(SelectTool selectTool) {
        this.selectTool = selectTool;
    }

    @Override
    public void execute() {
        this.selectTool.getSelectedShape().toBack();
        s=this.selectTool.getSelectedShape();
    }
    

    @Override
    public void undo(){
        s.toFront();
    }
    
    
}
