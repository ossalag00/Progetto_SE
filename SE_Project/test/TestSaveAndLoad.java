/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.beans.DefaultPersistenceDelegate;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import se_project.FXMLDocumentController;

/**
 *
 * @author ciroc
 */
public class TestSaveAndLoad {
    private Pane pane;
    private Shape s;
    
    public TestSaveAndLoad() {
    }
    
    @BeforeClass
    public static void setUpClass() {

    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.pane=new Pane();
        this.s=new Rectangle(10,20,30,40);
        pane.getChildren().add(s);
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void saveAndLoad(){
    XMLEncoder encoder;
        try {
            encoder = new XMLEncoder(new FileOutputStream(new File("test.xml")));
            encoder.setPersistenceDelegate(Color.class,new DefaultPersistenceDelegate(
                    new String[]{"red", "green", "blue","opacity"}));
            encoder.writeObject(pane.getChildren().toArray(new Node[0]));
            encoder.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        XMLDecoder decoder;
        try {
            decoder = new XMLDecoder(new FileInputStream(new File("test.xml")));
            pane.getChildren().setAll((Node[]) decoder.readObject());
            decoder.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Shape s2=(Shape) pane.getChildren().get(0);
        assert(s2.getLayoutX()==s.getLayoutX());
        assert(s2.getLayoutY()==s.getLayoutY());
    }
}
