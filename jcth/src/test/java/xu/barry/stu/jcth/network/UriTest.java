package xu.barry.stu.jcth.network;

import org.junit.Test;

import java.net.URI;

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
}
