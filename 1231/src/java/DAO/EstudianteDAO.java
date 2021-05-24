/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import TO.EstudianteTO;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class EstudianteDAO {
    
 public String insertEstudiante(
 String identificacion ,
 String nombre,
 String apellido,
 int edad,
 String correo
 
 ) throws SQLException, ClassNotFoundException{
     
     String rta ="";
     Conexion conexion = new Conexion();
      Connection conn = conexion.obtener();
     
     try {
        String sql = "INSERT INTO ESTUDIANTES(IDENTIFICACION,NOMBRES,APELLIDO,EDAD,CORREO)VALUES(?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, identificacion);
         ps.setString(2, nombre);
        ps.setString(3, apellido);
        ps.setInt(4, edad);
        ps.setString(5, correo);
        ps.executeQuery();
       rta = "Insertado correctamente";
     } catch (Exception e) {
         
         e.printStackTrace();
     }finally{
         try {
             if(conn != null){
                 conexion.cerrar();
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
     
     return rta;
 }
 
 
  public ArrayList<EstudianteTO> consultarEstudiantes() throws SQLException, ClassNotFoundException{
      ArrayList<EstudianteTO> lista = null;
      
      Conexion conexcion = new Conexion();
      Connection conn = conexcion.obtener();
      
      try {
         String sql =" SELECT * FROM estudiantes";
         Statement st = conn.createStatement();
         ResultSet rs =  st.executeQuery(sql);
         
         while(rs.next()){
             if(lista == null){
                 lista = new ArrayList<>();
             }
             
             EstudianteTO aux = new EstudianteTO();
             
             aux.setIdentificacion(rs.getString("identificacion"));
             aux.setNombre(rs.getString("nombre"));
             aux.setApellido(rs.getString("apellido"));
             aux.setEdad(rs.getInt("edad"));
             aux.setCorreo(rs.getString("correo"));
             
             lista.add(aux);
         }
        
      } catch (Exception e) {
          e.printStackTrace();
      }finally{
          try {
              if(conn != null){
                 conexcion.cerrar();
              }
          } catch (Exception e) {
          }
      }
      
      return lista;
  }
}
