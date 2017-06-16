package pe.gob.susalud.boleta.pago.service.imp;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pe.gob.susalud.boleta.pago.entity.GenerarRequest;
import pe.gob.susalud.boleta.pago.model.ActualizaBoleta;
import pe.gob.susalud.boleta.pago.model.BoletaPago;
import pe.gob.susalud.boleta.pago.report.bean.Aportacion;
import pe.gob.susalud.boleta.pago.report.bean.Boleta;
import pe.gob.susalud.boleta.pago.report.bean.Egreso;
import pe.gob.susalud.boleta.pago.report.bean.Ingreso;
import pe.gob.susalud.boleta.pago.report.test.BoletaTest;
import pe.gob.susalud.boleta.pago.service.BoletaPagoService;
import pe.gob.susalud.boleta.pago.service.GenerarBoletaService;
import pe.org.jhsystem.util.manager.trace.ManagerTrace;

/**
 *
 * @author jllamas
 */
@Service("generarBoletaService")
public class GenerarBoletaServiceImpl  implements GenerarBoletaService{
    
    private static final Logger logger = LogManager.getLogger(GenerarBoletaServiceImpl.class);
    
    JasperReport jasperReport;
    JasperPrint jasperPrint;

    @Value("${pathArchivos}")
    private String pathArchivos;
    
    @Value("${reporteLogo}")
    private String reporteLogo;
    
    @Value("${reporteFirma}")
    private String reporteFirma;
    
    @Autowired
    private BoletaPagoService boletaPagoService;
    
    @Override
    public String generarBoleta(GenerarRequest generar) {
        long TInicio, TFin, tiempo;
        TInicio = System.currentTimeMillis();
        String mensaje = "", error = "0000";
        int iCorrecto = 0, iIncorrecto = 0;
        String sCorrecto = "", sIncorrecto = "";
        String sArchivo = "";
        String sRuta = "/" + generar.getNuAnio() + generar.getNuMes();
        ActualizaBoleta actualiza = new ActualizaBoleta();
        
        logger.debug("Inicio del proceso..."+Long.toString(TInicio));
        String path = generar.getDePath();
        //Generar carpeta
        File directorio = new File(pathArchivos + sRuta);
        directorio.mkdir(); 
        sRuta = sRuta + "/";

        //Ubicar plantilla
        String ruta = path + "/WEB-INF/classes/pe/gob/susalud/boleta/pago/report/";
        File fichero = new File(ruta + "rpBoletaPagoTest.jasper");

        try {
            jasperReport = (JasperReport) JRLoader.loadObject(fichero.toString());
            error = "0000";
        } catch (JRException ex) {
            error = "9100"; //Error al obtener plantilla
            mensaje = error +":Error al obtener plantilla:\n" + ManagerTrace.PilaToString(ex);
            logger.error(mensaje);
        }
        if(!error.equals("0000")) return error;
        //Obtener data
        List<BoletaPago> listaBoletaPago = null;
        try {
            listaBoletaPago = boletaPagoService.obtenerBoleta(generar);
            error = "0000";
        } catch (Exception ex) {
            error = "9000"; //Error de base de datos
            mensaje = error+":Error de base de datos:\n" + ManagerTrace.PilaToString(ex);
            logger.error(mensaje);
        }
        if(!error.equals("0000")) return error;
        if(!listaBoletaPago.isEmpty()){
            for (int i=0; i<listaBoletaPago.size();i++) {
                BoletaPago boletaPago = listaBoletaPago.get(i);

                Boleta boleta = new Boleta();
                ArrayList<Ingreso> ingresos = new ArrayList<>();
                ArrayList<Egreso> egresos = new ArrayList<>();
                ArrayList<Aportacion> aportaciones = new ArrayList<>();
                
                String idRegistro = boletaPago.getIdRegistro();
                boleta.setIdBoleta(boletaPago.getIdBoleta());
                boleta.setDeRegimen(boletaPago.getDeRegimen());
                boleta.setNoServidor(boletaPago.getNoServidor());
                boleta.setNuDocumento(boletaPago.getNuDocumento());
                boleta.setDeCargo(boletaPago.getDeCargo());
                boleta.setTiCondicion(boletaPago.getTiCondicion());
                boleta.setDeDependencia(boletaPago.getDeDependencia());
                boleta.setDeSueldo(boletaPago.getDeSueldo());
                boleta.setFeIngreso(boletaPago.getFeIngreso());
                boleta.setNoAfp(boletaPago.getNoAfp());
                boleta.setNoEps(boletaPago.getNoEps());
                boleta.setCoAfiliacion(boletaPago.getCoAfiliacion());
                boleta.setDePeriodo(boletaPago.getDePeriodo());
                boleta.setNuEssalud(boletaPago.getNuEssalud());
                boleta.setNuCuenta(boletaPago.getNuCuenta());
                boleta.setNoBanco(boletaPago.getNoBanco());
                boleta.setNuDias(boletaPago.getNuDias());
                boleta.setNuHoras(boletaPago.getNuHoras());
                boleta.setFePago(boletaPago.getFePago());
                boleta.setToIngresos(boletaPago.getToIngresos());
                boleta.setToEgresos(boletaPago.getToEgresos());
                boleta.setToNeto(boletaPago.getToNeto());
                boleta.setDeMonto(boletaPago.getDeMonto());

                String deIngresos = boletaPago.getDeIngresos();
                String[] aIngreso = deIngresos.split("#");
                for(int j=0;j<aIngreso.length;j++){
                    Ingreso ingreso = new Ingreso();
                    String sConcepto = aIngreso[j].substring(0,aIngreso[j].indexOf("|"));
                    String sMonto = aIngreso[j].substring(aIngreso[j].indexOf("|")+1);
                    ingreso.setInConcepto(sConcepto);
                    ingreso.setInMonto(sMonto);
                    ingresos.add(ingreso);                
                }

                String deEgresos = boletaPago.getDeEgresos();
                String[] aEgreso = deEgresos.split("#");
                for(int k=0;k<aEgreso.length;k++){
                    Egreso egreso = new Egreso();
                    String sConcepto = aEgreso[k].substring(0,aEgreso[k].indexOf("|"));
                    String sMonto = aEgreso[k].substring(aEgreso[k].indexOf("|")+1);
                    egreso.setEgConcepto(sConcepto);
                    egreso.setEgMonto(sMonto);
                    egresos.add(egreso);
                }

                String deAportaciones = boletaPago.getDeAportaciones();
                String[] aAportacion = deAportaciones.split("#");
                for(int l=0;l<aAportacion.length;l++){
                    Aportacion aportacion = new Aportacion();
                    String sConcepto = aEgreso[l].substring(0,aEgreso[l].indexOf("|"));
                    String sMonto = aEgreso[l].substring(aEgreso[l].indexOf("|")+1);
                    aportacion.setApConcepto(sConcepto);
                    aportacion.setApMonto(sMonto);
                    aportaciones.add(aportacion);
                }

                boleta.setaIngreso(ingresos);
                boleta.setaEgreso(egresos);
                boleta.setaAportacion(aportaciones);

                idRegistro = String.format("%010d",Integer.parseInt(idRegistro));
                sArchivo = generar.getNuAnio().trim()+ "_" + generar.getNuMes() + "_" + idRegistro + ".pdf";

                Map reporteMap = new HashMap();
                reporteMap.put("pLogo", reporteLogo);
                reporteMap.put("pFirma", reporteFirma);
                reporteMap.put("SUBREPORT_DIR", ruta);
                
                List aux = new ArrayList();
                aux.add(boleta);
                JRBeanCollectionDataSource dsBean =new JRBeanCollectionDataSource(aux);
                try {
                    jasperPrint = JasperFillManager.fillReport(jasperReport, reporteMap, dsBean);
                    JasperExportManager.exportReportToPdfFile( jasperPrint, pathArchivos + sRuta + sArchivo);
                    listaBoletaPago.get(i).setInPrint("1");
                } catch (JRException ex) {
                    listaBoletaPago.get(i).setInPrint("0");
                    mensaje = "No genero archivo:\n" + ManagerTrace.PilaToString(ex);
                    logger.error(mensaje);
                }
            }
            for (Iterator<BoletaPago> it = listaBoletaPago.iterator(); it.hasNext();) {
                BoletaPago pago = it.next();
                String inPrint = pago.getInPrint();
                if(inPrint.equals("1")){
                    iCorrecto++;
                    sCorrecto = sCorrecto +','+ pago.getIdRegistro();
                } else {
                    iIncorrecto++;
                    sIncorrecto = sIncorrecto +','+ pago.getIdRegistro();
                }
            }
            actualiza.setpRuta(sRuta);
            if(iCorrecto >= iIncorrecto){
                actualiza.setpRegistro1(sCorrecto.substring(sCorrecto.indexOf(",")+1));
                actualiza.setpRegistro2("");
                actualiza.setpIndicador("1");
            } else {
                actualiza.setpRegistro1(sIncorrecto.substring(sIncorrecto.indexOf(",")+1));
                actualiza.setpRegistro2("");
                actualiza.setpIndicador("0");
            };
            try {
                boletaPagoService.actualizarBoleta(actualiza);
                error = "0000";
            } catch (Exception ex) {
                error = "9000"; //Error de base de datos
                mensaje = error+":Error de base de datos:\n" + ManagerTrace.PilaToString(ex);
                logger.error(mensaje);
            }
        }
        TFin = System.currentTimeMillis();
        logger.debug("Fin del proceso..."+Long.toString(TFin));
        tiempo = TFin - TInicio;
        logger.debug("Tiempo de ejecución en milisegundos: " + tiempo);
        return error;
    }
    
    @Override
    public byte[] generarBoletaTest(GenerarRequest generar){
        logger.debug("Generando reporte de prueba...");
        String path = generar.getDePath();
        String error = "0000", mensaje = "";
        byte[] reporte = null;
        File fichero = new File(path + "/WEB-INF/classes/pe/gob/susalud/boleta/pago/report/rpBoletaPagoTest.jasper");
        
        
        Map reporteMap = new HashMap();
        reporteMap.put("pLogo", reporteLogo);
        reporteMap.put("pFirma", reporteFirma);
        try {
            jasperReport = (JasperReport) JRLoader.loadObject(fichero.toString());
        } catch (JRException ex) {
            error = "9500";
            mensaje = error+":Error al cargar archivo del reporte:\n" + ManagerTrace.PilaToString(ex);
            logger.error(ex);
        }
        if(error.equals("0000")){
            JRBeanCollectionDataSource dsBean =new JRBeanCollectionDataSource(BoletaTest.getBoletas());
            try {
                reporte = JasperRunManager.runReportToPdf(jasperReport, reporteMap, dsBean);
            } catch (JRException ex) {
                error = "9510";
                mensaje = error+":Error al generar reporte:\n" + ManagerTrace.PilaToString(ex);
                logger.error(ex);
            }
        }
        return reporte;
    }
}
