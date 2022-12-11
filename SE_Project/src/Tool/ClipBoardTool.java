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
import java.io.IOException;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;


/**
 *
 * @author giorgino
 */
public final class ClipBoardTool extends Tool {
    private SelectTool selectTool;
    private Shape copy, toCopy;
    private byte[] myStream;
    
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
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try (XMLEncoder encoder = new XMLEncoder(stream)) {
            encoder.setPersistenceDelegate(Color.class,new DefaultPersistenceDelegate(new String[]{"red", "green", "blue","opacity"}));
            encoder.writeObject(this.selectTool.getSelectedShape());
        } 
        myStream = stream.toByteArray();     
    }
    
    public Shape getClipBoardTool()  {
        
        try (XMLDecoder decoder = new XMLDecoder(new ByteArrayInputStream(myStream))) {
            this.copy= (Shape) decoder.readObject();
            if(this.copy!=null)
                this.copy.setEffect(null);
            return this.copy;
        }
    }
}
