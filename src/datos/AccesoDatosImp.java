/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import domain.Pelicula;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.*;
import excepciones.*;
import java.io.FileWriter;



/**
 *
 * @author diego
 */
public class AccesoDatosImp implements IAccesoDatos{

    @Override
    public boolean existe(String nombreArchivo){
        var archivo =new File(nombreArchivo);
        return archivo.exists();}

    @Override
    public List<Pelicula> listar(String nombreArchivo)throws LecturaDatosEx{
        var archivo = new File(nombreArchivo);
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null) {
                var pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();     
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("excepcion al listar pelicuclas"+ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("excepcion al listar pelicuclas"+ex.getMessage());
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEX {
        var archivo = new File(nombreArchivo);
        try {
            var salida = new PrintWriter(new FileWriter(archivo,anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("se ha escrito info en el archivo " + pelicula);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new EscrituraDatosEX("excepcion al escribir pelicuclas" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw  new EscrituraDatosEX("error al escribir el mensaje ");}

    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        var archivo = new File(nombreArchivo);
        String resultado = null;
        try {
            var entrada = new BufferedReader(new FileReader(nombreArchivo));
            String linea = null;
            linea = entrada.readLine();
            var indice = 1;
            while (linea != null) {
                if (buscar != null && buscar.equalsIgnoreCase(linea)) {
                    resultado = "Pelicula " + linea + " indice " + indice;
                    break;
                }
                linea = entrada.readLine();
                indice++;

            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("excepcion al buscar pelicuclas" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("excepcion al buscar pelicuclas" + ex.getMessage());
        }
        return resultado;
    }

    @Override
    public void crear(String nombreArchivo)throws AccesoDatosEx{
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("se ha creado el archivo ");
       } catch (IOException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx("excepcion al crear pelicuclas" + ex.getMessage());
        }
    }


    @Override
    public void borrar(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        if (archivo.exists())
            archivo.delete();
        System.out.println("se ha borrado el archivo = " + archivo );
        
    }
    
}
