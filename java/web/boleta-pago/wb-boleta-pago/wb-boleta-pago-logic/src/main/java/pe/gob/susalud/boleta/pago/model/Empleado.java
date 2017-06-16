package pe.gob.susalud.boleta.pago.model;

import java.io.Serializable;

/**
 *
 * @author jllamas
 */
public class Empleado implements Serializable{

    public String coEmpleado;
    public String noEmpleado;
    public String tiDocEmpleado;
    public String nuDocEmpleado;
    public String esEmpleado;    
    public String usEmpleado;

    public Empleado() {
    }

    public String getCoEmpleado() {
        return coEmpleado;
    }

    public void setCoEmpleado(String coEmpleado) {
        this.coEmpleado = coEmpleado;
    }

    public String getNoEmpleado() {
        return noEmpleado;
    }

    public void setNoEmpleado(String noEmpleado) {
        this.noEmpleado = noEmpleado;
    }

    public String getTiDocEmpleado() {
        return tiDocEmpleado;
    }

    public void setTiDocEmpleado(String tiDocEmpleado) {
        this.tiDocEmpleado = tiDocEmpleado;
    }

    public String getNuDocEmpleado() {
        return nuDocEmpleado;
    }

    public void setNuDocEmpleado(String nuDocEmpleado) {
        this.nuDocEmpleado = nuDocEmpleado;
    }

    public String getEsEmpleado() {
        return esEmpleado;
    }

    public void setEsEmpleado(String esEmpleado) {
        this.esEmpleado = esEmpleado;
    }

    public String getUsEmpleado() {
        return usEmpleado;
    }

    public void setUsEmpleado(String usEmpleado) {
        this.usEmpleado = usEmpleado;
    }

}
