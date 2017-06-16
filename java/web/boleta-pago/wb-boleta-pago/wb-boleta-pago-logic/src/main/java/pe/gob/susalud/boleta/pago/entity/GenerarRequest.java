package pe.gob.susalud.boleta.pago.entity;

/**
 *
 * @author jllamas
 */
public class GenerarRequest {
 
    private String dePeticion;
    private String tiPlan;
    private String suTiPlan;
    private String nuAnio;
    private String nuMes;
    private String coEmpleado; 
    private String idFlag;
    private String dePath;

    public GenerarRequest() {
    }

    public String getDePeticion() {
        return dePeticion;
    }

    public void setDePeticion(String dePeticion) {
        this.dePeticion = dePeticion;
    }

    public String getTiPlan() {
        return tiPlan;
    }

    public void setTiPlan(String tiPlan) {
        this.tiPlan = tiPlan;
    }

    public String getSuTiPlan() {
        return suTiPlan;
    }

    public void setSuTiPlan(String suTiPlan) {
        this.suTiPlan = suTiPlan;
    }

    public String getNuAnio() {
        return nuAnio;
    }

    public void setNuAnio(String nuAnio) {
        this.nuAnio = nuAnio;
    }

    public String getNuMes() {
        return nuMes;
    }

    public void setNuMes(String nuMes) {
        this.nuMes = nuMes;
    }

    public String getCoEmpleado() {
        return coEmpleado;
    }

    public void setCoEmpleado(String coEmpleado) {
        this.coEmpleado = coEmpleado;
    }

    public String getIdFlag() {
        return idFlag;
    }

    public void setIdFlag(String idFlag) {
        this.idFlag = idFlag;
    }

    public String getDePath() {
        return dePath;
    }

    public void setDePath(String dePath) {
        this.dePath = dePath;
    }

}
