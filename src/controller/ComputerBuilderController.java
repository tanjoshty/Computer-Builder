package controller;

import javafx.event.*;
import javafx.fxml.*;
import javafx.stage.*;
import au.edu.uts.ap.javafx.*;
import model.*;


public class ComputerBuilderController extends Controller<ComputerBuilder> {
    
    ComputerBuilder computerBuilder = new ComputerBuilder();
    
    private Catalogue getCatalogue() {
        return computerBuilder.getCatalogue(); 
    }
    
    private Build getBuild() {
        return computerBuilder.getBuild(); 
    }
    
    @FXML private void handleCatalogue(ActionEvent event) throws Exception {
        ViewLoader.showStage(getCatalogue(), "/view/catalogue.fxml", "Catalogue", new Stage());
    }
    
    @FXML private void handleBuild(ActionEvent event) throws Exception {
        ViewLoader.showStage(getBuild(), "/view/build.fxml", "Current Build", new Stage());
    }
    
    @FXML private void handleClose(ActionEvent event) throws Exception {
        System.exit(0);
    }
}