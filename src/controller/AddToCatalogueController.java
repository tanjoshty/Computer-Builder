package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Catalogue;

public class AddToCatalogueController extends Controller<Catalogue> {
    @FXML private TextField priceTf;
    @FXML private TextField nameTf;
    @FXML private TextField typeTf;
    
    public final Catalogue getCatalogue() { return model; }
    
    private int getPrice() { return Integer.parseInt(priceTf.getText()); }
    private String getName() { return nameTf.getText(); }
    private String getType() { return typeTf.getText(); }
    
    @FXML private void handleAddToCat(ActionEvent event) throws Exception {
        try{
            getCatalogue().addPart(getName(), getType(), getPrice());
        }
        catch(Exception e){
            ViewLoader.showStage(e, "/view/error.fxml", "Incorrect Input", new Stage());
        }
        finally{
            priceTf.setText("");
            nameTf.setText("");
            typeTf.setText("");
        }
    }
}
