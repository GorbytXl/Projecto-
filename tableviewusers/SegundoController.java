/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tableviewusers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Adrian Triviño
 */
public class SegundoController implements Initializable {
    
    @FXML
    private AnchorPane panePrincipal;

    @FXML
    private AnchorPane paneInicio;

    @FXML
    private Button btnMarvel;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnDc;

    @FXML
    private AnchorPane paneDc;

    @FXML
    private AnchorPane paneBus;

    @FXML
    private TextField txtNombreHeroe;

    @FXML
    private ComboBox editores;

    @FXML
    private Button btnBus;

    @FXML
    private TextField txtnom;

    @FXML
    private TextField txtedi;

    @FXML
    private TextField txtaleg;

    @FXML
    private TextField txtPri;
    




    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst=null;
    Stage a=new Stage();
    
    
    public void Dc(){
        paneInicio.setVisible(false);
        paneBus.setVisible(false);
        paneDc.setVisible(true);
    }
    
    public void bBuscar(){
        paneInicio.setVisible(false);
        paneDc.setVisible(false);
        paneBus.setVisible(true);
    }
    
    
        @FXML
    private void buscar(ActionEvent event)throws Exception{
        conn = mysqlconnect.ConnectDB();
        try{
           pst=conn.prepareStatement("SELECT*FROM heroes WHERE editor = ? and nom_sup = ? ");
           pst.setString(1,editores.getValue().toString());
           pst.setString(2, txtNombreHeroe.getText() );
           rs = pst.executeQuery();
           if(rs.next()){
               pst=conn.prepareStatement("SELECT  nom_sup  WHERE heroes = ");
               txtedi.setText(rs.getString(1));
               txtnom.setText(rs.getString(2));
               txtaleg.setText(rs.getString(3));
               txtPri.setText(rs.getString(4));

                

           }else{
               JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA INCORRECTO ");

           }
                
            }catch(Exception e){
                System.err.print(e);
            
        }
        
    }
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        editores.getItems().addAll("Dc","Marvel");
        // TODO
    }    
    
}
