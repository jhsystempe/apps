package pe.gob.susalud.boleta.pago.report.bean;

/**
 *
 * @author jhuaman
 */
public class Aportacion {
    private String apConcepto;
    private String apMonto;

    public Aportacion() {
    }

    public Aportacion(String apConcepto, String apMonto) {
        this.apConcepto = apConcepto;
        this.apMonto = apMonto;
    }

    public String getApConcepto() {
        return apConcepto;
    }

    public void setApConcepto(String apConcepto) {
        this.apConcepto = apConcepto;
    }

    public String getApMonto() {
        return apMonto;
    }

    public void setApMonto(String apMonto) {
        this.apMonto = apMonto;
    }

}
