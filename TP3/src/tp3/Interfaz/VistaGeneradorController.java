package tp3.Interfaz;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import tp3.modelo.distribuciones.*;

public class VistaGeneradorController {

    @FXML
    private Button btnDistUnGen;

    @FXML
    private Button btnDistUnGra;

    @FXML
    private Button btnDistUniOc;

    @FXML
    private Button btnDistUnPrueb;

    @FXML
    private ListView<Double> LVDistUn;

    @FXML
    private TextField txtDistUnA;

    @FXML
    private TextField txtDistUnB;

    @FXML
    private RadioButton rdbDistUnJava;

    @FXML
    private ToggleGroup grpDistUnRand;

    @FXML
    private RadioButton rdbDistUnCong;

    @FXML
    private TextField txtDistUnCantVal;

    @FXML
    private TextField txtDistUnCantInt;

    @FXML
    private LineChart<?, ?> LChartDistUni;

    @FXML
    private Button btnDistExpGen;

    @FXML
    private Button btnDistExpGra;

    @FXML
    private Button btnDistExpOc;

    @FXML
    private Button btnDistExpPrueb;

    @FXML
    private ListView<Double> LVDistExp;

    @FXML
    private TextField txtDistExpLam;

    @FXML
    private RadioButton rdbDistExpJava;

    @FXML
    private ToggleGroup grpDistExpRand;

    @FXML
    private RadioButton rdbDistExpCong;

    @FXML
    private TextField txtDistExpCantVal;

    @FXML
    private TextField txtDistExpCantInt;

    @FXML
    private LineChart<?, ?> LChartDistExp;

    @FXML
    private Button btnDistPoiGen;

    @FXML
    private Button btnDistPoiGra;

    @FXML
    private Button btnDistPoiOc;

    @FXML
    private Button btnDistPoiPrueb;

    @FXML
    private ListView<Double> LVDistPoi;

    @FXML
    private TextField txtDistPoiLam;

    @FXML
    private RadioButton rdbDistPoiJava;

    @FXML
    private ToggleGroup grpDistPoiRand;

    @FXML
    private RadioButton rdbDistPoiCong;

    @FXML
    private TextField txtDistPoiCantVal;

    @FXML
    private TextField txtDistPoiCantInt;

    @FXML
    private LineChart<?, ?> LChartDistPoi;

    @FXML
    private Button btnDistNorGen;

    @FXML
    private Button btnDistNorGra;

    @FXML
    private Button btnDistNorOc;

    @FXML
    private Button btnDistNorPrueb;

    @FXML
    private ListView<Double> LVDistNor;

    @FXML
    private TextField txtDistNorMu;

    @FXML
    private TextField txtDIstNorSig;

    @FXML
    private RadioButton rdbDistNorJava;

    @FXML
    private ToggleGroup grpDistNorRand;

    @FXML
    private RadioButton rdbDistNorCong;

    @FXML
    private TextField txtDistNorCantVal;

    @FXML
    private TextField txtDistNorCantInt;

    @FXML
    private LineChart<?, ?> LChartDistNor;

    
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    @FXML
    private void generarSerieDistUn(ActionEvent event) {
        boolean flagRanCong;
        if(rdbDistUnCong.isSelected()){
            flagRanCong = true;
        }else{
            flagRanCong = false;
        }
        Uniforme un = new Uniforme(Integer.parseInt(txtDistUnA.getText()), 
                Integer.parseInt(txtDistUnB.getText()), flagRanCong);
        
        LinkedList<Double> valores = un.generarSerie(Integer.parseInt(txtDistUnCantVal.getText()));
        ObservableList<Double> items =FXCollections.observableArrayList (valores);
        LVDistUn.setItems(items);
    }
    
    
    @FXML
    private void generarSerieDistExp(ActionEvent event) {
        boolean flagRanCong;
        if(rdbDistExpCong.isSelected()){
            flagRanCong = true;
        }else{
            flagRanCong = false;
        }
        Exponencial exp = new Exponencial(Integer.parseInt(txtDistExpLam.getText()),flagRanCong);
        
        LinkedList<Double> valores = exp.generarSerie(Integer.parseInt(txtDistExpCantVal.getText()));
        ObservableList<Double> items = FXCollections.observableArrayList (valores);
        LVDistExp.setItems(items);
    }
    
    
    @FXML
    private void generarSeriePoi(ActionEvent event) {
        boolean flagRanCong;
        if(rdbDistPoiCong.isSelected()){
            flagRanCong = true;
        }else{
            flagRanCong = false;
        }
        Poisson poi = new Poisson(Integer.parseInt(txtDistPoiLam.getText()),flagRanCong);
        
        LinkedList<Double> valores = poi.generarSerie(Integer.parseInt(txtDistPoiCantVal.getText()));
        ObservableList<Double> items = FXCollections.observableArrayList (valores);
        LVDistPoi.setItems(items);
    }
    
    
    @FXML
    private void generarSerieDistNor(ActionEvent event) {
        boolean flagRanCong;
        if(rdbDistNorCong.isSelected()){
            flagRanCong = true;
        }else{
            flagRanCong = false;
        }
//        Normal nor = new Normal(Integer.parseInt(txtDistNorLam.getText()),flagRanCong);
//        
//        LinkedList<Double> valores = poi.generarSerie(Integer.parseInt(txtDistPoiCantVal.getText()));
//        ObservableList<Double> items = FXCollections.observableArrayList (valores);
//        LVDistPoi.setItems(items);
    }
    
    
}
