package pe.gob.susalud.boleta.pago.model;

import java.io.Serializable;

/**
 *
 * @author jhuaman
 */
public class ActualizaBoleta implements Serializable{
    private String pRegistro1;
    private String pRegistro2;
    private String pRuta;
    private String pIndicador;
    private String pRetorno;

    public ActualizaBoleta() {
    }

    public String getpRegistro1() {
        return pRegistro1;
    }

    public void setpRegistro1(String pRegistro1) {
        this.pRegistro1 = pRegistro1;
    }

    public String getpRegistro2() {
        return pRegistro2;
    }

    public void setpRegistro2(String pRegistro2) {
        this.pRegistro2 = pRegistro2;
    }

    public String getpRuta() {
        return pRuta;
    }

    public void setpRuta(String pRuta) {
        this.pRuta = pRuta;
    }

    public String getpIndicador() {
        return pIndicador;
    }

    public void setpIndicador(String pIndicador) {
        this.pIndicador = pIndicador;
    }

    public String getpRetorno() {
        return pRetorno;
    }

    public void setpRetorno(String pRetorno) {
        this.pRetorno = pRetorno;
    }
}
