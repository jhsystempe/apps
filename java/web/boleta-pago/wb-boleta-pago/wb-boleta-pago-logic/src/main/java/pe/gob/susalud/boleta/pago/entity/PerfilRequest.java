package pe.gob.susalud.boleta.pago.entity;

/**
 *
 * @author jllamas
 */
public class PerfilRequest implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private String coSistema;
    private String coPerfil;
    private String coIdentificador;
    private String coUsuario;
    private String deRazonSocial;
    private String deRuc;
    private String coIafas;
    private String idPersona;
    private String deUsuario;
    
    private String pcoPerfil;

    public String getCoSistema() {
        return coSistema;
    }

    public void setCoSistema(String coSistema) {
        this.coSistema = coSistema;
    }

    public String getCoPerfil() {
        return coPerfil;
    }

    public void setCoPerfil(String coPerfil) {
        this.coPerfil = coPerfil;
    }

    public String getCoIdentificador() {
        return coIdentificador;
    }

    public void setCoIdentificador(String coIdentificador) {
        this.coIdentificador = coIdentificador;
    }

    public String getDeUsuario() {
        return deUsuario;
    }

    public void setDeUsuario(String deUsuario) {
        this.deUsuario = deUsuario;
    }

    public String getCoUsuario() {
        return coUsuario;
    }

    public void setCoUsuario(String coUsuario) {
        this.coUsuario = coUsuario;
    }

    public String getDeRazonSocial() {
        return deRazonSocial;
    }

    public void setDeRazonSocial(String deRazonSocial) {
        this.deRazonSocial = deRazonSocial;
    }

    public String getDeRuc() {
        return deRuc;
    }

    public void setDeRuc(String deRuc) {
        this.deRuc = deRuc;
    }

    public String getCoIafas() {
        return coIafas;
    }

    public void setCoIafas(String coIafas) {
        this.coIafas = coIafas;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getPcoPerfil() {
        return pcoPerfil;
    }

    public void setPcoPerfil(String pcoPerfil) {
        this.pcoPerfil = pcoPerfil;
    }
        
}