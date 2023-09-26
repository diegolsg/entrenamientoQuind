/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

/**
 *
 * @author diego
 */
public interface ICatalogoPeliculas {
    public void agragarPelicula(String nombre,String nombreArchivo);
    public void listarPelicula(String nombreArchivo);
    public void buscarPelicula(String nombreArchivo,String buscar);
    public void iniciararArchivo(String nombreArchivo);
}
