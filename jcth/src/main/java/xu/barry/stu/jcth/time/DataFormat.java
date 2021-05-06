package xu.barry.stu.jcth.time;

import org.junit.Test;
import xu.barry.stu.jcth.utils.Printer;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DataFormat {
    /**
     *  *  Text to parse        Parsed object                         Excess days
     *      *  "2012-12-03T00:00"   LocalDateTime.of(2012, 12, 3, 0, 0)   ZERO
     *      *  "2012-12-03T24:00"   LocalDateTime.of(2012, 12, 4, 0, 0)   ZERO
     *      *  "00:00"              LocalTime.of(0, 0)                    ZERO
     *      *  "24:00"              LocalTime.of(0, 0)                    Period.ofDays(1)
     *      * </pre>
     *      * The query can be used as follows:
     *      * <pre>
     *      *  TemporalAccessor parsed = formatter.parse(str);
     *      *  LocalTime time = parsed.query(LocalTime::from);
     *      *  Period extraDays = parsed.query(DateTimeFormatter.parsedExcessDays());
     */
    @Test
    public void testFormat(){
        LocalDateTime instance = LocalDateTime.now();
        DateTimeFormatter formatter1
                = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm");//16-04-2021 09:48
        DateTimeFormatter formatter2
                = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssSSSS").withZone(ZoneOffset.UTC);//2021-04-16 09:49:26

        System.out.println(formatter1.format(instance));
        System.out.println(formatter2.format(instance));
        Printer.partition();


        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();
        String localTime = df.format(time);
        LocalDateTime ldt = LocalDateTime.parse("2017-09-28 17:07:05",df);
        System.out.println("LocalDateTime转成String类型的时间："+localTime);
        System.out.println("String类型的时间转成LocalDateTime："+ldt);
        Printer.partition();


        ZonedDateTime zoneTime = ZonedDateTime.parse("2015-05-03T10:15:30+01:00[Europe/Paris]");
        ZonedDateTime zoneTime2 = ZonedDateTime.parse("2021-03-22T02:38:23+00:00");
        DateTimeFormatter ndf = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmssZ");
        ZonedDateTime zoneTime3 = ZonedDateTime.parse("20200703T135539+0000",ndf);
        Printer.println("Time2.getZone ---> Time3.getZone "+zoneTime2.getZone().toString()+"-->"+zoneTime3.getZone().toString());
        Printer.println("Time2 ---> Time3"+zoneTime2.toString() +"---->"+ zoneTime3.toString());
        Printer.println("zoneTime2 isBefore zoneTime3--->"+zoneTime2.toLocalDateTime().isBefore(zoneTime3.toLocalDateTime()));



    }

    @Test
    public void test(){
        Printer.println(ZonedDateTime.parse("2021-03-22T02:38:23+00:00").toLocalDateTime().toString());
        Printer.println(getLocalDate("collector-192.168.33.75-20200703T135539+0000.tar.gz").toString());
    }

    private static LocalDateTime getLocalDate(String fileName) {
        String parse = fileName.split("-")[fileName.split("-").length - 1]
                .replace(".tar.gz", "");
        return ZonedDateTime.parse(parse, DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmssZ"))
                .toLocalDateTime();
    }
}
