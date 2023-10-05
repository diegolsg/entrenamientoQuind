
package negocio;

import datos.*;
import domain.Pelicula;
import excepciones.AccesoDatosEx;
import excepciones.LecturaDatosEx;


public class CatalogoPeliculasImp implements ICatalogoPeliculas {

    private final IAccesoDatos datos;

    public CatalogoPeliculasImp() {
        this.datos = new AccesoDatosImp();
    }

    @Override
    public void agragarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_ARCHIVO);
            datos.escribir(pelicula, NOMBRE_ARCHIVO, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("error de acceso a datos");
            ex.printStackTrace(System.out);
        }

    }

    @Override
    public void listarPelicula() {
        try {
            var peliculas = this.datos.listar(NOMBRE_ARCHIVO);
            for (var pelicula : peliculas) {
                System.out.println("peliculas = " + pelicula);
            }
        } catch (LecturaDatosEx ex) {
            System.out.println("error de acceso a datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String buscar) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_ARCHIVO, buscar);
        } catch (LecturaDatosEx ex) {
            System.out.println("error de acceso a datos");
            ex.printStackTrace(System.out);
        }
        System.out.println("resultado = " + resultado);
    }

    @Override
    public void iniciararArchivo() {
        try {
            if (this.datos.existe(NOMBRE_ARCHIVO)) {
                datos.borrar(NOMBRE_ARCHIVO);
                datos.crear(NOMBRE_ARCHIVO);
            } else {
                datos.crear(NOMBRE_ARCHIVO);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("error al crear catalogo ");
            ex.printStackTrace(System.out);
        }
    }
    
    
}
