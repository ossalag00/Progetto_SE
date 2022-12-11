
package command;

import Tool.SelectTool;
import javafx.scene.Cursor;
import javafx.scene.shape.Shape;

public class MoveCommand implements Command {
    private SelectTool tool;
    private double startX,startY,undoX,undoY;
    private Shape selected;
    
    
    public MoveCommand(SelectTool t){
        this.tool=t;
        this.selected=this.tool.getSelectedShape();
    }
    
    
    @Override
    public void execute() {
        this.selected.getScene().setCursor(Cursor.MOVE);
        this.selected.setOnMousePressed( e-> {
            this.startX =  e.getSceneX();
            this.startY = e.getSceneY();
            this.undoX=this.selected.getTranslateX();
            this.undoY=this.selected.getTranslateY();
        });
        this.selected.setOnMouseDragged(e-> {
            this.selected.setTranslateX(this.selected.getTranslateX()+e.getSceneX()-startX);
            this.selected.setTranslateY(this.selected.getTranslateY()+e.getSceneY()-startY);
            this.startX= e.getSceneX();
            this.startY=e.getSceneY();
        });
        this.selected.setOnMouseReleased(e->{
            this.selected.getScene().setCursor(Cursor.DEFAULT);
            this.undoX=this.selected.getTranslateX()-undoX;
            this.undoY=this.selected.getTranslateY()-undoY;
            this.selected.setOnMousePressed(event->{
                
            });
            this.selected.setOnMouseDragged(value ->{
                
            });
        });
    }

    @Override
    public void undo() {
        this.selected.setTranslateX(selected.getTranslateX()-undoX);
        this.selected.setTranslateY(selected.getTranslateY()-undoY);
    }
    
   
    
}
