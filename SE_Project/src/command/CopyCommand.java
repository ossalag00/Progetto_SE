/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import Tool.*;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

/**
 *
 * @author giorgino
 */
public class CopyCommand implements Command{
    
    private SelectTool selectTool;
    private ClipBoardTool clipBoard;
    
    
    
    
    public  CopyCommand(SelectTool tool){
        this.selectTool=tool;
        this.clipBoard= ClipBoardTool.getInstance(tool);
    }

    @Override
    public void execute() {
            this.clipBoard.setClipBoardTool(this.selectTool.getSelectedShape());
    }
    
   
    
}
