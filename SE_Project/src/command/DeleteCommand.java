/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import Tool.SelectTool;
import javafx.scene.layout.Pane;


public class DeleteCommand implements Command {
    private SelectTool tool;
    private Pane pane;



    public DeleteCommand(SelectTool tool,Pane pane) {
        this.tool = tool;
        this.pane = pane;
    }

    @Override
    public void execute(){
        if(!tool.isToggle())
            this.pane.getChildren().remove(this.tool.getSelectedShape());
        
        
    }
    
}
