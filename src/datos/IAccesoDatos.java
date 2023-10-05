
package datos;
import excepciones.*;
import domain.Pelicula;
import java.util.List;

/**
 *
 * @author diego
 */
public interface IAccesoDatos {
    
    public boolean existe(String nombreArchivo) throws AccesoDatosEx;
    
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx;
    
    public void escribir(Pelicula pelicula,String nombreArchivo,boolean anexar)throws EscrituraDatosEX;
    
    public String buscar(String nombreArchivo, String buscar)throws LecturaDatosEx;
    
    public void  crear(String nombreArchivo)throws AccesoDatosEx;
    
    public void borrar(String nombreArchivo)throws AccesoDatosEx;
    
}
