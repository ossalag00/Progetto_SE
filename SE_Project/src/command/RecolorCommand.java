
package command;

import Tool.SelectTool;
import javafx.scene.paint.Color;

public class RecolorCommand implements Command{
    private Color in,out;
    private SelectTool selectTool;


    public RecolorCommand(SelectTool SelectTool,Color in, Color out) {
        this.selectTool=SelectTool;
        this.in = in;
        this.out = out;

    }



    
    @Override
    public void execute(){
        if(!this.selectTool.isToggle()){
            this.selectTool.getSelectedShape().setFill(in);
            this.selectTool.getSelectedShape().setStroke(out);
        }
    }
    
}
