package controller;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.stage.*;
import au.edu.uts.ap.javafx.*;

import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.input.KeyEvent;
import model.*;

public class CatalogueController extends Controller<Catalogue>{
    @FXML private TableView<Part> catalogueTv;
    @FXML private TableColumn<Part, String> priceClm;
    @FXML private TableColumn<Part, String> typeClm;
    @FXML private TableColumn<Part, String> nameClm;
    @FXML private Button addToBuildBtn;
    @FXML private Button removeFromCat;
    @FXML private TextField filterTypeTf;
    @FXML private TextField filterMinTf;
    @FXML private TextField filterMaxTf;
    
    
    
    public final Catalogue getCatalogue() { return model; }
    
    private ObservableList<Part> getSelectedPart() {
        return catalogueTv.getSelectionModel().getSelectedItems(); 
    }
    
    @FXML private void initialize(){
        priceClm.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asString("$%.2f"));
        typeClm.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
        nameClm.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        addToBuildBtn.disableProperty().bind(Bindings.isEmpty(catalogueTv.getSelectionModel().getSelectedItems()));
        removeFromCat.disableProperty().bind(Bindings.isEmpty(catalogueTv.getSelectionModel().getSelectedItems()));
        catalogueTv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }
    
    @FXML private void handleAdd(ActionEvent event) throws Exception {
        ViewLoader.showStage(getCatalogue(), "/view/addtocatalogue.fxml", "Add New Part to Catalogue", new Stage());
    }
    
    @FXML private void handleAddToBuild(ActionEvent event) throws Exception {
        getCatalogue().addToBuild(getSelectedPart());
    }
    
    @FXML private void handleRemoveFromCat(ActionEvent event) throws Exception {
        getCatalogue().remove(getSelectedPart());
    }
    
    @FXML private void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }
    
    @FXML private void filter(KeyEvent event) throws Exception {
        getCatalogue().filterList(filterTypeTf.getText(), filterMinTf.getText(), filterMaxTf.getText());
    }
}
