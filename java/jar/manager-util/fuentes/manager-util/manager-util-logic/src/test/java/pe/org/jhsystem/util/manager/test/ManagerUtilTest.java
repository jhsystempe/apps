package pe.org.jhsystem.util.manager.test;

import java.io.File;
import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pe.org.jhsystem.util.manager.properties.ManagerProperties;
import pe.org.jhsystem.util.manager.properties.exception.PropertiesException;
import pe.org.jhsystem.util.manager.trace.ManagerTrace;
import pe.org.jhsystem.util.manager.validate.ManagerValidate;

/**
 * @author Jose Luis Huaman Villar
 * @see <a href="http://diariojl.blogspot.pe/p/blog-page.html" target="_blank">ManagerUtil</a>
 * @version 1.0.6
 * @since 30-07-2016
 */
public class ManagerUtilTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ManagerUtilTest( String testName ) {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( ManagerUtilTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testManager() {
        File file = new File(ClassLoader.getSystemResource("manager-util-test.properties").getFile());
        ManagerProperties managerProperties = new ManagerProperties(file.toString());
        String dato1="", dato2="", dato3="";
        String sError = "0000";
        try {
            dato1 = managerProperties.getProperty("test.dato1");
            dato2 = managerProperties.getProperty("test.dato2");
            dato3 = managerProperties.getProperty("test.dato3");
        } catch (PropertiesException ex) {
            sError="9999";
            System.err.println(ManagerTrace.PilaToString(ex));
        }
        if(sError.equals("0000")){
            System.out.println("dato1:"+dato1);
            System.out.println("dato2:"+dato2);
            System.out.println("dato3:"+dato3);
        }
        Assert.assertEquals(sError,"0000");
        //Assert.assertEquals(ManagerValidate.validaCaracterCadena("123","1234567890"),'0');
    }
}
