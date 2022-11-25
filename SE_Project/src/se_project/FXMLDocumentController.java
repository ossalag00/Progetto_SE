/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package se_project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 *
 * @author guari
 */
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
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void setRectangle(ActionEvent event) {
    }

    @FXML
    private void setEllipse(ActionEvent event) {
    }

    @FXML
    private void setLine(ActionEvent event) {
    }

    @FXML
    private void pickColorOut(ActionEvent event) {
    }

    @FXML
    private void pickColorIn(ActionEvent event) {
    }

    @FXML
    private void clear(ActionEvent event) {
    }

    @FXML
    private void draw(MouseEvent event) {
    }

    @FXML
    private void initDraw(MouseEvent event) {
    }
    
}
