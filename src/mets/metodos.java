package mets;

import java.sql.Connection;
import libreriabd.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class metodos {
  
    Conexion mysql=new Conexion();
    java.sql.Connection cn = mysql.Conectar();
    
    //Conexion cc = new Conexion();
    Connection con = mysql.Conectar();
    
    
    
    public void insertar(String nomTabla, String datos, String valores){
        try {
            PreparedStatement st= con.prepareStatement("INSERT INTO "+nomTabla+" ("+datos+") VALUES("+valores+")");
       
       st.executeUpdate();
       
        } catch (SQLException ex) {
            System.out.println("Error al insertar "+ex.getMessage());
        }
    }
    
    public void actualizar(String nomTabla, String ID,String datosActualizar,String datosNuevos){
        try {
            PreparedStatement st= con.prepareStatement("UPDATE "+ nomTabla+" SET "+datosActualizar+"='"+datosNuevos+"' WHERE ID='"+ID+"'");
            st.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error al actualizar "+ex.getMessage() );
        }
    }
    public void borrar(String nomTabla, int ID){
         try {
            PreparedStatement st=con.prepareStatement("DELETE FROM " +nomTabla+" WHERE ID="+ID);
       st.executeUpdate();
       
        
        } catch (SQLException ex) {
            System.out.println("Error al borrar "+ex.getMessage());
        }
    }
    
    public void consultaDatos(String nomTabla,int columnas, String datosMostrar){
       String ac="";
        try {
            Statement st= con.createStatement();
               ResultSet rs= st.executeQuery("SELECT "+datosMostrar+" FROM "+nomTabla);
              String [] datos= new String[columnas];
        while(rs.next()){
          
            for (int i = 0; i < datos.length; i++) {
                datos[i]=rs.getString(i+1);
                 ac= ac +" "+datos[i];
                
            }
            System.out.println(ac);
              }
                   
        } catch (SQLException ex) {
            System.out.println("Error en la visualizacion "+ex.getMessage());
        }
    }
    
    
    
    
    
    
}
