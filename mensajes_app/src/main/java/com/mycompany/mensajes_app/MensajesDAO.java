/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sebastian
 * Descripcion: esta clase es la que se comunica con la base de datos
 */
public class MensajesDAO {
    
    
    /**
     * Esta funcion recibe un objeto de clase "Mensajes"
     * @param mensaje el objeto mensaje, hecho por el usuario
     */
    public static void crearMensajeDB(Mensajes mensaje){
        Conexion db_connect=new Conexion();
        try(Connection conexion=db_connect.getConexion()){//la conexion a la base de datos salio OK o no
            PreparedStatement ps=null;//objeto para el query
            try{
                /*
                es importante los "?", ahi es donde van los parametros quiero introducir en la base de datos
                */
                String Query="INSERT INTO mensajes(mensaje,autor_mensaje) VALUES (?,?)";// el query
                ps=conexion.prepareStatement(Query);//funcion que prepara el query
                ps.setString(1, mensaje.getMensaje());//el indice "1" representa al primer "?" en el query de la base de datos
                ps.setString(2,mensaje.getAutor_mensaje());
                /*
                funcion que termina con el objeto PreparedStatement "ps". este metodo tiene transaccion
                debido a que funciona para insertar,actulizar y eliminar de la base de datos.
                */
                ps.executeUpdate();
                System.out.println("mensaje creado");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }
    
    public static void leerMensajesDB(){
        Conexion db_connect=new Conexion();
        PreparedStatement ps=null;//objeto para el query
        ResultSet rs=null; //objeto que trae los datos en filas 
        
        
        try(Connection conexion=db_connect.getConexion()){//la conexion a la base de datos salio OK o no
            String query="SELECT * FROM mensajes";
            ps=conexion.prepareStatement(query);
            rs=ps.executeQuery();//este metodo es solo para leer o mostrar los datos de la base de datos.
            
            while (rs.next()) {                
                System.out.println("ID: "     +  rs.getInt("id_mensaje")); //el strin entre las comillas es el nombre de la columna en BD
                System.out.println("Mensaje: "+  rs.getString("mensaje"));
                System.out.println("Autor: "  +  rs.getString("autor_mensaje"));
                System.out.println("Fecha: "  +  rs.getString("fecha_mensaje"));
                System.out.println(" ");
                
            }
        } catch (SQLException e) {
            System.out.println("no se pudo recuperar los mensajes");
            System.out.println(e);
        } 
        
    }
    
    public static void borrarMensajeDB(int id_mensaje){
        Conexion db_connect=new Conexion();
        try(Connection conexion=db_connect.getConexion()){//la conexion a la base de datos salio OK o no
            
            PreparedStatement ps=null;//objeto para el query
            try {
                String Query="DELETE FROM mensajes WHERE id_mensaje= ?";
                ps=conexion.prepareStatement(Query);//funcion que prepara el query
                ps.setInt(1, id_mensaje);//por lo que este era un valor entero
                ps.executeUpdate();
                System.out.println("el mensaje ha sido borrado");
            } catch (SQLException exx) {
                System.out.println(exx);
            }
            
        }catch (SQLException e) {
            System.out.println("no se pudo recuperar los mensajes");
            System.out.println(e);
        } 
        
        
    }
    
    public static void atualizarMensajeBD(Mensajes mensaje){
        Conexion db_connect=new Conexion();
         
        try(Connection conexion=db_connect.getConexion()){//la conexion a la base de datos salio OK o no
            
             PreparedStatement ps=null;//objeto para el query
             try {
                 String Query="UPDATE mensajes SET mensaje=? WHERE id_mensaje=?";
                 ps=conexion.prepareStatement(Query);
                 ps.setString(1,mensaje.getMensaje());
                 ps.setInt(2,mensaje.getId_mensaje());
                 ps.executeUpdate();
                 System.out.println("el mensaje fue actualizado");
                
            } catch (SQLException ex) {
                 System.out.println(ex);
                 System.out.println("no se pudo actualizar el mensaje");
                
            }
            
        }catch (SQLException e) {
            System.out.println("no se pudo recuperar los mensajes");
            System.out.println(e);
        } 
        
    }
    
}
