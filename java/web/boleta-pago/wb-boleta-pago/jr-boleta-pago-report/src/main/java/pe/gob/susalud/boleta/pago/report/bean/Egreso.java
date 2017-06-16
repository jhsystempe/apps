package pe.gob.susalud.boleta.pago.report.bean;

/**
 *
 * @author jhuaman
 */
public class Egreso {
    private String egConcepto;
    private String egMonto;

    public Egreso() {
    }

    public Egreso(String egConcepto, String egMonto) {
        this.egConcepto = egConcepto;
        this.egMonto = egMonto;
    }

    public String getEgConcepto() {
        return egConcepto;
    }

    public void setEgConcepto(String egConcepto) {
        this.egConcepto = egConcepto;
    }

    public String getEgMonto() {
        return egMonto;
    }

    public void setEgMonto(String egMonto) {
        this.egMonto = egMonto;
    }

}
