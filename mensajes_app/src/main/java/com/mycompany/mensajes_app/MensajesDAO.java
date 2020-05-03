/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        try(Connection conexion=db_connect.getConexion()){
            PreparedStatement ps=null;
            try{
                /*
                es importante los "?", ahi es donde van los parametros quiero introducir en la base de datos
                */
                String Query="INSERT INTO mensajes(mensaje,autor_mensaje) VALUES (?,?)";// el query
                ps=conexion.prepareStatement(Query);//funcion que prepara el query
                ps.setString(1, mensaje.getMensaje());//el indice "1" representa al primer "?" en el query de la base de datos
                ps.setString(2,mensaje.getAutor_mensaje());
                ps.executeUpdate();//funcion que termina con el objeto PreparedStatement "ps"
                System.out.println("mensaje creado");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }
    
    public static void leerMensajesDB(){
        
    }
    
    public static void borrarMensajeDB(int id_mensaje){
        
    }
    
    public static void atualizarMensajeBD(Mensajes mensaje){
        
    }
    
}
