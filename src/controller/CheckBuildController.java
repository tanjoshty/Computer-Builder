package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import model.Build;

public class CheckBuildController extends Controller<Build> {
    @FXML private Text valid;

    
    public final Build getBuild() { return model; }
    
    @FXML private void initialize() {
        if (getBuild().isValid()){
            valid.setText("This build is functional.");
        }
        if (!(getBuild().hasPartOfType("cpu"))) {
            valid.setText("This build is missing a CPU.\n");
        }
        if (!(getBuild().hasPartOfType("motherboard"))) {
            valid.setText(valid.getText()+"This build is missing a motherboard.\n");
        }
        if (!(getBuild().hasPartOfType("memory"))) {
            valid.setText(valid.getText()+"This build is missing RAM.\n");
        }
        if (!(getBuild().hasPartOfType("case"))) {
            valid.setText(valid.getText()+"This build is missing a case.\n");
        }
        if (!(getBuild().hasPartOfType("storage"))) {
            valid.setText(valid.getText()+"This build is missing storage.\n");
        }
        
        
    }
    
    @FXML private void handleOkay(ActionEvent Event){
        stage.close();
    }
        
}
