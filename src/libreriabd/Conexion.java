package libreriabd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion {

    public static void main(String[] args) {
        
    }
    
    public String db = "jgarciaamor";
    public String url = "jdbc:mysql://10.0.0.254/"+db;
    public String user = "jgarciaamor";
    public String pass = "jgarciaamor";
    
    
       Connection link = null;
       Statement cmd = null;
    
    
    public Connection Conectar(){


       try{

           Class.forName("org.gjt.mm.mysql.Driver");

           link = (Connection) DriverManager.getConnection(this.url, this.user, this.pass);

       }catch(Exception ex){

           System.out.println("error" + ex.getLocalizedMessage());

       }


       return link;

   }
    
    
}