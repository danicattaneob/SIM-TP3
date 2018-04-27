package tp3.Interfaz;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
    private Button btnDistUnLimp;

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
    private LineChart<Double, Double> LChartDistUni;
    
    @FXML
    private BarChart<Double, Double> brChDistUn;

    @FXML
    private Button btnDistExpGen;

    @FXML
    private Button btnDistExpGra;

    @FXML
    private Button btnDistExpOc;

    @FXML
    private Button btnDistExpPrueb;
    
    @FXML
    private Button btnDistExpLimp;

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
    private LineChart<Double, Double> LChartDistExp;

    @FXML
    private Button btnDistPoiGen;

    @FXML
    private Button btnDistPoiGra;

    @FXML
    private Button btnDistPoiOc;

    @FXML
    private Button btnDistPoiPrueb;
    
    @FXML
    private Button btnDistPoiLimp;

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
    private LineChart<Double, Double> LChartDistPoi;

    @FXML
    private Button btnDistNorGen;

    @FXML
    private Button btnDistNorGra;

    @FXML
    private Button btnDistNorOc;

    @FXML
    private Button btnDistNorPrueb;
    
    
    @FXML
    private Button btnDistNorLimp;

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
    private LineChart<Double, Double> LChartDistNor;
    
    private Uniforme un;
    private Exponencial exp;
    private Poisson poi;
    private Normal nor;
    private LinkedList<Double> valoresUn;
    private LinkedList<Double> valoresExp;
    private LinkedList<Double> valoresPoi;
    private LinkedList<Double> valoresNor;
    private LinkedList<Integer> frecUn;
    private LinkedList<Integer> frecExp;
    private LinkedList<Integer> frecPoi;
    private LinkedList<Integer> frecNor;
    
    
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
        this.un = new Uniforme(Integer.parseInt(txtDistUnA.getText()), 
                Integer.parseInt(txtDistUnB.getText()), flagRanCong);
        
        this.valoresUn = un.generarSerie(Integer.parseInt(txtDistUnCantVal.getText()));
        ObservableList<Double> items =FXCollections.observableArrayList (valoresUn);
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
        this.exp = new Exponencial(Integer.parseInt(txtDistExpLam.getText()),flagRanCong);
        
        this.valoresExp = exp.generarSerie(Integer.parseInt(txtDistExpCantVal.getText()));
        ObservableList<Double> items = FXCollections.observableArrayList (valoresExp);
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
        this.poi = new Poisson(Integer.parseInt(txtDistPoiLam.getText()),flagRanCong);
        
        this.valoresPoi = poi.generarSerie(Integer.parseInt(txtDistPoiCantVal.getText()));
        ObservableList<Double> items = FXCollections.observableArrayList (valoresPoi);
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
        this.nor = new Normal(Integer.parseInt(txtDIstNorSig.getText()),
                Integer.parseInt(txtDistNorMu.getText()), flagRanCong);
        
        this.valoresNor = nor.generarSerie(Integer.parseInt(txtDistNorCantVal.getText()));
        ObservableList<Double> items = FXCollections.observableArrayList (valoresNor);
        LVDistNor.setItems(items);
    }
    
    @FXML
    private void pruebaChiUn(ActionEvent event) {
        if(un != null){
            if(un.pruebaChi(Integer.parseInt(txtDistUnCantInt.getText()), valoresUn,
                    Integer.parseInt(txtDistUnCantVal.getText()))){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Prueba Chi");
                alert.setHeaderText("La serie paso la prueba de Chi Cuadrado");
                alert.setContentText("I have a great message for you!");

                alert.showAndWait();
                
            }else{
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Prueba Chi");
                alert.setHeaderText("La serie no paso la pruba de Chi Cuadrado");
                alert.setContentText("Ooops, there was an error!");

                alert.showAndWait();
            }
        }else{
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText("Debe generar una serie primero");
            alert.setContentText("Careful with the next step!");

            alert.showAndWait();
        }
    }
    
    @FXML
    private void pruebaChiExp(ActionEvent event) {
        if(exp != null){
            if(exp.pruebaChi(Integer.parseInt(txtDistExpCantInt.getText()), valoresExp,
                    Integer.parseInt(txtDistExpCantVal.getText()))){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Prueba Chi");
                alert.setHeaderText("La serie paso la prueba de Chi Cuadrado");
                alert.setContentText("I have a great message for you!");

                alert.showAndWait();
                
            }else{
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Prueba Chi");
                alert.setHeaderText("La serie no paso la pruba de Chi Cuadrado");
                alert.setContentText("Ooops, there was an error!");

                alert.showAndWait();
            }
        }else{
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText("Debe generar una serie primero");
            alert.setContentText("Careful with the next step!");

            alert.showAndWait();
        }
    }
    
    @FXML
    private void pruebaChiPoi(ActionEvent event) {
        if(poi != null){
            if(poi.pruebaChi(Integer.parseInt(txtDistPoiCantInt.getText()), valoresPoi,
                    Integer.parseInt(txtDistPoiCantVal.getText()))){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Prueba Chi");
                alert.setHeaderText("La serie paso la prueba de Chi Cuadrado");
                alert.setContentText("I have a great message for you!");

                alert.showAndWait();
                
            }else{
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Prueba Chi");
                alert.setHeaderText("La serie no paso la pruba de Chi Cuadrado");
                alert.setContentText("Ooops, there was an error!");

                alert.showAndWait();
            }
        }else{
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText("Debe generar una serie primero");
            alert.setContentText("Careful with the next step!");

            alert.showAndWait();
        }
    }
    
    @FXML
    private void pruebaChiNor(ActionEvent event) {
        if(nor != null){
            if(nor.pruebaChi(Integer.parseInt(txtDistNorCantInt.getText()), valoresNor,
                    Integer.parseInt(txtDistNorCantVal.getText()))){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Prueba Chi");
                alert.setHeaderText("La serie paso la prueba de Chi Cuadrado");
                alert.setContentText("I have a great message for you!");

                alert.showAndWait();
                
            }else{
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Prueba Chi");
                alert.setHeaderText("La serie no paso la pruba de Chi Cuadrado");
                alert.setContentText("Ooops, there was an error!");

                alert.showAndWait();
            }
        }else{
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText("Debe generar una serie primero");
            alert.setContentText("Careful with the next step!");

            alert.showAndWait();
        }
    }
    
    @FXML
    private void limpiarSerieUn(ActionEvent event) {
        txtDistUnA.setText("");
        txtDistUnB.setText("");
        txtDistUnCantInt.setText("");
        txtDistUnCantVal.setText("");
        valoresUn.clear();
        LVDistUn.setItems(null);
        un = null;
    }
    
    @FXML
    private void limpiarSerieExp(ActionEvent event) {
        txtDistExpLam.setText("");
        txtDistExpCantInt.setText("");
        txtDistExpCantVal.setText("");
        valoresExp.clear();
        LVDistExp.setItems(null);
        exp = null;
    }
    
    @FXML
    private void limpiarSeriePoi(ActionEvent event) {
        txtDistPoiLam.setText("");
        txtDistPoiCantInt.setText("");
        txtDistPoiCantVal.setText("");
        valoresPoi.clear();
        LVDistPoi.setItems(null);
        poi = null;
    }
    
    @FXML
    private void limpiarSerieNor(ActionEvent event) {
        txtDIstNorSig.setText("");
        txtDistNorMu.setText("");
        txtDistNorCantInt.setText("");
        txtDistNorCantVal.setText("");
        valoresNor.clear();
        LVDistNor.setItems(null);
        nor = null;
    }
    
    @FXML
    private void graficarSerieUn(ActionEvent event) {
        frecUn = un.frecObtenida(Integer.parseInt(txtDistUnCantInt.getText()), valoresUn);
        for (int i = 0; i < frecUn.size(); i++) {
            ;
            
        }
    }
    
    @FXML
    private void graficarSerieExp(ActionEvent event) {
    }
    
    @FXML
    private void graficarSeriePoi(ActionEvent event) {
    }
    
    @FXML
    private void graficarSerieNor(ActionEvent event) {
    }
}
