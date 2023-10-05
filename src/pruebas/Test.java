
package pruebas;



import java.util.Scanner;
import negocio.CatalogoPeliculasImp;
import negocio.ICatalogoPeliculas;
/**
 *
 * @author diego
 */
public class Test {
    public static void main(String[] args) {
       var opcion =-1;
       var scanner = new Scanner(System.in);
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImp();
        
        while (opcion!= 0){
            System.out.println("elige una opcion \n"
                    + "1. iniciar catalo de peliculas \n"
                    + "2. agregar peliculs \n"
                    + "3. listar peliculas \n"
                    + "4. buscar peliculas \n"
                    + "0. salir" );
            opcion = Integer.parseInt(scanner.nextLine());
            switch(opcion){
                case 1:
                    catalogo.iniciararArchivo();
                    break;
                case 2:
                    System.out.println("ingresar nombre pelicua");
                    var nombrePelicula =scanner.nextLine();
                    catalogo.agragarPelicula(nombrePelicula);
                    break;
                case 3:
                    catalogo.listarPelicula();
                    break;
                case 4:
                    System.out.println("ingrese el nombre de la pelicula");
                    nombrePelicula = scanner.nextLine();
                    catalogo.buscarPelicula(nombrePelicula);
                case 0:
                    System.out.println("salida del programa " );
                    opcion = 0;
                    
            }
        }
    }
    
}
