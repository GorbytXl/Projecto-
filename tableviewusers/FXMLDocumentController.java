/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package tableviewusers;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Adrian Triviño
 */
public class FXMLDocumentController implements Initializable {
    

    @FXML
    private AnchorPane pane_sinup;

    @FXML
    private TextField txtUsername;
    
     private Stage stage;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnCrear;

    @FXML
    private TextField txtEmail;

    @FXML
    private AnchorPane pane_login;

    @FXML
    private Button btnIngresar;
    @FXML
    private TextField txtUsernamesinng;

    @FXML
    private PasswordField txtPasswordsing;
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst=null;
    Stage a=new Stage();
    
    private void limpiarCajas(){
        txtUsername.setText(null);
        txtPassword.setText(null);
        txtEmail.setText(null);
                
    }
    

    public void loadinpaneSho2(){
        
        pane_login.setVisible(true);
        pane_sinup.setVisible(false);
    }
    
    public void Singupshow(){
        pane_login.setVisible(false);
        pane_sinup.setVisible(true);
        
    }
    @FXML
    private void login(ActionEvent event)throws Exception{
        conn = mysqlconnect.ConnectDB();
        try{
           pst=conn.prepareStatement("SELECT*FROM users WHERE username = ? and password = ?");
           pst.setString(1,txtUsername.getText() );
           pst.setString(2,txtPassword.getText() );
           rs = pst.executeQuery();
           if(rs.next() ){
                
                Parent root =FXMLLoader.load(getClass().getResource("segundo.fxml"));
                Stage myStage = (Stage)this.btnIngresar.getScene().getWindow();
                myStage.close();
                Scene scene = new Scene(root);
                a.setScene(scene);
                a.show();
                

           }else{
               JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA INCORRECTO ");
               limpiarCajas();
           }
                
            }catch(Exception e){
                System.err.print(e);
            
        }
        
    }
    
    public void add_users(ActionEvent event){
        conn = mysqlconnect.ConnectDB();
        String sql = " insert into users( username , password , email) values (?,?,?) ";
        try{
            pst= conn.prepareStatement(sql);
            pst.setString(1, txtUsernamesinng.getText());
            pst.setString(2, txtPasswordsing.getText());
            pst.setString(3, txtEmail.getText());
            int res = pst.executeUpdate();
            if (res >0){
                JOptionPane.showMessageDialog(null,"Datos ingresados");
                limpiarCajas();
            }else{
                JOptionPane.showMessageDialog(null,"FAllo");
                limpiarCajas();
            }
            conn.close();
            
        }catch(Exception e){
            System.err.println(e);
        }
    }
    

    



    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    
    }    
    
}
