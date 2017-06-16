package pe.gob.susalud.boleta.pago.report.bean;

import java.util.ArrayList;

/**
 *
 * @author jhuaman
 */
public class Boleta {
    private String deRegimen;
    private String noServidor;
    private String nuDocumento;
    private String deCargo;
    private String tiCondicion;
    private String deDependencia;
    private String deSueldo;
    private String noSueldo;
    private String feIngreso;
    private String nuEssalud;
    private String noAfp;
    private String nuCuenta;
    private String noEps;
    private String noBanco;
    private String coAfiliacion;
    private String nuDias;
    private String nuHoras;
    private String dePeriodo;
    private String fePago;
    private String toIngresos;
    private String toEgresos;
    private String toNeto;
    private String deMonto;
    private String idBoleta;
    ArrayList<Ingreso> aIngreso;
    ArrayList<Egreso> aEgreso;
    ArrayList<Aportacion> aAportacion;

    public Boleta() {
    }

    public Boleta(String deRegimen, String noServidor, String nuDocumento, String deCargo, String tiCondicion, String deDependencia, String deSueldo, String noSueldo, String feIngreso, String nuEssalud, String noAfp, String nuCuenta, String noEps, String noBanco, String coAfiliacion, String nuDias, String nuHoras, String dePeriodo, String fePago, String toIngresos, String toEgresos, String toNeto, String deMonto, String idBoleta, ArrayList<Ingreso> aIngreso, ArrayList<Egreso> aEgreso, ArrayList<Aportacion> aAportacion) {
        this.deRegimen = deRegimen;
        this.noServidor = noServidor;
        this.nuDocumento = nuDocumento;
        this.deCargo = deCargo;
        this.tiCondicion = tiCondicion;
        this.deDependencia = deDependencia;
        this.deSueldo = deSueldo;
        this.noSueldo = noSueldo;
        this.feIngreso = feIngreso;
        this.nuEssalud = nuEssalud;
        this.noAfp = noAfp;
        this.nuCuenta = nuCuenta;
        this.noEps = noEps;
        this.noBanco = noBanco;
        this.coAfiliacion = coAfiliacion;
        this.nuDias = nuDias;
        this.nuHoras = nuHoras;
        this.dePeriodo = dePeriodo;
        this.fePago = fePago;
        this.toIngresos = toIngresos;
        this.toEgresos = toEgresos;
        this.toNeto = toNeto;
        this.deMonto = deMonto;
        this.idBoleta = idBoleta;
        this.aIngreso = aIngreso;
        this.aEgreso = aEgreso;
        this.aAportacion = aAportacion;
    }

    public String getDeRegimen() {
        return deRegimen;
    }

    public void setDeRegimen(String deRegimen) {
        this.deRegimen = deRegimen;
    }

    public String getNoServidor() {
        return noServidor;
    }

    public void setNoServidor(String noServidor) {
        this.noServidor = noServidor;
    }

    public String getNuDocumento() {
        return nuDocumento;
    }

    public void setNuDocumento(String nuDocumento) {
        this.nuDocumento = nuDocumento;
    }

    public String getDeCargo() {
        return deCargo;
    }

    public void setDeCargo(String deCargo) {
        this.deCargo = deCargo;
    }

    public String getTiCondicion() {
        return tiCondicion;
    }

    public void setTiCondicion(String tiCondicion) {
        this.tiCondicion = tiCondicion;
    }

    public String getDeDependencia() {
        return deDependencia;
    }

    public void setDeDependencia(String deDependencia) {
        this.deDependencia = deDependencia;
    }

    public String getDeSueldo() {
        return deSueldo;
    }

    public void setDeSueldo(String deSueldo) {
        this.deSueldo = deSueldo;
    }

    public String getNoSueldo() {
        return noSueldo;
    }

    public void setNoSueldo(String noSueldo) {
        this.noSueldo = noSueldo;
    }

    public String getFeIngreso() {
        return feIngreso;
    }

    public void setFeIngreso(String feIngreso) {
        this.feIngreso = feIngreso;
    }

    public String getNuEssalud() {
        return nuEssalud;
    }

    public void setNuEssalud(String nuEssalud) {
        this.nuEssalud = nuEssalud;
    }

    public String getNoAfp() {
        return noAfp;
    }

    public void setNoAfp(String noAfp) {
        this.noAfp = noAfp;
    }

    public String getNuCuenta() {
        return nuCuenta;
    }

    public void setNuCuenta(String nuCuenta) {
        this.nuCuenta = nuCuenta;
    }

    public String getNoEps() {
        return noEps;
    }

    public void setNoEps(String noEps) {
        this.noEps = noEps;
    }

    public String getNoBanco() {
        return noBanco;
    }

    public void setNoBanco(String noBanco) {
        this.noBanco = noBanco;
    }

    public String getCoAfiliacion() {
        return coAfiliacion;
    }

    public void setCoAfiliacion(String coAfiliacion) {
        this.coAfiliacion = coAfiliacion;
    }

    public String getNuDias() {
        return nuDias;
    }

    public void setNuDias(String nuDias) {
        this.nuDias = nuDias;
    }

    public String getNuHoras() {
        return nuHoras;
    }

    public void setNuHoras(String nuHoras) {
        this.nuHoras = nuHoras;
    }

    public String getDePeriodo() {
        return dePeriodo;
    }

    public void setDePeriodo(String dePeriodo) {
        this.dePeriodo = dePeriodo;
    }

    public String getFePago() {
        return fePago;
    }

    public void setFePago(String fePago) {
        this.fePago = fePago;
    }

    public String getToIngresos() {
        return toIngresos;
    }

    public void setToIngresos(String toIngresos) {
        this.toIngresos = toIngresos;
    }

    public String getToEgresos() {
        return toEgresos;
    }

    public void setToEgresos(String toEgresos) {
        this.toEgresos = toEgresos;
    }

    public String getToNeto() {
        return toNeto;
    }

    public void setToNeto(String toNeto) {
        this.toNeto = toNeto;
    }

    public String getDeMonto() {
        return deMonto;
    }

    public void setDeMonto(String deMonto) {
        this.deMonto = deMonto;
    }

    public String getIdBoleta() {
        return idBoleta;
    }

    public void setIdBoleta(String idBoleta) {
        this.idBoleta = idBoleta;
    }

    public ArrayList<Ingreso> getaIngreso() {
        return aIngreso;
    }

    public void setaIngreso(ArrayList<Ingreso> aIngreso) {
        this.aIngreso = aIngreso;
    }

    public ArrayList<Egreso> getaEgreso() {
        return aEgreso;
    }

    public void setaEgreso(ArrayList<Egreso> aEgreso) {
        this.aEgreso = aEgreso;
    }

    public ArrayList<Aportacion> getaAportacion() {
        return aAportacion;
    }

    public void setaAportacion(ArrayList<Aportacion> aAportacion) {
        this.aAportacion = aAportacion;
    }

}
