/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import Tool.SelectTool;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;


public class DeleteCommand implements Command {
    private SelectTool tool;
    private Pane pane;
    Shape deletedShape;


    public DeleteCommand(SelectTool tool,Pane pane) {
        this.tool = tool;
        this.pane = pane;
    }

    @Override
    public void execute(){
        deletedShape=this.tool.getSelectedShape();
        this.pane.getChildren().remove(deletedShape);
    }
    @Override
    public void undo() {
        this.pane.getChildren().add(deletedShape);
    }
    
}
