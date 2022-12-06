/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import Tool.*;
import javafx.scene.shape.Shape;

/**
 *
 * @author giorgino
 */
public class CopyCommandForTest{
    
    private SelectTool selectTool;
    private ClipBoardTool clipBoard;
    
    
    
    
    public  CopyCommandForTest(SelectTool tool){
        this.selectTool=tool;
        this.clipBoard= ClipBoardTool.getInstance(tool);
    }

   
    public Shape execute() {
        if(!this.selectTool.isToggle()){
            this.clipBoard.setClipBoardTool(this.selectTool.getSelectedShape());
            return this.clipBoard.getClipBoardTool();
        }
        return null;
    }
    
   
    
}

