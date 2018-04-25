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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

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
    private ListView<?> LVDistUn;

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
    private ListView<?> LVDistExp;

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
    private ListView<?> LVDistPoi;

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
    private ListView<?> LVDistNor;

    @FXML
    private LineChart<?, ?> LChartDistNor;
    
    @FXML
    private Label lbl;
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
}
