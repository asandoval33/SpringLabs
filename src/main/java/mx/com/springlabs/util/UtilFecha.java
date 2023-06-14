package mx.com.springlabs.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilFecha {

    public static void main(String[] args) {
        System.out.println(""+toYYYYMMDDHHMMSS(System.currentTimeMillis()));
    }

    public static String toYYYYMMDDHHMMSS(long time) {
        //SimpleDateFormat format = new SimpleDateFormat("M??d??H?m??s??");
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        return format.format(new Date(time));
    }

}
