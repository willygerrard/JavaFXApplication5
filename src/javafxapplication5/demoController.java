/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
/**
 *
 * @author willy satrya
 * 
 * 
 */
public class demoController extends FXMLDocumentController implements Initializable {
          
    @FXML
    private Label label1;
    @FXML
    private ComboBox cbb;
    @FXML
    private ComboBox cbx;
    @FXML
    private ImageView img;
    @FXML
    private TextField stock;
    @FXML
    private TextField total;
    @FXML 
    private TextField jumlah;
    @FXML
    private Label harga;
    @FXML
    private Button btn3;
    @FXML
    private Label stok;
    @FXML
    private Label rupiah;
    @FXML
    private Label lain;
    
    int intel = 10;
        
    public void shop(){
        cbx.getItems().removeAll(cbx.getItems());
        cbx.getItems().addAll("Pilih Hardware","Processor", "VGA", "RAM");
        cbx.getSelectionModel().select("Pilih Hardware");     
    } 
       
    @FXML    
    private void vvv(ActionEvent event) {
        cbb.getItems().clear();
        cbb.visibleProperty().setValue(Boolean.TRUE);
        
        if(cbx.getValue().toString().equalsIgnoreCase("Processor")){
            cbb.getItems().removeAll(cbb.getItems());
            cbb.getItems().addAll("AMD Ryzen", "Intel Skylake-X");
            cbb.getSelectionModel().select("AMD Ryzen"); 
            }
        else if(cbx.getValue().toString().equalsIgnoreCase("VGA")){
            cbb.getItems().removeAll(cbb.getItems());
            cbb.getItems().addAll("Geforce GTX 1000", "Radeon RX");
            cbb.getSelectionModel().select("Geforce GTX 1000"); 
            } 
        
        else if(cbx.getValue().toString().equalsIgnoreCase("RAM")){
            cbb.getItems().removeAll(cbb.getItems());
            cbb.getItems().addAll("16 GB DIMM DDR3", "16 GB DIMM DDR4");
            cbb.getSelectionModel().select("16 GB DIMM DDR3"); 
            }        
    }
       @FXML 
    private void ChooseSpec (ActionEvent event)throws Exception{
        btn3.visibleProperty().setValue(Boolean.TRUE);
        stock.visibleProperty().setValue(Boolean.TRUE);
        harga.visibleProperty().setValue(Boolean.TRUE);
        total.visibleProperty().setValue(Boolean.TRUE);
        jumlah.visibleProperty().setValue(Boolean.TRUE);
        stok.visibleProperty().setValue(Boolean.TRUE);
        rupiah.visibleProperty().setValue(Boolean.TRUE);
        lain.visibleProperty().setValue(Boolean.TRUE);
        if(cbb.getValue().toString().equalsIgnoreCase("Intel Skylake-X")){ 
            stock.clear();
            jumlah.clear();
            total.clear();
            stock.setText(String.valueOf(intel));
            harga.setText("4500000");
            File file = new File("src/image/skylake.png");
            Image image = new Image(file.toURI().toString());
            img.setImage(image);
            }
        else if(cbb.getValue().toString().equalsIgnoreCase("AMD Ryzen")){
            stock.clear();
            total.clear();
            stock.setText("10");
            harga.setText("3500000");
            File file = new File("src/image/AMD-RYZEN-ZEN.jpg");
            Image image = new Image(file.toURI().toString());
            img.setImage(image);
            } 
        else if(cbb.getValue().toString().equalsIgnoreCase("Geforce GTX 1000")){
            stock.clear();
            jumlah.clear();
            total.clear();
            stock.setText("20");
            harga.setText("12500000");
            File file = new File("src/image/1080Ti.jpg");
            Image image = new Image(file.toURI().toString());
            img.setImage(image);
            }
        else if(cbb.getValue().toString().equalsIgnoreCase("Radeon RX")){
            stock.clear();
            jumlah.clear();
            total.clear();
            stock.setText("15");
            harga.setText("6500000");
            File file = new File("src/image/radeonrx.jpg");
            Image image = new Image(file.toURI().toString());
            img.setImage(image);
            } 
        else if(cbb.getValue().toString().equalsIgnoreCase("16 GB DIMM DDR3")){
            stock.clear();
            jumlah.clear();
            total.clear();
            stock.setText("10");
            harga.setText("1200000");
            File file = new File("src/image/ddr3.jpg");
            Image image = new Image(file.toURI().toString());
            img.setImage(image);
            }
        else if(cbb.getValue().toString().equalsIgnoreCase("16 GB DIMM DDR4")){
            stock.clear();
            jumlah.clear();
            total.clear();
            stock.setText("10");
            harga.setText("1500000");
            File file = new File("src/image/ddr4.jpg");
            Image image = new Image(file.toURI().toString());
            img.setImage(image);
            } 
    }
        
    public void buy(){
        int a = Integer.parseInt(harga.getText()),        
        b = Integer.parseInt(jumlah.getText()),
        c = a *b ,
        d = Integer.parseInt(stock.getText());
        
        if(d == 0){
            total.setText("Stok barang habis!");
        }
        else if(b>0 && b<=d){
            total.setText("Rp "+Integer.toString(c));
            stock.setText(Integer.toString(d-b)); 
        }
        else {
            total.setText("jumlah pembelian di luar stok barang");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cbb.visibleProperty().setValue(Boolean.FALSE);
        btn3.visibleProperty().setValue(Boolean.FALSE);
        stock.visibleProperty().setValue(Boolean.FALSE);
        harga.visibleProperty().setValue(Boolean.FALSE);
        total.visibleProperty().setValue(Boolean.FALSE);
        jumlah.visibleProperty().setValue(Boolean.FALSE);
        stok.visibleProperty().setValue(Boolean.FALSE);
        rupiah.visibleProperty().setValue(Boolean.FALSE);
        lain.visibleProperty().setValue(Boolean.FALSE);
        label1.setText("Welcome" + " " + FXMLDocumentController.nama);
        shop();    
        
    }  
    
}
