package pe.gob.susalud.boleta.pago.report.bean;

/**
 *
 * @author jhuaman
 */
public class Ingreso {
    private String inConcepto;
    private String inMonto;

    public Ingreso() {
    }

    public Ingreso(String inConcepto, String inMonto) {
        this.inConcepto = inConcepto;
        this.inMonto = inMonto;
    }

    public String getInConcepto() {
        return inConcepto;
    }

    public void setInConcepto(String inConcepto) {
        this.inConcepto = inConcepto;
    }

    public String getInMonto() {
        return inMonto;
    }

    public void setInMonto(String inMonto) {
        this.inMonto = inMonto;
    }

}
