/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import Tool.ClipBoardTool;
import Tool.SelectTool;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;


public class CutCommand implements Command {
     
    private SelectTool selectTool;
    private ClipBoardTool clipBoard;
    private Pane pane;
    private Shape s;
    
    public  CutCommand(SelectTool tool,Pane pane){
        this.selectTool=tool;
        this.pane=pane;
        this.clipBoard= ClipBoardTool.getInstance(tool);
        this.s=tool.getSelectedShape();
    }

    @Override
    public void execute() {
        this.clipBoard.setClipBoardTool(this.selectTool.getSelectedShape());
        this.pane.getChildren().remove(this.selectTool.getSelectedShape());
        
    }
    
    @Override
    public void undo() {
        this.clipBoard.setClipBoardTool(null);
        this.pane.getChildren().add(s);
        this.s.setEffect(null);
    }
    
}
