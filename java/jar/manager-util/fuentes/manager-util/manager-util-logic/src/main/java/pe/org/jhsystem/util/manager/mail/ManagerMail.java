package pe.org.jhsystem.util.manager.mail;

import java.util.StringTokenizer;

/**
 * @author Jose Luis Huaman Villar
 * @see <a href="http://diariojl.blogspot.pe/p/blog-page.html" target="_blank">ManagerUtil</a>
 * @version 1.0.5
 * @since 10-12-2014
 */
public class ManagerMail {
    
    private String sendTo;
    private String sendCC;
    private String sendBCC;
    private String token;

    /**
     * Constructor por defecto de la clase
     */
    public ManagerMail() {
    }

    /**
     * Constructor de la clase
     * @param sendTo, string con los correos a enviar en la etiqueta "Para".
     * @param sendCC, string con los correos a enviar en la etiqueta "Con Copia".
     * @param sendBCC, string con los correos a enviar en la etiqueta "Con Copia Oculta".
     * @param token, string que indica el separador de correos, normalmente una coma ",".
     */
    public ManagerMail(String sendTo, String sendCC, String sendBCC, String token) {
        this.sendTo = sendTo;
        this.sendCC = sendCC;
        this.sendBCC = sendBCC;
        this.token = token;
    }

    public String getSendBCC() {
        return sendBCC;
    }

    public void setSendBCC(String sendBCC) {
        this.sendBCC = sendBCC;
    }

    public String getSendCC() {
        return sendCC;
    }

    public void setSendCC(String sendCC) {
        this.sendCC = sendCC;
    }

    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Metodo que devuelve un array de string con los correos a enviar en la etiqueta "Para".
     * @return string[] array de correos obtenidos.
     * @since version 1.0.5
     */
    public String[] aSendTo(){
        return getMails(sendTo,token);
    }

    /**
     * Metodo que devuelve un array de string con los correos a enviar en la etiqueta "Con Copia".
     * @return string[] array de correos obtenidos.
     * @since version 1.0.5
     */
    public String[] aSendCC(){
        return getMails(sendCC,token);
    }

    /**
     * Metodo que devuelve un array de string con los correos a enviar en la etiqueta "Con Copia Oculta".
     * @return string[] array de correos obtenidos.
     * @since version 1.0.5
     */
    public String[] aSendBCC(){
        return getMails(sendBCC,token);
    }

    /**
     * Metodo que convierte de una cadena de texto un array de cadenas en base a un indicador o token.
     * @param cadena, donde se encuentra la lista de correos ingresados.
     * @return string[] array de correos.
     * @since version 1.0.5
     */
    private static String[] getMails(String cadena, String token) {
        StringTokenizer tokenizer = new StringTokenizer(cadena, token);
        String[] mails = new String[tokenizer.countTokens()];
        for (int i = 0; tokenizer.hasMoreTokens(); i++) mails[i] = tokenizer.nextToken();
        return mails;
    }
}

