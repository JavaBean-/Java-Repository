package xu.barry.interview.huawei;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateCalendar {

    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int y = in.nextInt();
            int m = in.nextInt();
            int wom = in.nextInt();
            int dow = in.nextInt();
            System.out.println(getCalendar(y, m, wom, dow));
        }
    }

    private static String getCalendar(int y, int m, int wom, int dow) {

        if (m > 12 || m < 1) return "0";
        if (wom > 6 || m < 0) return "0";
        if (dow > 7 || dow < 0) return "0";
        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = getDate(y, m, wom, dow, c);
        c.set(y,m,1);
        Date firstDayOfMonth = c.getTime();
        c.set(y,m,getDayOfMonth(y, m));
        Date lastDayOfMonth = c.getTime();
        if(date.after(lastDayOfMonth) || date.before(firstDayOfMonth)) return "0";
        return dateFormat.format(c.getTime());
    }

    private static int getDayOfMonth(int y, int m) {
        Calendar a = Calendar.getInstance();
        a.set(y, m, 0);
        return a.get(Calendar.DAY_OF_MONTH);
    }


    private static Date getDate(int y, int m, int wom, int dow, Calendar c) {
        c.set(Calendar.YEAR, y);
        c.set(Calendar.MONTH, m - 1);//set(Calendar.MONTH, 0) 0代表 1月份
        c.set(Calendar.WEEK_OF_MONTH, wom);
        c.set(Calendar.DAY_OF_WEEK, dow + 1);//set(Calendar.DAY_OF_WEEK, 1) 1代表 星期日
        return c.getTime();
    }

    public static void yesterdayOrTomorrow(String[] args) {
        Date date=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendar.DATE, -1);
        date = calendar.getTime();
        SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
        String dateString = format.format(date);
        System.out.println(dateString);
    }

}
