/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import Tool.*;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

/**
 *
 * @author giorgino
 */
public class PasteCommand implements Command {
    
    private Shape pasted;
    private ClipBoardTool clipBoard;
    private Pane pane;
    private SelectTool selectTool;
    
    public PasteCommand(SelectTool tool,Pane pane){
        this.pane=pane;
        this.selectTool=tool;
        this.clipBoard=ClipBoardTool.getInstance(tool);
        
    }

    @Override
    public void execute() {
        this.pasted=this.clipBoard.getClipBoardTool();
        this.pasted.setTranslateX(5);
        this.pasted.setTranslateY(5);
        this.pane.getChildren().add(this.pasted);
        
        
    }

    @Override
    public void undo() {
        this.pane.getChildren().remove(this.pasted);
    }
    
    
}
