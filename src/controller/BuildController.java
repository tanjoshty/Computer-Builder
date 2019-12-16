package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.text.DecimalFormat;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Build;
import model.Part;

public class BuildController extends Controller<Build>{
    @FXML private TableView<Part> buildTv;
    @FXML private TableColumn<Part, String> buildPriceClm;
    @FXML private TableColumn<Part, String> buildTypeClm;
    @FXML private TableColumn<Part, String> buildNameClm;
    @FXML private Button removeFromBuildBtn;
    @FXML private Text totalTxt;
    
    public final Build getBuild() { return model; }
    
    private ObservableList<Part> getSelectedPart() {
        return buildTv.getSelectionModel().getSelectedItems(); 
    }
    
    @FXML private void initialize(){
        buildPriceClm.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asString("$%.2f"));
        buildTypeClm.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
        buildNameClm.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        removeFromBuildBtn.disableProperty().bind(Bindings.isEmpty(buildTv.getSelectionModel().getSelectedItems()));
        buildTv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        totalTxt.setText("Total: $" + formatted(getBuild().totalPrice()));
        buildTv.getItems().addListener(new ListChangeListener<Part>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Part> arg0) {
                totalTxt.setText("Total: $" + formatted(getBuild().totalPrice()));
            }
        });
    }
    
    @FXML private void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }
    
    @FXML private void handleRemove(ActionEvent event) throws Exception {
        getBuild().remove(getSelectedPart());
    }
    
    @FXML private void handleCheckBuild(ActionEvent event) throws Exception {
        ViewLoader.showStage(getBuild(), "/view/buildcheck.fxml", "Build Validity Status", new Stage());
    }
    
    private String formatted(double money) {
        return new DecimalFormat("###,##0.00").format(money);
    }
}
