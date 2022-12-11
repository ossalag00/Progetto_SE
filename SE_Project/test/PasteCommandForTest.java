/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import Tool.*;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

/**
 *
 * @author giorgino
 */
public class PasteCommandForTest {
    
    private Shape pasted;
    private ClipBoardTool clipBoard;
    private Pane pane;
    private SelectToolForTest selectTool;
    
    public PasteCommandForTest (SelectToolForTest tool,Pane pane){
        this.pane=pane;
        this.selectTool=tool;
        this.clipBoard=ClipBoardTool.getInstance(tool);
        this.pasted=this.clipBoard.getClipBoardTool();
    }

    
    public Shape execute() {
        this.pasted.setTranslateX(5);
        this.pasted.setTranslateY(5);
        this.pane.getChildren().add(this.pasted);
        this.selectTool.deSelect();
        return pasted;
        
        
    }
    
    public void undo(){
        this.pane.getChildren().remove(this.pasted);
    }
    
}

