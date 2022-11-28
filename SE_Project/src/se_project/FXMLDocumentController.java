/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package se_project;

import Tool.EllipseTool;
import Tool.LineTool;
import Tool.RectangleTool;
import Tool.ToolBar;
import command.DrawCommand;
import command.Invoker;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


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
    @FXML
    private Button saveBtn;
    @FXML
    private Button loadBtn;
    @FXML
    private TextField shapeText;
    
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
        DrawingWindow.getChildren().clear();
    }

    @FXML
    private void save(ActionEvent event) {
        
    }

    @FXML
    private void load(ActionEvent event) {
    }
}
