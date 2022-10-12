import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Erick Jovani
 */
public class Cuenta extends Generales{
    private Double saldo = 1000.0;
    private List<Historia> historia = new ArrayList();
    
    public void consultaSaldo(){
        System.out.println("Tu saldo es de: $"+getSaldo());
        regresarMenu();
    }
    
    public void retirar(Double retiro){
        if(this.saldo - retiro >=0){
            Historia elemento = new Historia(saldo, saldo - retiro);
            historia.add(elemento);
            setSaldo(saldo - retiro);
            System.out.println("Movimiento exitoso\nDetalles del movimiento:");
            System.out.println(elemento);
        }else{
            System.out.println("Lo sentimos, no cuenta con los fondos suficientes, Saldo actual: "+ getSaldo());
        }
        regresarMenu();
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public List<Historia> getHistoria() {
        return historia;
    }

    public void setHistoria(List<Historia> historia) {
        this.historia = historia;
    }
    
    
}
