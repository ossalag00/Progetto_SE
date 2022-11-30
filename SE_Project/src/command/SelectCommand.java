/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import Tool.Tool;
import javafx.scene.shape.Shape;

/**
 *
 * @author lessa
 */
public class SelectCommand implements Command {
    private Tool tool;
    private Shape s;
    private boolean select;

    public SelectCommand(Tool tool,Shape s) {
        this.tool = tool;
        this.s=s;
    }

    @Override
    public void execute() {
        this.tool.select(this.s);
    }
}
