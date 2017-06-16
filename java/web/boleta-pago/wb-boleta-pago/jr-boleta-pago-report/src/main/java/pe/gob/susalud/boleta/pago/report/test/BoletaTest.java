/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.susalud.boleta.pago.report.test;

import java.util.ArrayList;
import pe.gob.susalud.boleta.pago.report.bean.Aportacion;
import pe.gob.susalud.boleta.pago.report.bean.Boleta;
import pe.gob.susalud.boleta.pago.report.bean.Egreso;
import pe.gob.susalud.boleta.pago.report.bean.Ingreso;

/**
 *
 * @author jhuaman
 */
public class BoletaTest {

    public static ArrayList<Boleta> getBoletas(){
        ArrayList<Boleta> boletas = new ArrayList<Boleta>();
        ArrayList<Ingreso> ingresos = new ArrayList<Ingreso>();
        ArrayList<Egreso> egresos = new ArrayList<Egreso>();
        ArrayList<Aportacion> aportaciones = new ArrayList<Aportacion>();
        
        Boleta boleta = new Boleta();
        boleta.setIdBoleta("584.29");
        boleta.setDeRegimen("REGIMEN ESPECIAL CAS - D.L. 1057");
        boleta.setNoServidor("000000671 MUÑOZ LINO MIGUEL ANGEL");
        boleta.setNuDocumento("41265591");
        boleta.setDeCargo("APOYO EN LA EDUCACIÓN, DESARROLLO Y MANTENIMIENTO");
        boleta.setTiCondicion("PLAZO FIJO");
        boleta.setDeDependencia("OFICINA GENERAL DE ADMINISTRACIÓN");
        boleta.setNoSueldo("Contraprestación");
        boleta.setDeSueldo("6,000.00");
        boleta.setFeIngreso("25/09/2016");
        boleta.setNoAfp("AFP INTEGRA MISTA");
        boleta.setNoEps("");
        boleta.setCoAfiliacion("");
        boleta.setDePeriodo("AGOSTO 2016");
        boleta.setNuEssalud("79003171MOLOM005");
        boleta.setNuCuenta("8700165130");
        boleta.setNoBanco("BANCO SCOTIABANK");
        boleta.setNuDias("22");
        boleta.setNuHoras("176");
        boleta.setFePago("23/08/2016");
        boleta.setToIngresos("5,842.92");
        boleta.setToEgresos("733.87");
        boleta.setToNeto("5,109.05");
        boleta.setDeMonto("CINCO MIL CIENTO NUEVE Y 05/100 SOLES");
        
        Ingreso ingreso = new Ingreso();
        ingreso.setInConcepto("CBASM CONTRAPRESTACION");
        ingreso.setInMonto("7,242.92");
        ingresos.add(ingreso);
        Ingreso ingreso1 = new Ingreso();
        ingreso1.setInConcepto("RVACA REMUNERACION VACACIONAL");
        ingreso1.setInMonto("1,600.00");
        ingresos.add(ingreso1);
        
        Egreso egreso = new Egreso();
        egreso.setEgConcepto("AOAFP APORTE OBLIGATORIO AFP");
        egreso.setEgMonto("584.29");
        egresos.add(egreso);
        Egreso egreso1 = new Egreso();
        egreso1.setEgConcepto("CVARP COMISION VARIABLE AFP");
        egreso1.setEgMonto("71.87");
        egresos.add(egreso1);
        Egreso egreso2 = new Egreso();
        egreso2.setEgConcepto("PSAFP PRIMA SEGURO ISS - AFP");
        egreso2.setEgMonto("77.71");
        egresos.add(egreso2);
        
        Aportacion aportacion = new Aportacion();
        aportacion.setApConcepto("ESSAL ESSALUD");
        aportacion.setApMonto("106.65");
        aportaciones.add(aportacion);
        
        boleta.setaIngreso(ingresos);
        boleta.setaEgreso(egresos);
        boleta.setaAportacion(aportaciones);
        
        boletas.add(boleta);
        return boletas;
    }

    public static ArrayList<Boleta> getVariasBoletas(){
        ArrayList<Boleta> boletas = new ArrayList<Boleta>();
        ArrayList<Ingreso> ingresos1 = new ArrayList<Ingreso>();
        ArrayList<Egreso> egresos1 = new ArrayList<Egreso>();
        ArrayList<Aportacion> aportaciones1 = new ArrayList<Aportacion>();
        ArrayList<Ingreso> ingresos2 = new ArrayList<Ingreso>();
        ArrayList<Egreso> egresos2 = new ArrayList<Egreso>();
        ArrayList<Aportacion> aportaciones2 = new ArrayList<Aportacion>();
        
        Boleta boleta1 = new Boleta();
        boleta1.setIdBoleta("584.29");
        boleta1.setDeRegimen("REGIMEN ESPECIAL CAS - D.L. 1057");
        boleta1.setNoServidor("000000671 MUÑOZ LINO MIGUEL ANGEL");
        boleta1.setNuDocumento("41265591");
        boleta1.setDeCargo("APOYO EN LA EDUCACIÓN, DESARROLLO Y MANTENIMIENTO");
        boleta1.setTiCondicion("PLAZO FIJO");
        boleta1.setDeDependencia("OFICINA GENERAL DE ADMINISTRACIÓN");
        boleta1.setNoSueldo("Contraprestación");
        boleta1.setDeSueldo("6,000.00");
        boleta1.setFeIngreso("25/09/2016");
        boleta1.setNoAfp("AFP INTEGRA MISTA");
        boleta1.setNoEps("");
        boleta1.setCoAfiliacion("");
        boleta1.setDePeriodo("AGOSTO 2016");
        boleta1.setNuEssalud("79003171MOLOM005");
        boleta1.setNuCuenta("8700165130");
        boleta1.setNoBanco("BANCO SCOTIABANK");
        boleta1.setNuDias("22");
        boleta1.setNuHoras("176");
        boleta1.setFePago("23/08/2016");
        boleta1.setToIngresos("5,842.92");
        boleta1.setToEgresos("733.87");
        boleta1.setToNeto("5,109.05");
        boleta1.setDeMonto("CINCO MIL CIENTO NUEVE Y 05/100 SOLES");
        
        Ingreso ingreso11 = new Ingreso();
        ingreso11.setInConcepto("CBASM CONTRAPRESTACION");
        ingreso11.setInMonto("7,242.92");
        ingresos1.add(ingreso11);
        Ingreso ingreso12 = new Ingreso();
        ingreso12.setInConcepto("RVACA REMUNERACION VACACIONAL");
        ingreso12.setInMonto("1,600.00");
        ingresos1.add(ingreso12);
        
        Egreso egreso11 = new Egreso();
        egreso11.setEgConcepto("AOAFP APORTE OBLIGATORIO AFP");
        egreso11.setEgMonto("584.29");
        egresos1.add(egreso11);
        Egreso egreso12 = new Egreso();
        egreso12.setEgConcepto("CVAFP COMISION VARIABLE AFP");
        egreso12.setEgMonto("71.87");
        egresos1.add(egreso12);
        Egreso egreso13 = new Egreso();
        egreso13.setEgConcepto("PSAFP PRIMA SEGURO ISS - AFP");
        egreso13.setEgMonto("77.71");
        egresos1.add(egreso13);
        
        Aportacion aportacion11 = new Aportacion();
        aportacion11.setApConcepto("ESSAL ESSALUD");
        aportacion11.setApMonto("106.65");
        aportaciones1.add(aportacion11);
        
        boleta1.setaIngreso(ingresos1);
        boleta1.setaEgreso(egresos1);
        boleta1.setaAportacion(aportaciones1);

        
        Boleta boleta2 = new Boleta();
        boleta2.setIdBoleta("6861");
        boleta2.setDeRegimen("D.S. 001 - 98 - TR del 22.01.98 Art. 13° y 14°");
        boleta2.setNoServidor("00000064 LOBATON FLORES JUAN JOSE");
        boleta2.setNuDocumento("06606063");
        boleta2.setDeCargo("ESPECIALISTA EN ANALISIS DE SISTEMAS");
        boleta2.setTiCondicion("PLAZO INDETERMI");
        boleta2.setDeDependencia("INTENDENCIA DE INVESTIGACION Y DESARROLLO");
        boleta2.setNoSueldo("Sueldo Básico");
        boleta2.setDeSueldo("6,764.00");
        boleta2.setFeIngreso("01/04/2002");
        boleta2.setNoAfp("AFP PROFUTURO");
        boleta2.setNoEps("");
        boleta2.setCoAfiliacion("155102-00");
        boleta2.setDePeriodo("MAYO 2016");
        boleta2.setNuEssalud("6604021LAFRJ002");
        boleta2.setNuCuenta("04035051398");
        boleta2.setNoBanco("BANCO DE LA NACION");
        boleta2.setNuDias("30");
        boleta2.setNuHoras("240");
        boleta2.setFePago("23/05/2016");
        boleta2.setToIngresos("6,849.00");
        boleta2.setToEgresos("1,690.31");
        boleta2.setToNeto("5,158.69");
        boleta2.setDeMonto("CINCO MIL CIENTO CINCUENTAOCHO Y 69/100 SOLES");
        
        Ingreso ingreso21 = new Ingreso();
        ingreso21.setInConcepto("ASFAM ASIGNACION FAMILIAR");
        ingreso21.setInMonto("85.00");
        ingresos2.add(ingreso21);
        Ingreso ingreso22 = new Ingreso();
        ingreso22.setInConcepto("RBASM REMUNERACION DEL MES");
        ingreso22.setInMonto("6,764.00");
        ingresos2.add(ingreso22);
        
        Egreso egreso21 = new Egreso();
        egreso21.setEgConcepto("AOAFP APORTE OBLIGATORIO AFP");
        egreso21.setEgMonto("682.62");
        egresos2.add(egreso21);
        Egreso egreso22 = new Egreso();
        egreso22.setEgConcepto("CVAFP COMISION VARIABLE AFP");
        egreso22.setEgMonto("115.36");
        egresos2.add(egreso22);
        Egreso egreso23 = new Egreso();
        egreso23.setEgConcepto("DASIS DESCUENTO DE ASISTENCIA");
        egreso23.setEgMonto("22.83");
        egresos2.add(egreso23);
        Egreso egreso24 = new Egreso();
        egreso24.setEgConcepto("EVIDA ESSALUD VIDA");
        egreso24.setEgMonto("5.00");
        egresos2.add(egreso24);
        Egreso egreso25 = new Egreso();
        egreso25.setEgConcepto("PSAFP PRIMA SEGURO ISS - AFP");
        egreso25.setEgMonto("90.79");
        egresos2.add(egreso25);
        Egreso egreso26 = new Egreso();
        egreso26.setEgConcepto("RENTQ IMP.RENTA 5TA CATEGORIA");
        egreso26.setEgMonto("773.71");
        egresos2.add(egreso26);
        
        Aportacion aportacion21 = new Aportacion();
        aportacion21.setApConcepto("ESSAL ESSALUD");
        aportacion21.setApMonto("614.36");
        aportaciones2.add(aportacion21);
        
        boleta2.setaIngreso(ingresos2);
        boleta2.setaEgreso(egresos2);
        boleta2.setaAportacion(aportaciones2);

        boletas.add(boleta1);
        boletas.add(boleta2);
        
        return boletas;
    }

    public static ArrayList<Boleta> getSoloBoletas(){
        ArrayList<Boleta> boletas = new ArrayList<Boleta>();
        ArrayList<Ingreso> ingresos = new ArrayList<Ingreso>();
        ArrayList<Egreso> egresos = new ArrayList<Egreso>();
        ArrayList<Aportacion> aportaciones = new ArrayList<Aportacion>();
        
        Boleta boleta = new Boleta();
        boleta.setIdBoleta("584.29");
        boleta.setDeRegimen("REGIMEN ESPECIAL CAS - D.L. 1057");
        boleta.setNoServidor("000000671 MUÑOZ LINO MIGUEL ANGEL");
        boleta.setNuDocumento("41265591");
        boleta.setDeCargo("APOYO EN LA EDUCACIÓN, DESARROLLO Y MANTENIMIENTO");
        boleta.setTiCondicion("PLAZO FIJO");
        boleta.setDeDependencia("OFICINA GENERAL DE ADMINISTRACIÓN");
        boleta.setNoSueldo("Contraprestación");
        boleta.setDeSueldo("6,000.00");
        boleta.setFeIngreso("25/09/2016");
        boleta.setNoAfp("AFP INTEGRA MISTA");
        boleta.setNoEps("");
        boleta.setCoAfiliacion("");
        boleta.setDePeriodo("AGOSTO 2016");
        boleta.setNuEssalud("79003171MOLOM005");
        boleta.setNuCuenta("8700165130");
        boleta.setNoBanco("BANCO SCOTIABANK");
        boleta.setNuDias("22");
        boleta.setNuHoras("176");
        boleta.setFePago("23/08/2016");
        boleta.setToIngresos("5,842.92");
        boleta.setToEgresos("733.87");
        boleta.setToNeto("5,109.05");
        boleta.setDeMonto("CINCO MIL CIENTO NUEVE Y 05/100 SOLES");
        
        Ingreso ingreso = new Ingreso();
        ingreso.setInConcepto("CBASM CONTRAPRESTACION");
        ingreso.setInMonto("7,242.92");
        ingresos.add(ingreso);
        Ingreso ingreso1 = new Ingreso();
        ingreso1.setInConcepto("RVACA REMUNERACION VACACIONAL");
        ingreso1.setInMonto("1,600.00");
        ingresos.add(ingreso1);
        
        Ingreso ingreso2 = new Ingreso();
        ingreso2.setInConcepto("CBASM CONTRAPRESTACION");
        ingreso2.setInMonto("7,242.92");
        ingresos.add(ingreso2);
        Ingreso ingreso3 = new Ingreso();
        ingreso3.setInConcepto("RVACA REMUNERACION VACACIONAL");
        ingreso3.setInMonto("1,600.00");
        ingresos.add(ingreso3);

        Egreso egreso = new Egreso();
        egreso.setEgConcepto("AOAFP APORTE OBLIGATORIO AFP");
        egreso.setEgMonto("584.29");
        egresos.add(egreso);
        Egreso egreso1 = new Egreso();
        egreso1.setEgConcepto("CVARP COMISION VARIABLE AFP");
        egreso1.setEgMonto("71.87");
        egresos.add(egreso1);
        Egreso egreso2 = new Egreso();
        egreso2.setEgConcepto("PSAFP PRIMA SEGURO ISS - AFP");
        egreso2.setEgMonto("77.71");
        egresos.add(egreso2);
        
        Egreso egreso3 = new Egreso();
        egreso3.setEgConcepto("AOAFP APORTE OBLIGATORIO AFP");
        egreso3.setEgMonto("584.29");
        egresos.add(egreso3);
        Egreso egreso4 = new Egreso();
        egreso4.setEgConcepto("CVARP COMISION VARIABLE AFP");
        egreso4.setEgMonto("71.87");
        egresos.add(egreso4);
        Egreso egreso5 = new Egreso();
        egreso5.setEgConcepto("PSAFP PRIMA SEGURO ISS - AFP");
        egreso5.setEgMonto("77.71");
        egresos.add(egreso5);

        Aportacion aportacion = new Aportacion();
        aportacion.setApConcepto("ESSAL ESSALUD");
        aportacion.setApMonto("106.65");
        aportaciones.add(aportacion);
        
        Aportacion aportacion1 = new Aportacion();
        aportacion1.setApConcepto("ESSAL ESSALUD");
        aportacion1.setApMonto("106.65");
        aportaciones.add(aportacion1);
        Aportacion aportacion2 = new Aportacion();
        aportacion2.setApConcepto("ESSAL ESSALUD");
        aportacion2.setApMonto("106.65");
        aportaciones.add(aportacion2);
        
        boleta.setaIngreso(ingresos);
        boleta.setaEgreso(egresos);
        boleta.setaAportacion(aportaciones);
        
        boletas.add(boleta);
        return boletas;
    }
    
}
