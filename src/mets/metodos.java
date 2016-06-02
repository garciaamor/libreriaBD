package mets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase con los metodos necesarios para conectar, desconectar, insertar, modificar y borrar registros de la base de datos
 * @author jgarciaamor
 * Tags en commits hechos
 */

public class metodos {
  
    public static void main(String[] args) {
        
    }
    
    Connection con=null;
    Statement cmd = null;
    
    /**
     * 
     * Metodo para conectar con la base de datos hay que cambiar los valores que recibe
     * @param url  nombre de la base de datos
     * @param user nombre del usuario
     * @param pass contraseña de la base de datos
     */
      
    
   public void Conectar(String url, String user, String pass){
       
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            con= (Connection) DriverManager.getConnection(url,user,pass);
        }catch(Exception ex){
            System.out.println("error "+ex.getLocalizedMessage());        
        }
        //return link;
    }
   /**
    * Metodo para insertar un nuevo registro en la tabla de la base de datos
    * @param nomTabla nombre de la tabla en la que queremos insertar el registro
    * @param nomColum nombre de la/s columna/s que tiene la tabla
    * @param valores valores que queremos añadir en las columnas de la tabla
    */
    
   
   
    
    public void insertar(String nomTabla,String nomColum, String valores){
        try {
            PreparedStatement st= con.prepareStatement("INSERT INTO "+nomTabla+" ("+nomColum+") VALUES("+valores+")");
       
       st.executeUpdate();
       
        } catch (SQLException ex) {
            System.out.println("Error al insertar "+ex.getMessage());
        }
    }
    
    /**
     * Metodo para modificar un registro la tabla
     * @param nomTabla          nombre de la tabla en la que queremos actualizar el registro
     * @param ID                ID del registro que se va a modificar
     * @param datosActualizar   nombre de la columna que se va a modificar
     * @param datosNuevos       nombre del nuevo dato del registro
     */
    
    
    public void actualizar(String nomTabla, String ID,String datosActualizar,String datosNuevos){
        try {
            PreparedStatement st= con.prepareStatement("UPDATE "+ nomTabla+" SET "+datosActualizar+"='"+datosNuevos+"' WHERE ID='"+ID+"'");
            st.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error al actualizar "+ex.getMessage() );
        }
    }
    
    /**
     * Metodo para eliminar uno de los registros
     * @param nomTabla  nombre de la tabla de la que quiero eliminar el registro
     * @param ID        ID del registro que quiero eliminar
     */
    
   
    public void borrar(String nomTabla, int ID){
         try {
            PreparedStatement st=con.prepareStatement("DELETE FROM " +nomTabla+" WHERE ID="+ID);
       st.executeUpdate();
       
        
        } catch (SQLException ex) {
            System.out.println("Error al borrar "+ex.getMessage());
        }
    }
    
    /**
     * Metodo para mostrar por pantalla todos los datos de la tabla
     * @param nomTabla      nombre de la tabla de la que quiero consultar los datos
     * @param columnas      numero de columnas que quiero que me muestre
     * @param datosMostrar  nombre de las columnas que quiero que me muestre
     */
    
    
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
    
    /**
     * Metodo para desconectar el programa de la base de datos
     */
    
   
    public void desconectar(){
        try {
            con.close();
            //cn.close();
        } catch (SQLException ex) {
            System.out.println("error "+ex.getMessage());
        }
    }
    
    
}
