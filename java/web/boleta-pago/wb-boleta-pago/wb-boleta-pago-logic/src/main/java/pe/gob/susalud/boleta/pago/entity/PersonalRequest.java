package pe.gob.susalud.boleta.pago.entity;

/**
 *
 * @author jllamas
 */
public class PersonalRequest {

    private String dePeticion;
    private String nuDni;    
    private String idAnio;
    private String idMes;    
    private String idFlag; 
    private String idDescargado;
    private String idGenerado;

    public String getDePeticion() {
        return dePeticion;
    }

    public void setDePeticion(String dePeticion) {
        this.dePeticion = dePeticion;
    }

    public String getNuDni() {
        return nuDni;
    }

    public void setNuDni(String nuDni) {
        this.nuDni = nuDni;
    }

    public String getIdAnio() {
        return idAnio;
    }

    public void setIdAnio(String idAnio) {
        this.idAnio = idAnio;
    }

    public String getIdMes() {
        return idMes;
    }

    public void setIdMes(String idMes) {
        this.idMes = idMes;
    }

    public String getIdFlag() {
        return idFlag;
    }

    public void setIdFlag(String idFlag) {
        this.idFlag = idFlag;
    }

    public String getIdDescargado() {
        return idDescargado;
    }

    public void setIdDescargado(String idDescargado) {
        this.idDescargado = idDescargado;
    }

    public String getIdGenerado() {
        return idGenerado;
    }

    public void setIdGenerado(String idGenerado) {
        this.idGenerado = idGenerado;
    }
    
}
