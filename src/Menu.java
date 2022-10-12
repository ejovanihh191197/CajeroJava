import java.util.Scanner;
/**
 *
 * @author Erick Jovani
 */
public class Menu extends Generales{
    private String nombre = "";
    private String pin;
    private Scanner lectura = new Scanner(System.in);
    private Integer intentos = 0;

    public void principal() {
        do{
            pedirDatos();
            if(validarPin(pin)){
                opciones();
            }else{
                System.out.println("Intento fallido: "+this.intentos);
            }
        }while(this.intentos >= 1 && this.intentos < 3);
        if(this.intentos == 3){
            System.out.println("Numero Maximo de intentos");
        }
    }
    
    public void pedirDatos(){
        String temp = "";
        do{
            System.out.println("\t.: Bienvenido :.");
            System.out.println("Por favor, ingrese su nombre y contraseña");
            System.out.print("Nombre: ");
            temp = lectura.nextLine();
            if(validarNombre(temp)){
                this.nombre = temp;
            }else{
                System.out.println("Por favor, ingrese un nombre valido");
            }
        }while(this.nombre.equals(""));
        System.out.print("Ingresa el PIN: ");
        this.pin = lectura.nextLine();
    }
    
    public boolean validarPin(String pin){
        boolean resultado = true;
        if (pin.equals("12345")){
            resultado = true;
        }else{
            resultado = false;
            intentos++;
        }
        return resultado;
    }
    public boolean validarNombre(String nombre){
        boolean res = false;
        if(nombre.matches("[A-Za-z ]{3,}")){
            res = true;
        }
        return res;
    }
    public boolean validarCantidad(String cantidad){
        boolean res = false;
        if(cantidad.matches("[0-9.]+")){
            res = true;
        }
        return res;
    }
    
    public void opciones(){
        String opc = null;
        Cuenta cuenta = new Cuenta();
        do{
            System.out.println("\t.: Bienvenido "+this.nombre + " :.");
            System.out.println("1.- Consultar saldo");
            System.out.println("2.- Retirar saldo");
            System.out.println("3.- Historial de movimientos");
            System.out.println("4.- Salir");
            System.out.println("Seleccionar opcion: ");
            opc = lectura.nextLine();
            switch (opc) {
                case "1":
                    cuenta.consultaSaldo();
                    regresarMenu();
                    break;
                case "2":
                    Double retiro;
                    String cantidad;
                    do{
                    System.out.println("Hola "+this.nombre+" Ingresa la cantidad a retirar");
                    cantidad = lectura.nextLine();
                    if(validarCantidad(cantidad)){
                        retiro = Double.parseDouble(cantidad);
                        cuenta.retirar(retiro);
                    }else{
                        System.out.println("Lo sentimos, ingrese una cantidad valida");
                    }
                    }while(!validarCantidad(cantidad));
                    break;
                case "3":
                    if(!cuenta.getHistoria().isEmpty()){
                        System.out.println("========== Moviemientos ==========");
                        for (int i = 0; i < cuenta.getHistoria().size(); i++) {
                            System.out.println(cuenta.getHistoria().get(i));
                        }
                        System.out.println("==================================");
                    }else{
                        System.out.println("No se cuentan con moviemientos hasta ahora");
                    }
                    regresarMenu();
                    break;
                case "4":
                    System.out.println("Hasta pronto!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Ingresar una opcion valida, gracias");
            }
        }while(!opc.equals("4"));
    }
}
