package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Helpers extends TestBase{

    public static String getTodaysDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        return sdf.format(date).toString();
    }

    public static String getDateInFuture() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 3);
        Date date = cal.getTime();
        return sdf.format(date).toString();
    }
}
