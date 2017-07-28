/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
/**
 *
 * @author willy satrya
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;    
    @FXML
    private TextField user;
    @FXML
    private PasswordField password;
    
    Stage stage = new Stage();
    
    public static String nama;
            
    ArrayList<String> myUser = new ArrayList<String>();
    ArrayList<String> myPassword = new ArrayList<String>();
        
    public void addMember(){   
        FXMLDocumentController baru = new FXMLDocumentController();
        boolean memberbaru = false;
        for(int i=0;i < myUser.size();i++){
            if(user.getText().equalsIgnoreCase(myUser.get(i))){
                label.setText("Gagal signup");
                memberbaru = true;
                break;
            }
            else if(user.getText().equalsIgnoreCase("")){
                label.setText("Gagal signup");
                memberbaru = true;
            }
        }
        if(!memberbaru) {
                label.setText("Member baru");
                myUser.add(user.getText());
                myPassword.add(password.getText());
                user.clear();
                password.clear();  
        }
    } 
    
    public void search(){
        FXMLDocumentController baru = new FXMLDocumentController();
        boolean cari = false;
        if(user.getText().equalsIgnoreCase(null) || password.getText().equalsIgnoreCase(null)){
            label.setText("Anda gagal login");
        }
        else{
            for(int i=0;i < myUser.size();i++){
            if(user.getText().equalsIgnoreCase(myUser.get(i)) && password.getText().equalsIgnoreCase(myPassword.get(i))){
                nama = user.getText();
                label.setText("Sukses Masuk");
                baru.enterlog();
                cari = true;
                break;
            }
            else{
                label.setText("Anda gagal login");  
            }
        }
        }
    }
    @FXML
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        myUser.add("Willy");
        myPassword.add("11");
        myUser.add("happy");
        myPassword.add("2");
        user.clear();
        password.clear();
        // TODO
    }    
    
       
    public void logout(ActionEvent event){
        System.exit(0);
    }
    public void enterlog(){
         try{       
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("demo.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Toko Komputer Ogah Bangkrut");
            Scene scene = new Scene(root1); 
            scene.getStylesheets().addAll(this.getClass().getResource("background.css").toExternalForm());
            stage.setScene(scene);              
            stage.show();
          }
            catch(Exception e) {
           e.printStackTrace();
          }
    }
    }
    
    

           
 

