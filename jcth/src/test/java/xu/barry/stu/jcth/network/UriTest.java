package xu.barry.stu.jcth.network;

import org.junit.Test;
import xu.barry.stu.jcth.utils.Printer;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Base64;

public class UriTest {

    /**
     *       <scheme>://<user>:<password>@<host>:<port>/<path>;<params>?<query>#<fragment>
     */
    @Test
    public void test(){
        URI uri  =  URI.create("https://blog.csdn.net/u013257679/article/details/52295106/");
        System.out.println(uri.getHost());
        System.out.println(uri.getPath());
        System.out.println(uri.getPort());
        System.out.println(uri.getRawPath());
    }

    @Test
    public void test64() throws UnsupportedEncodingException {
        Printer.println(new String(Base64.getEncoder().encode("rani_123".getBytes())));
        Printer.println(new String(Base64.getEncoder().encode("rani_123".getBytes("UTF-8"))));
    }
}
