/*
/*
/*
/*
/*
/*
/*
/*
/*
/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.Interfaz;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import tp3.modelo.Exponencial;
import tp3.modelo.Uniforme;

/**
 *
 * @author Dani
 */
public class VistaGeneradorController implements Initializable {
    
    @FXML
    private Button btnDistUnGen;

    @FXML
    private Button btnDistUnGra;

    @FXML
    private Button btnDistUniOc;

    @FXML
    private TextField txtDistUnA;

    @FXML
    private TextField txtDistUnB;

    @FXML
    private ListView<Double> LVDistUn;

    @FXML
    private LineChart<?, ?> LChartDistUni;

    @FXML
    private Button btnDistExpGen;

    @FXML
    private Button btnDistExpGra;

    @FXML
    private Button btnDistExpOc;

    @FXML
    private TextField txtDistExpLam;

    @FXML
    private TextField txtDistExpMu;

    @FXML
    private ListView<Integer> LVDistExp;

    @FXML
    private LineChart<?, ?> LChartDistExp;

    @FXML
    private Button btnDistPoiGen;

    @FXML
    private Button btnDistPoiGra;

    @FXML
    private Button btnDistPoiOc;

    @FXML
    private TextField txtDistPoiLam;

    @FXML
    private ListView<Integer> LVDistPoi;

    @FXML
    private LineChart<?, ?> LChartDistPoi;

    @FXML
    private Button btnDistNorGen;

    @FXML
    private Button btnDistNorGra;

    @FXML
    private Button btnDistNorOc;

    @FXML
    private TextField txtDistNorMu;

    @FXML
    private TextField DistNorDesv;

    @FXML
    private ListView<Integer> LVDistNor;

    @FXML
    private LineChart<?, ?> LChartDistNor;
    
    @FXML
    private Label lbl;
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    @FXML
    private void generarSerieDistUn(ActionEvent event) {
        
        //////////////////////////////////// UNIFORME
        Uniforme u = new Uniforme();
        //para el generador RND
        u.setA(13);//cte multiplicativa
        u.setC(7); //cte aditiva
        u.setM(8);//modulo
        //para la distribucion
        u.setA2(95); //limite inferior intervalo
        u.setB(100);//limite superior intervalo
        System.out.println(u.generarSerie(6, 10)); //le paso la semilla y la cantidad de valores que quiero
        //////////////////////////////////// EXPONENCIAL
        Exponencial ex=new Exponencial();
        ex.setA(13);//cte multiplicativa
        ex.setC(3); //cte aditiva
        ex.setM(8);//modulo
        ex.setMe(5);
        ObservableList<Double> items =FXCollections.observableArrayList(ex.generarSerie(6, 10));
        LVDistUn.setItems(items);
        System.out.println(ex.generarSerie(6, 10));
    }
    
    
    @FXML
    private void generarSerieDistExp(ActionEvent event) {
        //ToDo 
    }
    
    
    @FXML
    private void generarSeriePoi(ActionEvent event) {
        //ToDo
    }
    
    
    @FXML
    private void generarSerieDistNor(ActionEvent event) {
        //ToDo
    }
    
    
}
