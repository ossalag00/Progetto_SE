/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import Tool.*;

/**
 *
 * @author ciroc
 */
public class ToFrontCommand implements Command{
    private SelectTool selectTool;

    public ToFrontCommand(SelectTool selectTool) {
        this.selectTool = selectTool;
    }

    @Override
    public void execute() {
        if(!this.selectTool.isToggle()){
            this.selectTool.getSelectedShape().toFront();
        }
    }
    
    
}
