package pe.gob.susalud.boleta.pago.web;

import com.octo.captcha.service.CaptchaServiceException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import com.octo.captcha.service.multitype.GenericManageableCaptchaService;
//import com.sun.image.codec.jpeg.JPEGCodec;
//import com.sun.image.codec.jpeg.JPEGImageEncoder;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.ServletOutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.org.jhsystem.util.manager.ajax.ManagerAjax;

@Controller
public class CaptchaController {

    private static final Logger log = LogManager.getLogger(CaptchaController.class);
    @Autowired
    private GenericManageableCaptchaService captchaService;

    @RequestMapping("/public/captcha.htm")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //    logger.debug("Generando captcha...");
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        String captchaId = request.getSession().getId();
        BufferedImage challenge = captchaService.getImageChallengeForID(captchaId, request.getLocale());
//        JPEGImageEncoder jpegEncoder = JPEGCodec.createJPEGEncoder(jpegOutputStream);
//        
//        jpegEncoder.encode(challenge);

        ImageWriter imageWriter = (ImageWriter) ImageIO.getImageWritersBySuffix("jpeg").next();
        ImageOutputStream ios = ImageIO.createImageOutputStream(jpegOutputStream);
        imageWriter.setOutput(ios);
        IIOMetadata imageMetaData = imageWriter.getDefaultImageMetadata(new ImageTypeSpecifier(challenge), null);
        imageWriter.write(imageMetaData, new IIOImage(challenge, null, null), null);


        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
        return null;
    }

    @RequestMapping(value = "/public/comprobarcaptcha.htm", method = RequestMethod.POST)
    public ModelAndView checkImage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // logger.debug("Comprobando captcha...");
        Boolean isResponseCorrect = false;
        String captchaId = request.getSession().getId();
        String codigo = request.getParameter("codigo");
        codigo = codigo.toUpperCase();
//        log.info("comprobarcaptcha");
//        System.out.println("codigo:"+codigo);
        try {
            isResponseCorrect = captchaService.validateResponseForID(captchaId, codigo);
        } catch (CaptchaServiceException e) {
            // logger.error("Error: "+e.getMessage());
        }
//        log.info("comprobarcaptcha respuesta " + isResponseCorrect.toString());

        ManagerAjax.sendResult(response, isResponseCorrect.toString());
        return null;
    }
}
