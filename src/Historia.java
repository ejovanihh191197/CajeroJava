import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
/**
 *
 * @author Erick Jovani
 */
public class Historia {
    String fecha = null;
    Double saldoAnt = null;
    Double saldoAct = null;

    public Historia(Double saldoAnt, Double saldoAct) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String fechaActual = dtf.format(LocalDateTime.now());
        setFecha(fechaActual);
        setSaldoAct(saldoAct);
        setSaldoAnt(saldoAnt);
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getSaldoAnt() {
        return saldoAnt;
    }

    public void setSaldoAnt(Double saldoAnt) {
        this.saldoAnt = saldoAnt;
    }

    public Double getSaldoAct() {
        return saldoAct;
    }

    public void setSaldoAct(Double saldoAct) {
        this.saldoAct = saldoAct;
    }

    public String toString() {
        return "fecha= " + fecha + ", saldo Anterior= " + saldoAnt + ", saldo Actual= " + saldoAct;
    }
    
    
}
