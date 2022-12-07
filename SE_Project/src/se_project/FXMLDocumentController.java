/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package se_project;

import Tool.*;
import command.*;
import java.beans.DefaultPersistenceDelegate;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.stage.FileChooser;


public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private TitledPane Window;
    @FXML
    private MenuItem rectangle;
    @FXML
    private MenuItem ellipse;
    @FXML
    private MenuItem line;
    @FXML
    private ColorPicker colorPickerOut;
    @FXML
    private ColorPicker colorPickerIn;
    @FXML
    private Button clear;
    @FXML
    private Pane DrawingWindow;
    
    ToolBar toolBar=new ToolBar();
    RectangleTool recTool=new RectangleTool();
    EllipseTool ellipseTool=new EllipseTool();
    LineTool lineTool=new LineTool();
    Invoker invoker= new Invoker();
    SelectTool selectTool= new SelectTool();
    @FXML
    private MenuItem saveBtn;
    @FXML
    private MenuItem loadBtn;
    @FXML
    private TextField shapeText;
    @FXML
    private Button selectBtn;
    @FXML
    private ContextMenu contextMenu;
    @FXML
    private MenuItem move;
    @FXML
    private MenuItem recolor;
    @FXML
    private MenuItem delete;
    @FXML
    private MenuItem foreground;
    @FXML
    private MenuItem copy;
    @FXML
    private Button undoBtn;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        shapeText.setEditable(false);
        recTool.setDrawingWindow(DrawingWindow);
        ellipseTool.setDrawingWindow(DrawingWindow);
        lineTool.setDrawingWindow(DrawingWindow);
        
    }    
    
        @FXML
    private void mousePressed(MouseEvent event) {
        if(toolBar.getCurrentState()!=null){
            toolBar.getCurrentState().mouseDown(event);
        }
    }
    
    @FXML
    private void mouseReleased(MouseEvent event) {
      if((toolBar.getCurrentState() instanceof DrawingTool)){
            invoker.setCommand(new DrawCommand(toolBar.getCurrentState(),event));
            invoker.executeCommand();  
        }
    }/*Metodo che al rilascio del mouse setta le coordinate di arrivo del tool
    selezionato e tramite l'invoker richiama il comando per disegnare la figura*/
    
      
    @FXML
    private void setRectangle(ActionEvent event) {
        toolBar.setCurrentState(recTool);
        shapeText.setText("Rectangle");
    }

    @FXML
    private void setEllipse(ActionEvent event) {
        toolBar.setCurrentState(ellipseTool);
        shapeText.setText("Ellipse");
    }

    @FXML
    private void setLine(ActionEvent event) {
        toolBar.setCurrentState(lineTool);
        shapeText.setText("Line");
    }

    @FXML
    private void pickColorOut(ActionEvent event) {
        Color c=colorPickerOut.getValue();
        recTool.setOut(c);
        ellipseTool.setOut(c);
        lineTool.setOut(c);
    }

    @FXML
    private void pickColorIn(ActionEvent event) {
        Color c=colorPickerIn.getValue();
        recTool.setIn(c);
        ellipseTool.setIn(c);
    }

    @FXML
    private void clear(ActionEvent event) {
        Alert alert = new Alert(AlertType.WARNING,"Sei sicuro di voler proseguire? Tutto il lavoro verrà perso");
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get()==ButtonType.OK)
            DrawingWindow.getChildren().clear();
    }
   
    @FXML
    private void save(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
 
        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Xml files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);
        
        //Show save file dialog
        File file = fileChooser.showSaveDialog(DrawingWindow.getScene().getWindow());
        XMLEncoder encoder;
        try {
            encoder = new XMLEncoder(new FileOutputStream(new File(file.getPath())));
            encoder.setPersistenceDelegate(Color.class,new DefaultPersistenceDelegate(
                    new String[]{"red", "green", "blue","opacity"}));
            encoder.writeObject(DrawingWindow.getChildren().toArray(new Node[0]));
            encoder.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    

    @FXML
    private void load(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
 
        
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Xml files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showOpenDialog(DrawingWindow.getScene().getWindow());
        XMLDecoder decoder;
        try {
            decoder = new XMLDecoder(new FileInputStream(new File(file.getPath())));
            DrawingWindow.getChildren().setAll((Node[]) decoder.readObject());
            decoder.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void setSelect(ActionEvent event) {
        toolBar.setCurrentState(selectTool);
        shapeText.setText("Select");
        
    }

    @FXML
    private void contextMenuShow(ContextMenuEvent event) {
        if(selectTool.isToggle())
            event.consume();
    }

    @FXML
    private void moveShape(ActionEvent event) {
        invoker.setCommand(new MoveCommand(selectTool));
        invoker.executeCommand();
    }

    @FXML
    private void recolorShape(ActionEvent event) {
        invoker.setCommand(new RecolorCommand(selectTool ,colorPickerIn.getValue(),colorPickerOut.getValue()));
        invoker.executeCommand();
        selectTool.deSelect();
    }

    @FXML
    private void deleteaShape(ActionEvent event) {
        invoker.setCommand(new DeleteCommand(selectTool,DrawingWindow));
        invoker.executeCommand();
        selectTool.deSelect();
    }

    @FXML
    private void toFrontShape(ActionEvent event) {
        if(toolBar.getCurrentState()==selectTool){
            invoker.setCommand(new ToFrontCommand(selectTool));
            invoker.executeCommand();
            selectTool.deSelect();
        }
    }

    @FXML
    private void copyShape(ActionEvent event) {
        invoker.setCommand(new CopyCommand(selectTool));
        invoker.executeCommand();
        selectTool.deSelect();
    }

    @FXML
    private void undoAction(ActionEvent event) {
        invoker.undoLast();
    }
}
