package mets;

import java.sql.Connection;
import libreriabd.LibreriaBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class metodos {
  
    
    libreriabd.LibreriaBD cc = new libreriabd.LibreriaBD();
    Connection con = cc.Conectar();
    
    libreriabd.LibreriaBD mysql=new libreriabd.LibreriaBD();
    java.sql.Connection cn = mysql.Conectar();
    
    JTextField t_id;
    JTextField t_tit;
    JTextField t_dir;
    JTextField t_gen;
    JTextField t_ano;
    JTable tabla;
    
    public void mostrarDatos(){
        DefaultTableModel modelo=new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Titulo");
        modelo.addColumn("Director");
        modelo.addColumn("Genero");
        modelo.addColumn("Año");
        tabla.setModel(modelo);
        
        try{
            Statement st = con.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM Peliculas");
            String [] datos = new String[5];
        while(rs.next()){
            datos[0]=rs.getString(1);
            datos[1]=rs.getString(2);
            datos[2]=rs.getString(3);
            datos[3]=rs.getString(4);
            datos[4]=rs.getString(5);
            modelo.addRow(datos);
        }
            tabla.setModel(modelo);
            
        } catch (SQLException ex){
            System.out.println("Error en la visualizacion " + ex.getMessage());
        }
        
    }
    
    
    public void actualizar(){
        try{
            PreparedStatement st = con.prepareStatement("INSERT INTO Peliculas (ID,Titulo,Director,Genero, Año)VALUES(?,?,?,?,?)");
            st.setInt(1, Integer.parseInt(t_id.getText()));
            st.setString(2, t_tit.getText());
            st.setString(3, t_dir.getText());
            st.setString(4, t_gen.getText());
            st.setString(5, t_ano.getText());
            st.executeUpdate();
            mostrarDatos();
        }catch (SQLException ex){
            System.out.println("Error al insertar"+ex.getMessage());
        }
     }
    public void eliminar(){
    int fila=tabla.getSelectedRow();
       String id="";
       id=tabla.getValueAt(fila,0).toString();
       
        try {
            PreparedStatement st=con.prepareStatement("DELETE FROM Peliculas WHERE ID='"+id+"'");
       st.executeUpdate();
       mostrarDatos();
        
        } catch (SQLException ex) {
            System.out.println("Error al borrar "+ex.getMessage());
        }
    }
    
    public void modificar(){
    
     int fila=tabla.getSelectedRow();
       if(fila>=0){
           t_id.setText(tabla.getValueAt(fila,0).toString());
           t_tit.setText(tabla.getValueAt(fila,1).toString());
           t_dir.setText(tabla.getValueAt(fila,2).toString());
           t_gen.setText(tabla.getValueAt(fila,3).toString());
           t_ano.setText(tabla.getValueAt(fila,4).toString());
       }else
           JOptionPane.showMessageDialog(null,"No selecciono ninguna fila");
    }
    
    public void insertar(){
    try{
            PreparedStatement st = con.prepareStatement("INSERT INTO Peliculas (ID,Titulo,Director,Genero, Año)VALUES(?,?,?,?,?)");
            st.setInt(1, Integer.parseInt(t_id.getText()));
            st.setString(2, t_tit.getText());
            st.setString(3, t_dir.getText());
            st.setString(4, t_gen.getText());
            st.setString(5, t_ano.getText());
            st.executeUpdate();
            mostrarDatos();
        }catch (SQLException ex){
            System.out.println("Error al insertar"+ex.getMessage());
        }
    
    }
    
}
