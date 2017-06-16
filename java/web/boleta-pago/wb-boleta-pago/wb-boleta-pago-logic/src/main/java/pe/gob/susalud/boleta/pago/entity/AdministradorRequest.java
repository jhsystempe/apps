package pe.gob.susalud.boleta.pago.entity;

/**
 *
 * @author Jose Luis Huaman Villar
 * @version 1.0.0
 */
public class AdministradorRequest {
    
    private String pPerAnio;
    private String pPerMes;
    private String pFlagAnulado;
    private String pFlagDescargado;
    private String pFlagGenerado;

    public AdministradorRequest() {
    }

    public String getpPerAnio() {
        return pPerAnio;
    }

    public void setpPerAnio(String pPerAnio) {
        this.pPerAnio = pPerAnio;
    }

    public String getpPerMes() {
        return pPerMes;
    }

    public void setpPerMes(String pPerMes) {
        this.pPerMes = pPerMes;
    }

    public String getpFlagAnulado() {
        return pFlagAnulado;
    }

    public void setpFlagAnulado(String pFlagAnulado) {
        this.pFlagAnulado = pFlagAnulado;
    }

    public String getpFlagDescargado() {
        return pFlagDescargado;
    }

    public void setpFlagDescargado(String pFlagDescargado) {
        this.pFlagDescargado = pFlagDescargado;
    }

    public String getpFlagGenerado() {
        return pFlagGenerado;
    }

    public void setpFlagGenerado(String pFlagGenerado) {
        this.pFlagGenerado = pFlagGenerado;
    }    
}
