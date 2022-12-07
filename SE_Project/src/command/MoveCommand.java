/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import Tool.SelectTool;
import javafx.scene.Cursor;
import javafx.scene.shape.Shape;

public class MoveCommand implements Command {
     private SelectTool tool;
    private double startX,startY;
    private Shape selected;
    
    
    public MoveCommand(SelectTool t){
        this.tool=t;
        this.selected=this.tool.getSelectedShape();
    }
    
    
    @Override
    public void execute() {
            this.selected.setCursor(Cursor.MOVE);
            this.selected.setOnMousePressed( e-> {
                startX = this.selected.getLayoutX() - e.getX();
                startY = this.selected.getLayoutY() - e.getY();
        });
            this.selected.setOnMouseDragged(e-> {
                this.selected.setTranslateX(this.selected.getTranslateX()+e.getX()+startX);
                this.selected.setTranslateY(this.selected.getTranslateY()+e.getY()+startY);
        });
            this.selected.setOnMouseReleased(e->{
                this.selected.setCursor(Cursor.DEFAULT);
                this.selected.setOnMousePressed(event->{
                    
                });
                this.selected.setOnMouseDragged(value ->{
                    
                });
            });
        
    }

    @Override
    public void undo() {
        
    }
    
   
    
}
