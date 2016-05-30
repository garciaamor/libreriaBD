package libreriabd;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class LibreriaBD {

    public static void main(String[] args) {
        
    }
    
    public String db = "jgarciaamor";
    public String url = "jdbc:mysql://10.0.0.254/"+db;
    public String user = "jgarciaamor";
    public String pass = "jgarciaamor";
    
    public Connection Conectar(){

       Connection link = null;

       try{

           Class.forName("org.gjt.mm.mysql.Driver");

           link = (Connection) DriverManager.getConnection(this.url, this.user, this.pass);

       }catch(Exception ex){

           JOptionPane.showMessageDialog(null, ex.getMessage());

       }


       return link;

   }
    
    
}
