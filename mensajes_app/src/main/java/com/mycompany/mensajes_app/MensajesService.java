/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajes_app;

import java.util.Scanner;

/**
 *
 * @author sebastian
 * Descripcion: esta clase es la capa intermediaria entre la capa "DAO" y
 * la aplicacion del usuario.
 */
public class MensajesService {
    
    public static void crearMensaje(){
        Scanner sc=new Scanner(System.in);
        System.out.println("escribe el mensaje:");
        String mensaje=sc.nextLine();
        
        System.out.println("cual es tu nombre:");
        String nombre=sc.nextLine();
        
        Mensajes registro=new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        MensajesDAO.crearMensajeDB(registro);
        
    }
    
    public static void listarMensajes(){
        MensajesDAO.leerMensajesDB();
        
    }
    
    public static void editarMensaje(){
        Scanner sc=new Scanner(System.in);
        System.out.println("escribe tu nuevo mensaje:");
        String mensaje=sc.nextLine();
        
        System.out.println("indica el ID del mensaje a modificar:");
        int id_mensaje=sc.nextInt();
        
        Mensajes actualizacion=new Mensajes();
        actualizacion.setMensaje(mensaje);
        actualizacion.setId_mensaje(id_mensaje);
        
        MensajesDAO.atualizarMensajeBD(actualizacion);
        
    }
    
    public static void borrarMensaje(){
       Scanner sc=new Scanner(System.in);
        System.out.println("indica el ID del mensaje que quiere borrar: ");
        int id_mensaje=sc.nextInt();
        MensajesDAO.borrarMensajeDB(id_mensaje);
        
    }
    
    
}
