package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ErrorController extends Controller<Error>{
 @FXML private void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }
}
