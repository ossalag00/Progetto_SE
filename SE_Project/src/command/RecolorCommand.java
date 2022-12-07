
package command;

import Tool.SelectTool;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class RecolorCommand implements Command{
    private Color in,out,oldIn,oldOut;
    private SelectTool selectTool;
    private Shape s;


    public RecolorCommand(SelectTool SelectTool,Color in, Color out) {
        this.selectTool=SelectTool;
        this.in = in;
        this.out = out;

    }



    
    @Override
    public void execute(){
        s=selectTool.getSelectedShape();
        oldOut=(Color)s.getStroke();
        oldIn=(Color)s.getFill();
        s.setFill(in);
        s.setStroke(out);
    }
    
    @Override
    public void undo() {
        s.setFill(oldIn);
        s.setStroke(oldOut);
    }
    
}
