package xu.barry.stu.jcth.network;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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

    @Test
    public void main() {
        String conditionBaseData = "{\"identification\":[{\"name\":\"在庫あり\",\"id\":195,\"type\":\"1\"},{\"name\":\"クーポン対象\",\"id\":196,\"type\":\"2\"}],\"filters\":[{\"filterLableName\":\"CPU\",\"id\":\"189\",\"list\":[{\"filterId\":\"321\",\"display\":true,\"filterName\":\"Celeron\",\"filterType\":\"1\"},{\"filterId\":\"322\",\"display\":true,\"filterName\":\"Core i3\",\"filterType\":\"1\"},{\"filterId\":\"327\",\"display\":true,\"filterName\":\"Core i5\",\"filterType\":\"1\"}]},{\"filterLableName\":\"画面サイズ1\",\"id\":\"188\",\"list\":[{\"filterId\":\"335\",\"display\":true,\"filterName\":\"12.5型\",\"filterType\":\"1\"},{\"filterId\":\"319\",\"display\":false,\"filterName\":\"13.3型\",\"filterType\":\"1\"},{\"filterId\":\"320\",\"display\":false,\"filterName\":\"15.6型\",\"filterType\":\"1\"},{\"filterId\":\"336\",\"display\":true,\"filterName\":\"23.8型\",\"filterType\":\"1\"},{\"filterId\":\"337\",\"display\":false,\"filterName\":\"27型\",\"filterType\":\"1\"}]},{\"filterLableName\":\"価格帯3\",\"id\":\"177\",\"list\":[{\"filterId\":\"301\",\"filterValue\":\"50001~100000\",\"display\":true,\"filterName\":\"50,001~100,000円\",\"filterType\":\"2\"},{\"filterId\":\"325\",\"filterValue\":\"1~50000\",\"display\":true,\"filterName\":\"1~50,000円\",\"filterType\":\"2\"},{\"filterId\":\"326\",\"filterValue\":\"100001~150000\",\"display\":false,\"filterName\":\"100,001~150,000円\",\"filterType\":\"2\"}]}],\"category\":[{\"code\":\"29600\",\"name\":\"ノート・モバイル\",\"id\":193},{\"code\":\"35401\",\"name\":\"タブレット\",\"id\":204}]}";

        JSONObject baseTreeMap = JSONObject.parseObject(conditionBaseData);

        JSONArray filterArray =  (JSONArray)baseTreeMap.get("filters");
        filterArray.stream().forEach(filter -> {
            String filterLableName = (String)((JSONObject) filter).get("filterLableName");
            System.out.println(filterLableName);
            JSONArray list = ( JSONArray)((JSONObject) filter).get("list");
            list.stream().forEach(l ->{
                JSONObject obj = (JSONObject)l;
                System.out.println(obj.get("display").toString()+"\t"+obj.get("filterName").toString());
            });

        });
    }
}
