/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tool;

import java.beans.DefaultPersistenceDelegate;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;


/**
 *
 * @author giorgino
 */
public final class ClipBoardTool extends Tool {
    private byte[] value;
    private SelectTool selectTool;
    private Shape copy;
    private ByteArrayOutputStream stream = new ByteArrayOutputStream();
    private static ClipBoardTool instance=null;

    public ClipBoardTool(SelectTool selectTool) {
        this.selectTool = selectTool;
        
        
    }
    
    public static ClipBoardTool getInstance(SelectTool tool){
        if(instance==null){
            instance=new ClipBoardTool(tool);
        }
        return instance;
        
    }
    
    public void setClipBoardTool(Shape s)  {
        try (XMLEncoder encoder = new XMLEncoder(this.stream)) {
            encoder.setPersistenceDelegate(Color.class,new DefaultPersistenceDelegate(
                    new String[]{"red", "green", "blue","opacity"}));
            encoder.writeObject(this.selectTool.getSelectedShape());

        }
        
        
        
    }
    
    public Shape getClipBoardTool() {
 
        try (XMLDecoder decoder = new XMLDecoder(new ByteArrayInputStream(this.stream.toByteArray()))) {
            this.copy= (Shape) decoder.readObject();
            decoder.close();
            this.copy.setEffect(null);
            return this.copy;
        }
        
    }
}
