
import java.util.Scanner;

/**
 *
 * @author Erick Jovani
 */
public class Generales {
    private Scanner scan = new Scanner(System.in);
    String opcion = null;
    boolean salir = true;
    public void regresarMenu(){
        do {            
            System.out.println("¿Que desea hacer?");
            System.out.println("1.- Regresar a menu principal");
            System.out.println("2.- Salir");
            opcion = scan.nextLine();
            switch (opcion) {
                case "1":
                    salir = false;
                    break;
                case "2":
                    salir = false;
                    System.out.println("Hasta pronto!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Ingrese una opcion valida por favor");
            }
        } while (salir);
    }
}
