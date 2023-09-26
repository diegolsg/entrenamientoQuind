
package domain;

/**
 *
 * @author diego
 */
public class Pelicula {
    private String nombre;
    private String genero;

    public Pelicula() {
    }
    
    

    public Pelicula(String nombre,String genero) {
        this.nombre = nombre;
        this.genero=genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "nombre=" + nombre + ", genero=" + genero + '}';
    }

  
    
    
    
    
}
