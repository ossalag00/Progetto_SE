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
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
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
    SelectTool selectTool=new SelectTool();
    @FXML
    private MenuItem saveBtn;
    @FXML
    private MenuItem loadBtn;
    @FXML
    private TextField shapeText;
    @FXML
    private Button selectBtn;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        shapeText.setEditable(false);
        
        
    }    
    @FXML
    private void initDraw(MouseEvent event) {
        if(toolBar.getCurrentState()==null){
            Alert a = new Alert(Alert.AlertType.WARNING,"You must select a shape");
            a.show();
        }
        else{
        toolBar.getCurrentState().setStartX(event.getX());
        toolBar.getCurrentState().setStartY(event.getY());}
        }/*Metodo richiamato al click del mouse sull'area di disegno che verifica se
        sia stata selezionata una figura(State) e, in tal caso, richiama i metodi
        del Tool selezionato per memorizzare le coordinate iniziali, in caso non sia
        stata selezionata alcuna figura restituisce un avviso a schermo*/
    @FXML
    private void draw(MouseEvent event){
        toolBar.getCurrentState().setEndX(event.getX());
        toolBar.getCurrentState().setEndY(event.getY());
        invoker.setCommand(new DrawCommand(toolBar.getCurrentState(),DrawingWindow));
        invoker.executeCommand();   
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
        Alert alert = new Alert(AlertType.CONFIRMATION);
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
 
        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Xml files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show open file dialog
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
        shapeText.setText("");
    }

    @FXML
    private void selectClick(MouseEvent event) {
        if(event.getTarget() instanceof Shape){
            invoker.setCommand(new SelectCommand(toolBar.getCurrentState(),(Shape)event.getTarget()));
            invoker.executeCommand();   
        }
    }
    
}
    

