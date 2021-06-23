package xu.barry.stu.jcth.network;

import org.junit.Test;
import xu.barry.stu.jcth.utils.Printer;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Base64;
import java.util.HashMap;

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

    private static final String message = "lianxiang";
    @Test
    public  void test1() {
        int i = 1;
        char a = 'a';
        System.out.println(a/2 == 48 ? 6:8 );
        System.out.println(2<<3);
        System.out.println(i ++ < ++i);

        String a1 = "lian" + "xiang" ;
        String b1 = "lian";
        String c1 = "xiang";

        System.out.println(a1 == message);
        System.out.println(b1 + c1 == message);

        System.out.println(0/Math.random());

        HashMap h = new HashMap();
        h.put("sss",null);
    }

}
