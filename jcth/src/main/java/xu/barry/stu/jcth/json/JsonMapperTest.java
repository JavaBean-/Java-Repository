package xu.barry.stu.jcth.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import xu.barry.stu.jcth.utils.Printer;

import java.io.IOException;

public class JsonMapperTest {

    static String jsonStr = "{\"longDescription\":\"●Windows 10 Home&lt;br&gt;○インテル(R) Core(TM) i3-8145U&lt;br&gt;○4GB メモリ&lt;br&gt;●約1TB HDD&lt;br&gt;○DVDスーパーマルチドライブ&lt;br&gt;○23.8型ワイド LED IPS液晶(フルHD)&lt;br&gt;○TV機能なし&lt;br&gt;○11ac(433Mbps)対応&lt;br&gt;○Bluetooth(R)&lt;br&gt;○オフィスアプリなし&lt;br&gt;○本体色 ファインブラック&lt;br&gt;○1年間保証&lt;br&gt;※※詳しくは「商品詳細」をご確認ください。&lt;span style=\\\"display:none;\\\"&gt;QuantityLimits=\\\"1\\\"&lt;/span&gt;&lt;span style=\\\"display:none;\\\"&gt;お買い得品&lt;/span&gt;\",\"existCanUseCoupon\":1,\"orderStopDate\":2082639600000,\"description\":\"23.8型ワイド オールインワンPC\",\"office\":1,\"productName\":\"LAVIE Direct DA(S) [Windows 10 Home、Core i3、ファインブラック、1年間保証]\",\"haveMtmBuilder\":1,\"specs\":{\"55\":\"\",\"12\":\"\",\"24\":\"11ac(433Mbps)対応／Bluetooth(R)\",\"17\":\"DVDスーパーマルチドライブ\",\"1\":\"Windows 10 Home\",\"101\":\"\",\"200\":\"\",\"3\":\"インテル(R) Core(TM) i3-8145U\",\"5\":\"4GB メモリ\",\"6\":\"約1TB HDD\",\"91\":\"1年間保証\",\"81\":\"本体色 ファインブラック\",\"20\":\"23.8型ワイド液晶\",\"86\":\"オフィスアプリなし\",\"21\":\"TV機能なし\"},\"orderStartDate\":1574953200000,\"price\":{\"25\":87600,\"51\":\"87800\"},\"id\":\"GD212UCAF-XZ856\",\"brandNameJp\":\"デスクトップ\",\"seriesNameEn\":\"LAVIE\",\"productType\":1,\"basePrice\":\"87800\",\"hierarchyOrder\":55,\"image\":\"http://p1-nec.static.pub/resource/navigate/direct/config/images/cfg_pc/PC-GD212UCAF.jpg\",\"haveInventory\":1,\"coupon\":{\"25\":{\"code\":\"Close-Hie-F-P\",\"fromTime\":\"7月5日(月) 0時まで\",\"type\":1,\"value\":\"200\",\"toTime\":\"12月31日(月) 23時まで\"},\"82\":{\"code\":\"Affinity102_Close\",\"fromTime\":\"8月11日(水) 15時まで\",\"type\":0,\"value\":\"79\",\"toTime\":\"8月30日(水) 16時まで\"},\"20\":{\"code\":\"Close-Pro-R-P\",\"fromTime\":\"7月15日(木) 0時まで\",\"type\":0,\"value\":\"4\",\"toTime\":\"8月2日(金) 15時まで\"},\"54\":{\"code\":\"Close-Pro-F-P\",\"fromTime\":\"7月15日(木) 0時まで\",\"type\":1,\"value\":\"100\",\"toTime\":\"12月31日(月) 23時まで\"}},\"openCoupon\":\"{\\\"autoApply\\\":1,\\\"businessCouponType\\\":0,\\\"fromtime\\\":\\\"1月26日(火) 19時まで\\\",\\\"macode\\\":\\\"NAK-MTM-test5\\\",\\\"name\\\":\\\"NAK-MTM-test5\\\",\\\"normalType\\\":0,\\\"operationStatus\\\":1,\\\"productDiscount\\\":[{\\\"amount\\\":\\\"150\\\",\\\"discountType\\\":1,\\\"goodsCode\\\":\\\"GD212UCAF-XZ856\\\",\\\"maCode\\\":\\\"NAK-MTM-test5\\\"}],\\\"promoId\\\":\\\"\\\",\\\"recurrence\\\":0,\\\"totime\\\":\\\"1月6日(金) 19時まで\\\",\\\"type\\\":2}\",\"haveCoupon\":{\"25\":1,\"51\":0},\"inventoryStatus\":0,\"publishStopDate\":2082639600000,\"salesRoute\":[51,25],\"url\":\"/navigate/direct/tmd/pc/2019/1226/dt/xz856.html\",\"announceDate\":1574953200000,\"shipmentStartDate\":1574953200000,\"productCode\":873860,\"_sources\":{\"specs\":\"[{\\\"sort\\\": 1, \\\"createTime\\\": 1610518011307, \\\"categoryName\\\": \\\"OS\\\", \\\"specCategoryId\\\": 1, \\\"descriptionLong\\\": \\\"Windows 10 Home\\\", \\\"descriptionShort\\\": \\\"Windows 10 Home\\\"}, {\\\"sort\\\": 3, \\\"createTime\\\": 1610518011307, \\\"categoryName\\\": \\\"プロセッサー\\\", \\\"specCategoryId\\\": 3, \\\"descriptionLong\\\": \\\"インテル&reg; Core&trade; i3-8145U プロセッサー (2.10GHz)\\\", \\\"descriptionShort\\\": \\\"インテル(R) Core(TM) i3-8145U\\\"}, {\\\"sort\\\": 5, \\\"createTime\\\": 1610518011307, \\\"categoryName\\\": \\\"メモリ\\\", \\\"specCategoryId\\\": 5, \\\"descriptionLong\\\": \\\"4GB (4GB×1)\\\", \\\"descriptionShort\\\": \\\"4GB メモリ\\\"}, {\\\"sort\\\": 6, \\\"createTime\\\": 1610518011307, \\\"categoryName\\\": \\\"HDD\\\", \\\"specCategoryId\\\": 6, \\\"descriptionLong\\\": \\\"約1TB HDD (高速7200回転/分)\\\", \\\"descriptionShort\\\": \\\"約1TB HDD\\\"}, {\\\"sort\\\": 12, \\\"createTime\\\": 1610518011307, \\\"categoryName\\\": \\\"Optaneメモリー・SSD\\\", \\\"specCategoryId\\\": 12, \\\"descriptionLong\\\": \\\"なし\\\", \\\"descriptionShort\\\": \\\"\\\"}, {\\\"sort\\\": 17, \\\"createTime\\\": 1610518011307, \\\"categoryName\\\": \\\"DVD/CDドライブ\\\", \\\"specCategoryId\\\": 17, \\\"descriptionLong\\\": \\\"DVDスーパーマルチドライブ\\\", \\\"descriptionShort\\\": \\\"DVDスーパーマルチドライブ\\\"}, {\\\"sort\\\": 20, \\\"createTime\\\": 1610518011307, \\\"categoryName\\\": \\\"ディスプレイ\\\", \\\"specCategoryId\\\": 20, \\\"descriptionLong\\\": \\\"23.8型ワイド スーパーシャインビューLED IPS液晶 (フルHD・1920×1080ドット)\\\", \\\"descriptionShort\\\": \\\"23.8型ワイド液晶\\\"}, {\\\"sort\\\": 21, \\\"createTime\\\": 1610518011307, \\\"categoryName\\\": \\\"TV機能\\\", \\\"specCategoryId\\\": 21, \\\"descriptionLong\\\": \\\"なし\\\", \\\"descriptionShort\\\": \\\"TV機能なし\\\"}, {\\\"sort\\\": 24, \\\"createTime\\\": 1610518011307, \\\"categoryName\\\": \\\"ワイヤレス機能\\\", \\\"specCategoryId\\\": 24, \\\"descriptionLong\\\": \\\"11ac(433Mbps)対応ワイヤレスLAN (IEEE802.11ac/a/b/g/n) + Bluetooth&reg;\\\", \\\"descriptionShort\\\": \\\"11ac(433Mbps)対応／Bluetooth(R)\\\"}, {\\\"sort\\\": 55, \\\"createTime\\\": 1610518011307, \\\"categoryName\\\": \\\"キーボード・マウス\\\", \\\"specCategoryId\\\": 55, \\\"descriptionLong\\\": \\\"ワイヤレスキーボード・ワイヤレスマウス\\\", \\\"descriptionShort\\\": \\\"\\\"}, {\\\"sort\\\": 81, \\\"createTime\\\": 1610518011307, \\\"categoryName\\\": \\\"ボディカラー\\\", \\\"specCategoryId\\\": 81, \\\"descriptionLong\\\": \\\"ファインブラック\\\", \\\"descriptionShort\\\": \\\"本体色 ファインブラック\\\"}, {\\\"sort\\\": 86, \\\"createTime\\\": 1610518011307, \\\"categoryName\\\": \\\"オフィスアプリ\\\", \\\"specCategoryId\\\": 86, \\\"descriptionLong\\\": \\\"なし\\\", \\\"descriptionShort\\\": \\\"オフィスアプリなし\\\"}, {\\\"sort\\\": 91, \\\"createTime\\\": 1610518011307, \\\"categoryName\\\": \\\"保証\\\", \\\"specCategoryId\\\": 91, \\\"descriptionLong\\\": \\\"1年間保証\\\", \\\"descriptionShort\\\": \\\"1年間保証\\\"}, {\\\"sort\\\": 92, \\\"createTime\\\": 1610518011307, \\\"categoryName\\\": \\\"タイプ\\\", \\\"specCategoryId\\\": 101, \\\"descriptionLong\\\": \\\"2019年春モデル LAVIE Direct DA(S)\\\", \\\"descriptionShort\\\": \\\"\\\"}, {\\\"sort\\\": 200, \\\"createTime\\\": 1610518011307, \\\"categoryName\\\": \\\"※\\\", \\\"specCategoryId\\\": 200, \\\"descriptionLong\\\": \\\"構成内容は固定となります。 本体の仕様については、<a href=\\\\\\\"https://www.nec-lavie.jp/navigate/products/pc/191q/01/lavie/da/spec/index04.html\\\\\\\" target=\\\\\\\"_brank\\\\\\\">こちら</a>をご確認ください。\\\", \\\"descriptionShort\\\": \\\"\\\"}]\"},\"subItems\":\"[]\",\"brandNameEn\":\"Desktop\",\"seriesNameJp\":\"LAVIE\",\"categoryId\":\"29500\",\"storeCode\":[10056,10040,10055,10041,10022,10049,10021,10001,10020,10057,10048],\"_params\":{\"66\":[289],\"67\":[192],\"182\":[311],\"163\":[272],\"164\":[223],\"175\":[291],\"186\":[316],\"110\":[169],\"121\":[294],\"166\":[334],\"177\":[301],\"188\":[336],\"189\":[322],\"168\":[243],\"113\":[143,144,145],\"157\":[224],\"158\":[230],\"104\":[134,135],\"126\":[182],\"159\":[231],\"106\":[212],\"107\":[142],\"60\":[83]}}";

    static String filterStr = "{\"condition\":{\"118\":[\"283\",\"180\"],\"130\":[\"184\"],\"154\":[\"302\",\"406\"]},\"range\":{\"price.10\":[\"45455-90909\",\"90910-136364\",\"136365-181818\"]}}\n";

    static String filterStrWithoutPrice = "{\"condition\":{\"118\":[\"283\",\"180\"],\"130\":[\"184\"],\"154\":[\"302\",\"406\"]}}";


    public static void main(String[] args) throws IOException {
        ProduntJson stu = new ObjectMapper().readValue(jsonStr, ProduntJson.class);
        System.out.println(stu.toString());

        System.out.println(stu.get_params().get("113"));

        String price = stu.getPrice().get("25");
        Printer.partition();

        SelectedJson selectedWithoutPrice = new ObjectMapper().readValue(filterStrWithoutPrice, SelectedJson.class);
        SelectedJson selected = new ObjectMapper().readValue(filterStr, SelectedJson.class);

        System.out.println(selected.getCondition().get("154"));
        System.out.println(selected.toString());
        Printer.partition(filterStrWithoutPrice);
    }

    @Test
    public void binocularExpression(){
        Integer obj = 1;
        int a = null != obj && obj == 2 ? 3 : 0;
        System.out.println(a);
    }

    @Test
    public void filterCondition(){
        String url = "https://s.nec-lavie.jp/cmsTemplate/search/salesRoute?callback=jQuery35109000365619883293_1638329939220&page=1&pageSize=500&salesRoute=10" +
                "&newV2=1&defSort=1&specs=118-213,&price=50001~100000,200001~*,&afterCouponPrice=1&_=1638329939226";
        JSONObject selected = new JSONObject();
        settingCondition("189-322","50001~100000,200001~*", selected, "");
        System.out.println(selected.toString());
    }


    private void settingCondition(String specs, String price, JSONObject condition, String prefix) {
        // specs 过滤
        if (!StringUtils.isEmpty(specs)) {
            String[] split = specs.split("\\s*,\\s*");
            for (String s : split) {
                if (!StringUtils.isEmpty(s)) {
                    String[] filter = s.split("-");
                    String key = prefix + filter[0];
                    if (condition.get(key) == null) {
                        JSONArray jsonArray = new JSONArray();
                        condition.put(key, jsonArray);
                    }
                    condition.getJSONArray(key).add(filter[1]);
                }
            }
        }

        // price range
        if (!StringUtils.isEmpty(price)) {

        }
    }
}


